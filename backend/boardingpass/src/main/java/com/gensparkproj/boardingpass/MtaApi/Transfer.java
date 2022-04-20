package com.gensparkproj.boardingpass.MtaApi;

public record Transfer (
        String from_stop_id,
        String stop_id,
        String transfer_type,
        String transfer_time
) implements Step {
    public Transfer(String[] args) {
        this(args[0], args[1], args[2], args[3]);
    }
}
