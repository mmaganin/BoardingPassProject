package com.gensparkproj.boardingpass.Entity;

import javax.persistence.*;

//POJO to represent a train's travel info
@Entity
@Table(name="tbl_train")
public class Train {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int train_id;

    @Column(name = "departure_time")
    String departureTime;

    String date;
    String origin;
    String destination;
    String eta;

    public int getTrain_id() {
        return train_id;
    }

    public void setTrain_id(int train_id) {
        this.train_id = train_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getEta() {
        return eta;
    }

    public void setEta(String eta) {
        this.eta = eta;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    @Override
    public String toString() {
        return "Train{" +
                "train_id=" + train_id +
                ", date='" + date + '\'' +
                ", origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", eta='" + eta + '\'' +
                ", departureTime='" + departureTime + '\'' +
                '}';
    }
}
