package com.gensparkproj.boardingpass.Entity;

import org.springframework.context.annotation.Bean;

import javax.persistence.Entity;

public class CustomerTravelInfo {
    private String from_location;
    private String departure_time;

    public String getFrom_location() {
        return from_location;
    }

    public void setFrom_location(String from_location) {
        this.from_location = from_location;
    }

    public String getDeparture_time() {
        return departure_time;
    }

    public void setDeparture_time(String departure_time) {
        this.departure_time = departure_time;
    }

    @Override
    public String toString() {
        return "CustomerTravelInfo{" +
                "from_location='" + from_location + '\'' +
                ", departure_time='" + departure_time + '\'' +
                '}';
    }
}
