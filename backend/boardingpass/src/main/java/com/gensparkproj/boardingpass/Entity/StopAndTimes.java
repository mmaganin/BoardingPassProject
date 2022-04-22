package com.gensparkproj.boardingpass.Entity;

import com.gensparkproj.boardingpass.MtaApi.Stop;

import java.util.LinkedList;
import java.util.List;

public class StopAndTimes {
    private Stop stop;
    private String eta;
    private String depart_time;

    public StopAndTimes(Stop stop, String eta, String depart_time) {
        this.stop = stop;
        this.eta = eta;
        this.depart_time = depart_time;
    }

    public Stop getStop() {
        return stop;
    }

    public void setStop(Stop stop) {
        this.stop = stop;
    }

    public String getEta() {
        return eta;
    }

    public void setEta(String eta) {
        this.eta = eta;
    }

    public String getDepart_time() {
        return depart_time;
    }

    public void setDepart_time(String depart_time) {
        this.depart_time = depart_time;
    }

    @Override
    public String toString() {
        return "StopAndTimes{" +
                "stop=" + stop +
                ", eta='" + eta + '\'' +
                ", depart_time='" + depart_time + '\'' +
                '}';
    }
}
