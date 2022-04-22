package com.gensparkproj.boardingpass.Entity;

public record Discount(String name, double percent, double flatReduc) {
    public double apply(double origPrice) {
        return (origPrice - flatReduc) * (1 - percent);
    }

    public Discount(String name, double percent) {
        this(name, percent, 0);
    }
}
