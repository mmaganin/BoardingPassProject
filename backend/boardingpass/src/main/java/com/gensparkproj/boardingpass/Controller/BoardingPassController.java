package com.gensparkproj.boardingpass.Controller;

import com.gensparkproj.boardingpass.Dao.BoardingPassDao;
import com.gensparkproj.boardingpass.Dao.CustomerDao;
import com.gensparkproj.boardingpass.Dao.TrainDao;
import com.gensparkproj.boardingpass.Dao.TrainTicketDao;
import com.gensparkproj.boardingpass.Entity.CustomerTravelInfo;
import com.gensparkproj.boardingpass.Entity.JsonableStopTime;
import com.gensparkproj.boardingpass.Entity.StopAndTimes;
import com.gensparkproj.boardingpass.Entity.Ticket;
import com.gensparkproj.boardingpass.MtaApi.NyctDataManager;
import com.gensparkproj.boardingpass.MtaApi.Stop;
import com.gensparkproj.boardingpass.MtaApi.StopTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

//Configures this class to be the Spring Boot controller class
@RestController
public class BoardingPassController {
    //Autowired automatically initializes these dependencies without having to create new objects (Spring Boot feature)
    @Autowired
    BoardingPassDao boardingPassDao;
    @Autowired
    CustomerDao customerDao;
    @Autowired
    TrainDao trainDao;
    @Autowired
    TrainTicketDao trainTicketDao;

    NyctDataManager nyctDataManager;


    //Test frontend communication with post request, crossorigin present to bypass cors policy
    @PostMapping("/searchresults")
    @CrossOrigin(origins = "http://localhost:3000")
    public List<StopAndTimes> getPossibleDestinations(@RequestBody CustomerTravelInfo customerTravelInfo) throws IOException {
        nyctDataManager = new NyctDataManager();

        String time = customerTravelInfo.getDeparture_time();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        Map<Stop, LinkedList<StopTime>> fastestRoutes = nyctDataManager.getPossibleDestinations(customerTravelInfo.getFrom_location(), LocalDateTime.parse(time, dateTimeFormatter));

        List<StopAndTimes> stopAndTimesList = new LinkedList<>();
        String eta;
        String departTime;
        LinkedList<StopTime> stopTimes;

//        List<JsonableStopTime> jsonableStopTimes;
        for(var entry : fastestRoutes.entrySet()){
//            jsonableStopTimes = new LinkedList<>();
//            for(var stopTime : entry.getValue()){
//                jsonableStopTimes.add(new JsonableStopTime(stopTime));
//            }

            stopTimes = entry.getValue();
            eta = stopTimes.getLast().arrival_time().toString();
            departTime = stopTimes.get(0).departure_time().toString();

            stopAndTimesList.add(new StopAndTimes(entry.getKey(), eta, departTime));
        }


        return stopAndTimesList;
    }

    //post request to get ticket info, generate ticket, and send back to front end
    @PostMapping("/ticket")
    @CrossOrigin(origins = "http://localhost:3000")
    public Ticket getTicket(@RequestBody Ticket ticketInfo) throws IOException {
        String ticket_id = "0";
        String ticket_price = "0";

        ticket_id = String.valueOf(Ticket.getUnusedID());
        ticket_price = String.valueOf(ticketInfo.getPrice());

        Ticket newTicket = new Ticket(ticket_id, ticketInfo.calendar_date(), ticketInfo.origin(),
                ticketInfo.destination(), ticketInfo.eta(), ticketInfo.departure_time(), ticketInfo.name(),
                ticketInfo.email(), ticketInfo.phone_number(), ticketInfo.gender(), ticketInfo.age(), ticket_price);

        newTicket.save();

        return newTicket;
    }
}
