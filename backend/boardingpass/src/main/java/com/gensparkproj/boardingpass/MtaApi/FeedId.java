package com.gensparkproj.boardingpass.MtaApi;

/**
 * Helper for translating feeds to their integer ID
 * 7 Line is labeled FLUSHING below
 */
public enum FeedId {
    A_DIVISION("gtfs"),
    ACE("gtfs-ace"),
    NQRW("nqrw"),
    BD("bd"),
    L("l"),
    SIR("si"), //https://api-endpoint.mta.info/Dataservice/mtagtfsfeeds/nyct%2Fgtfs-si
    G("g"), //https://api-endpoint.mta.info/Dataservice/mtagtfsfeeds/nyct%2Fgtfs-g
    JZ("jz"), //https://api-endpoint.mta.info/Dataservice/mtagtfsfeeds/nyct%2Fgtfs-jz
    FLUSHING("bdfm"); //https://api-endpoint.mta.info/Dataservice/mtagtfsfeeds/nyct%2Fgtfs-bdfm


    private final String value;

    FeedId(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
