package com.gensparkproj.boardingpass.MtaApi;

import org.apache.commons.io.FileUtils;
import org.springframework.context.annotation.Bean;

import javax.persistence.Entity;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public final class NyctDataManager {
    private final String CONFIG_URL = "http://web.mta.info/developers/data/nyct/subway/google_transit.zip";
    private final String RESOURCE_PATH = "./src/main/resources/";
    private final HashMap<String, Stop> subwayStops = new HashMap<>();
    private final HashMap<Stop, Set<Transfer>> subwayTransfers = new HashMap<>();
    private final HashMap<String/*trip_id*/, List<StopTime>> subwayTrips = new HashMap<>();
    private final HashMap<Stop, Set<StopTime>> subwayStopTimes = new HashMap<>();

    private final HashMap<String, Trip> subwayTripInfo = new HashMap<>();
    private final HashMap<String, Calendar> subwayHours = new HashMap<>();

    /**
     * Creates a NYCT data manager that downloads all static info from MTA's website (as of now, no caching is provided),
     * and stores various parts of it in memory to perform calculations on.
     * @throws IOException Unable to download the static data .zip from MTA's website
     */
    public NyctDataManager() throws IOException {
        load();
    }

    /**
     * @return All possible 3-4 character MTA IDs for their subway stops
     */
    public Set<String> getAllStopIDs() {
        return subwayStops.keySet();
    }

    /**
     * @return The extended, human-readable names for each Subway stop
     */
    public Set<String> getAllStopNames() {
        return subwayStops.values().stream().map(Stop::stop_name).collect(Collectors.toSet());
    }

    /**
     * Finds all possible routes via the NYCT subway system on a given day, minus redundancies.
     * Only the quickest route to the destination Stop will be returned
     * Known issues:
     *      1. The fromTime parameter strictly enforces the given Date, which means if the passenger is looking for a train
     *          at 11:30pm, they might just be out of luck.
     * @param fromStopName The name of the origin Stop, as listed in getAllStopNames()
     * @param fromTime The time our passenger has arrived at the origin Stop, e.g. the earliest possible time
     *                 a train included in our route may depart from the origin Stop.
     *                 All trains are also required to leave on this date, but that will be changed in a future update
     * @return Returns a HashMap linking each final Destination with the fastest possible route to get there,
     *         which is described in StopTimes. The route will NOT include Stops the train passes where our passenger
     *         stays on board.
     */
    public Map<Stop, LinkedList<StopTime>> getPossibleDestinations(String fromStopName, LocalDateTime fromTime) {
        //E01N: World Trade Center
        Stop chosenStop = subwayStops.values().stream().filter(s -> s.stop_name().equalsIgnoreCase(fromStopName)).findFirst().orElseThrow();
        LocalDate chosenDay = fromTime.toLocalDate();
        LocalTime chosenTime = fromTime.toLocalTime();

        Set<LinkedList<StopTime>> paths = new HashSet<>();

        //System.out.println("Finding paths....");
        HashMap<String, LocalTime> earliestTimes = new HashMap<>();

        subwayStopTimes.get(chosenStop).stream()
                .map(st -> subwayTrips.get(st.trip_id()).subList(st.stop_sequence(), subwayTrips.get(st.trip_id()).size()))
                .flatMap(Collection::stream)
                .filter(st -> {
                    Calendar schedule = subwayHours.get(subwayTripInfo.get(st.trip_id()).service_id());
                    boolean withinDateRange =
                            ( ! chosenDay.isBefore( schedule.start_date() ) ) // Short way to say "is equal to or is after".
                                    &&
                                    chosenDay.isBefore( schedule.end_date() );
                    return schedule.days().contains(chosenDay.getDayOfWeek()) && withinDateRange && chosenTime.isBefore(st.arrival_time());
                })
                .forEach((firstStep) -> {
                    earliestTimes.put(firstStep.stop_id(), firstStep.arrival_time());
                    LinkedList<StopTime> path = new LinkedList<>();
                    LocalTime firstTime = firstStep.arrival_time();
                    path.add(firstStep);
                    paths.add(path);
                    findPaths(paths, chosenStop, chosenDay, firstTime, path, earliestTimes);
                });

        //System.out.println("Completed!");

        HashMap<Stop, LinkedList<StopTime>> fastestRoutes = new HashMap<>();

        //int i = 1;
        for(LinkedList<StopTime> path : paths) {
            /*System.out.println("Path "+(i++)+": ");
            for(StopTime st : path) {
                System.out.println("Take train to " + subwayStops.get(st.stop_id()).stop_id() + " at " + st.departure_time());
            }*/
            if(fastestRoutes.get(subwayStops.get(path.getLast().stop_id())) == null || (fastestRoutes.get(subwayStops.get(path.getLast().stop_id())).getLast()).departure_time().isAfter(path.getLast().departure_time())) {
                fastestRoutes.put(subwayStops.get(path.getLast().stop_id()), path);
            }
            //System.out.println();
        }
        //System.out.println(fastestRoutes.size());
        //System.out.println(subwayStops.size());
        return fastestRoutes;
    }

    private void findPaths(Set<LinkedList<StopTime>> masterSet, Stop forbiddenStop, LocalDate chosenDay, LocalTime lastTime, LinkedList<StopTime> toFollow, HashMap<String, LocalTime> earliest) {
        //if(toFollow.size() >= 10) {return;}
        StopTime lastStep = toFollow.getLast();
        subwayStopTimes.get(subwayStops.get(lastStep.stop_id())).stream()
                .map(st -> subwayTrips.get(st.trip_id()).subList(st.stop_sequence(), subwayTrips.get(st.trip_id()).size()))
                .flatMap(Collection::stream)
                .filter(st -> {
                    Calendar schedule = subwayHours.get(subwayTripInfo.get(st.trip_id()).service_id());
                    boolean withinDateRange =
                            ( ! chosenDay.isBefore( schedule.start_date() ) ) // Short way to say "is equal to or is after".
                                    &&
                                    chosenDay.isBefore( schedule.end_date() );

                    return schedule.days().contains(chosenDay.getDayOfWeek()) &&
                            withinDateRange &&
                            lastTime.isBefore(st.arrival_time()) &&
                            !subwayStops.get(st.stop_id()).equals(forbiddenStop) &&
                            !toFollow.contains(st) &&
                            (earliest.get(st.stop_id()) == null || earliest.get(st.stop_id()).isAfter(st.arrival_time()));
                })
                .forEach((thisStep) -> {
                    earliest.put(thisStep.stop_id(), thisStep.arrival_time());
                    LocalTime thisTime = thisStep.arrival_time();
                    LinkedList<StopTime> thisPath = (LinkedList<StopTime>) toFollow.clone();
                    thisPath.add(thisStep);
                    masterSet.add(thisPath);
                    findPaths(masterSet, forbiddenStop, chosenDay, thisTime, thisPath, earliest);
                });
    }

    private void load() throws IOException {
        File toDownload = new File("config.zip");
        FileUtils.copyURLToFile(new URL(CONFIG_URL), toDownload);
        ZipFile zipFile = new ZipFile(toDownload);
        var iterator = zipFile.entries();
        ZipEntry childFile;
        Map<String, InputStream> toParse = new HashMap<>();
        while(iterator.hasMoreElements() && (childFile = iterator.nextElement()) != null) {
            toParse.put(childFile.getName(), zipFile.getInputStream(childFile));
        }

        //Make sure stops.txt gets parsed first
        parseConfigFile("stops.txt", toParse.remove("stops.txt"));
        for (var entry : toParse.entrySet()) {parseConfigFile(entry.getKey(), entry.getValue());}
    }

    private void parseConfigFile(String fileName, InputStream fileStream) throws IOException {
        switch(fileName) {
            case "stops.txt" -> createPojos(fileStream, Stop.class, placeStops);
            case "transfers.txt" -> createPojos(fileStream, Transfer.class, placeTransfers);
            case "trips.txt" -> createPojos(fileStream, Trip.class, placeTrips);
            case "stop_times.txt" -> createPojos(fileStream, StopTime.class, placeStopTimes);
            case "calendar.txt" -> createPojos(fileStream, Calendar.class, placeCalendar);

        }
    }

    private final Consumer<Stop> placeStops = stop -> {
        subwayStops.putIfAbsent(stop.stop_id(), stop);
        subwayTransfers.putIfAbsent(stop, new HashSet<>());
        subwayStopTimes.putIfAbsent(stop, new HashSet<>());
    };

    private final Consumer<Transfer> placeTransfers = transfer -> {
        subwayTransfers.compute(subwayStops.get(transfer.from_stop_id()), (k, v) -> {
            if(v == null) {v = new HashSet<>();}
            v.add(transfer);
            return v;
        });
    };

    private final Consumer<Trip> placeTrips = trip -> {
        subwayTripInfo.putIfAbsent(trip.trip_id(), trip);
    };

    private final Consumer<Calendar> placeCalendar = cal -> {
        subwayHours.put(cal.service_id(), cal);
    };

    private final Consumer<StopTime> placeStopTimes = stopTime -> {
        subwayTrips.compute(stopTime.trip_id(), (k, v) -> {
            if(v == null) {v = new LinkedList<>();}
            v.add(stopTime.stop_sequence()-1, stopTime);
            return v;
        });
        subwayStopTimes.compute(subwayStops.get(stopTime.stop_id()), (k, v) -> {
            if(v == null) {v = new HashSet<>();}
            v.add(stopTime);
            return v;
        });
    };

    private void createPojos(InputStream toConvert, Class<?> toInstantiate, Consumer toApply) throws IOException {
        Stream.of(new String(toConvert.readAllBytes()).split("\n"))
                .skip(1)//Header
                .map(str -> {
                    try {
                        return toInstantiate.getConstructor(String[].class).newInstance((Object) str.split(","));
                    } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                        e.printStackTrace();
                        return null;
                    }
                })
                .forEach(toApply);
    }

    private Path getFile(String fileToGet) {
        return Path.of(RESOURCE_PATH + fileToGet);
    }
}
