package com.gensparkproj.boardingpass.Entity;

import com.gensparkproj.boardingpass.Entity.Train;

import javax.persistence.*;

//POJO to represent a train ticket's info
@Entity
@Table(name="tbl_trainticket")
public class TrainTicket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int ticket_id;

    @Column(name = "ticket_price")
    int ticketPrice;

    int train_id;

    public int getTicket_id() {
        return ticket_id;
    }

    public void setTicket_id(int ticket_id) {
        this.ticket_id = ticket_id;
    }

    public int getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public int getTrain_id() {
        return train_id;
    }

    public void setTrain_id(int train_id) {
        this.train_id = train_id;
    }

    @Override
    public String toString() {
        return "TrainTicket{" +
                "ticket_id=" + ticket_id +
                ", ticketPrice=" + ticketPrice +
                ", train_id=" + train_id +
                '}';
    }
}
