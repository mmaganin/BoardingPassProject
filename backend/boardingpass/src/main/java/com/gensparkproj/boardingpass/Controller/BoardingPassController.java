package com.gensparkproj.boardingpass.Controller;

import com.gensparkproj.boardingpass.Dao.BoardingPassDao;
import com.gensparkproj.boardingpass.Dao.CustomerDao;
import com.gensparkproj.boardingpass.Dao.TrainDao;
import com.gensparkproj.boardingpass.Dao.TrainTicketDao;
import com.gensparkproj.boardingpass.Entity.CustomerTravelInfo;
import com.gensparkproj.boardingpass.MtaApi.NyctDataManager;
import com.gensparkproj.boardingpass.MtaApi.Stop;
import com.gensparkproj.boardingpass.MtaApi.StopTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.Map;

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


    //Test db communication with get request
    @GetMapping("/searchresults")
    public Map<Stop, LinkedList<StopTime>> getPossibleDestinations(@RequestBody CustomerTravelInfo customerTravelInfo) throws IOException {
        nyctDataManager = new NyctDataManager();

        String time = customerTravelInfo.getDeparture_time();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        return nyctDataManager.getPossibleDestinations(customerTravelInfo.getFrom_location(), LocalDateTime.parse(time, dateTimeFormatter));
    }
}
