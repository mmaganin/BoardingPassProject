package com.gensparkproj.boardingpass.Entity;

import com.gensparkproj.boardingpass.MtaApi.Stop;

import java.util.LinkedList;
import java.util.List;

public class StopAndTimes {
    private Stop stop;
    private List<JsonableStopTime> jsonableStopTimes;

    public StopAndTimes(Stop stop, List<JsonableStopTime> jsonableStopTimes) {
        this.stop = stop;
        this.jsonableStopTimes = jsonableStopTimes;
    }

    public Stop getStop() {
        return stop;
    }

    public void setStop(Stop stop) {
        this.stop = stop;
    }

    public List<JsonableStopTime> getJsonableStopTimes() {
        return jsonableStopTimes;
    }

    public void setJsonableStopTimes(List<JsonableStopTime> jsonableStopTimes) {
        this.jsonableStopTimes = jsonableStopTimes;
    }

    @Override
    public String toString() {
        return "StopAndTimes{" +
                "stop=" + stop +
                ", jsonableStopTimes=" + jsonableStopTimes +
                '}';
    }
}
