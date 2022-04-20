package com.gensparkproj.boardingpass.MtaApi;

public record Stop(
        String stop_id,
        String stop_code,
        String stop_name,
        String stop_desc,
        Coordinate stop_coords,
        String zone_id,
        String stop_url,
        String location_type,
        String parent_station
) {
    public Stop(String[] arr) {
        this(arr[0], arr[1], arr[2], arr[3],
                new Coordinate(Double.parseDouble(arr[4]), Double.parseDouble(arr[5])),
                arr[6], arr[7], arr[8],
                arr.length >= 10 ? arr[9] : "");
    }
}
