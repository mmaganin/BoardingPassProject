package com.gensparkproj.boardingpass.MtaApi;

public record Route(
        String route_id,
        String agency_id,
        String route_short_name,
        String route_long_name,
        String route_desc,
        String route_type,
        String route_url,
        String route_color,
        String route_text_color
) {
    public Route(String[] args) {
        this(args[0], args[1], args[2], args[3], args[4], args[5], args[6], args[7], args.length > 8 ? args[8] : "");
    }
}
