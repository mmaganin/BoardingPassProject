package com.gensparkproj.boardingpass.MtaApi;

import java.time.LocalTime;

public record StopTime(
        String trip_id,
        LocalTime arrival_time,
        LocalTime departure_time,
        String stop_id,
        int stop_sequence,
        String stop_headsign,
        String pickup_type,
        String drop_off_type,
        String shape_dist_traveled
) {
    public StopTime(String[] args) {
        this(args[0], getTime(args[1]), getTime(args[2]), args[3], Integer.parseInt(args[4]), args[5], args[6], args[7], args.length > 8 ? args[8] : "");
    }

    private static LocalTime getTime(String time) {
        String[] fields = time.split(":");
        return LocalTime.of(Integer.parseInt(fields[0]) % 24,
                        Integer.parseInt(fields[1]),
                        Integer.parseInt(fields[2]));
    }
}
