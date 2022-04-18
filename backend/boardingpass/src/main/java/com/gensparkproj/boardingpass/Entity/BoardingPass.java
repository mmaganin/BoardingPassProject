package com.gensparkproj.boardingpass.Entity;

import javax.persistence.Id;

public class BoardingPass {
    @Id
    int boardingPassNum;

    Customer customer;
    TrainTicket trainTicket;

    public int getBoardingPassNum() {
        return boardingPassNum;
    }

    public void setBoardingPassNum(int boardingPassNum) {
        this.boardingPassNum = boardingPassNum;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public TrainTicket getTrainTicket() {
        return trainTicket;
    }

    public void setTrainTicket(TrainTicket trainTicket) {
        this.trainTicket = trainTicket;
    }

    @Override
    public String toString() {
        return "BoardingPass{" +
                "boardingPassNum=" + boardingPassNum +
                ", customer=" + customer +
                ", trainTicket=" + trainTicket +
                '}';
    }
}
