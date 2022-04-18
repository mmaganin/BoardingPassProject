package com.gensparkproj.boardingpass.Controller;

import com.gensparkproj.boardingpass.Dao.BoardingPassDao;
import com.gensparkproj.boardingpass.Dao.CustomerDao;
import com.gensparkproj.boardingpass.Dao.TrainDao;
import com.gensparkproj.boardingpass.Dao.TrainTicketDao;
import com.gensparkproj.boardingpass.Entity.BoardingPass;
import com.gensparkproj.boardingpass.Entity.Customer;
import com.gensparkproj.boardingpass.Entity.TrainTicket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BoardingPassController {
    @Autowired
    BoardingPassDao boardingPassDao;
    @Autowired
    CustomerDao customerDao;
    @Autowired
    TrainDao trainDao;
    @Autowired
    TrainTicketDao trainTicketDao;

    //Test db communication with get request
    @GetMapping("/")
    public void addCustomer(){
        BoardingPass boardingPass = new BoardingPass();
        boardingPass.setCustomer_id(1);
        boardingPass.setTicket_id(1);
        boardingPass.setBoardingPassNum(1);
        boardingPassDao.save(boardingPass);
    }
}
