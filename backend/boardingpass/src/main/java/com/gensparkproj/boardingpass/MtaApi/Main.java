package com.gensparkproj.boardingpass.MtaApi;

import com.google.protobuf.ExtensionRegistry;
import com.google.transit.realtime.GtfsRealtime;
import com.google.transit.realtime.GtfsRealtimeNYCT;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    private static final String yellowRoutes = "https://api-endpoint.mta.info/Dataservice/mtagtfsfeeds/nyct%2Fgtfs-nqrw";

    public static void main(String[] args) throws IOException {
        FeedId feedId = FeedId.FLUSHING;

        ExtensionRegistry registry = ExtensionRegistry.newInstance();
        registry.add(GtfsRealtimeNYCT.nyctFeedHeader);
        registry.add(GtfsRealtimeNYCT.nyctStopTimeUpdate);
        registry.add(GtfsRealtimeNYCT.nyctTripDescriptor);

        //Change this to another feed
        URL url = getFeedUrlFromFeedId(feedId);
        System.out.println("getting feed from " + url.toString());

        GtfsRealtime.FeedMessage feed = null;
        try {
            InputStream stream = StreamUtil.getUrlInputStream(url);
            feed = GtfsRealtime.FeedMessage.parseFrom(stream, registry);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (feed != null) {
            //noinspection CodeBlock2Expr
            feed.getEntityList()
                    .stream()
                    .filter(GtfsRealtime.FeedEntity::hasTripUpdate)
                    .forEach(entity -> {
                        System.out.println(entity.getTripUpdate().toString());
                    });
        }

    }

    //https://api-endpoint.mta.info/Dataservice/mtagtfsfeeds/nyct%2Fgtfs-ace
    static URL getFeedUrlFromFeedId(FeedId id) {
        String baseUrlWithoutFeed = "https://api-endpoint.mta.info/Dataservice/mtagtfsfeeds/nyct%2Fgtfs";
        String urlString = baseUrlWithoutFeed + "-" + id.getValue();

        URL url = null;
        try {
            url = new URL(urlString);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }

    private static String getCred(String credName) throws IOException {
        return new String(Files.readAllBytes(Path.of("./src/main/resources/"+credName)));
    }
}
