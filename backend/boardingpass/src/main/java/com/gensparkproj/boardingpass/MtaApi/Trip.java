public record Trip(
        String route_id,
        String service_id,
        String trip_id,
        String trip_headsign,
        String direction_id,
        String block_id,
        String shape_id
) {
    public Trip(String[] args) {
        this(args[0], args[1], args[2], args[3], args[4], args[5], args.length > 6 ? args[6] : "");
    }
}
