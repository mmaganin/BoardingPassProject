package com.gensparkproj.boardingpass;

public class TrainTicket {
    int ticket_id;
    Train train;
    int ticketPrice;

    public int getTicket_id() {
        return ticket_id;
    }

    public void setTicket_id(int ticket_id) {
        this.ticket_id = ticket_id;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public int getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    @Override
    public String toString() {
        return "TrainTicket{" +
                "ticket_id=" + ticket_id +
                ", train=" + train +
                ", ticketPrice=" + ticketPrice +
                '}';
    }
}
