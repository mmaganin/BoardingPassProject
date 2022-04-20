public record CalendarDate(
        String service_id,
        String date,
        String exception_type
) {
    public CalendarDate(String[] args) {
        this(args[0], args[1], args.length > 2 ? args[2] : "");
    }
}
