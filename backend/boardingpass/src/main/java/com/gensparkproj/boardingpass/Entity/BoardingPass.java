package com.gensparkproj.boardingpass.Entity;

import javax.persistence.*;

@Entity
@Table(name="tbl_boardingpass")
public class BoardingPass {
    @Id
    @Column(name="boardingpass_num")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int boardingPassNum;
    int ticket_id;
    int customer_id;

    public BoardingPass(){

    }

    public int getBoardingPassNum() {
        return boardingPassNum;
    }

    public void setBoardingPassNum(int boardingPassNum) {
        this.boardingPassNum = boardingPassNum;
    }

    public int getTicket_id() {
        return ticket_id;
    }

    public void setTicket_id(int ticket_id) {
        this.ticket_id = ticket_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    @Override
    public String toString() {
        return "BoardingPass{" +
                "boardingPassNum=" + boardingPassNum +
                ", ticket_id=" + ticket_id +
                ", customer_id=" + customer_id +
                '}';
    }
}
