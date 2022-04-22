package com.gensparkproj.boardingpass.Entity;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public record Ticket(String ticketid,
                     String calendarDate,
                     String origin,
                     String destination,
                     String eta,
                     String departureTime,
                     String name,
                     String email,
                     String phoneNumber,
                     String gender,
                     String age,
                     String totalTicketPrice
                     ){
    private static final double BASE_PRICE = 2.75;
    private static final String FILE_NAME = "ticket";

    public static int getUnusedID() {
        for(int i = 0; i < Integer.MAX_VALUE; i++) {
            if(Files.exists(Path.of(FILE_NAME + i))) {
                return i;
            }
        }
        return -1;
    }

    public double getPrice() {
        double finalPrice = BASE_PRICE;
        for(Discount d : getDiscounts()) {
            finalPrice = d.apply(finalPrice);
        }
        return finalPrice;
    }

    public Set<Discount> getDiscounts() {
        int howOld = Integer.parseInt(age);
        Set<Discount> toReturn = new HashSet<>();
        if(howOld >= 60) {
            toReturn.add(new Discount("Senior Discount", 0.6));
        } else {
            if(howOld <= 12) {
                toReturn.add(new Discount("Youth Discount", 0.5));
            } else if(gender.equalsIgnoreCase("Female")) {
                toReturn.add(new Discount("Gender Equality Discount", 0.25));
            }
        }
        return toReturn;
    }

    public void save() throws IOException {
        BufferedWriter bPass = new BufferedWriter(new FileWriter(FILE_NAME+ticketid));
        writeLine(bPass, calendarDate);
        writeLine(bPass, origin);
        writeLine(bPass, destination);
        writeLine(bPass, eta);
        writeLine(bPass, departureTime);
        writeLine(bPass, name);
        writeLine(bPass, email);
        writeLine(bPass, phoneNumber);
        writeLine(bPass, gender);
        writeLine(bPass, age);
        writeLine(bPass, totalTicketPrice);
        bPass.close();
    }

    private void writeLine(BufferedWriter bw, String toWrite) throws IOException {
        bw.write(toWrite);
        bw.newLine();
    }

    public static Ticket load(String ticketid) throws IOException {
        ArrayList<String> returnme = new ArrayList<>(Files.readAllLines(Path.of(FILE_NAME+ticketid)));

        return new Ticket(ticketid, returnme.get(0), returnme.get(1), returnme.get(2), returnme.get(3), returnme.get(4),
                returnme.get(5), returnme.get(6), returnme.get(7), returnme.get(8), returnme.get(9), returnme.get(10));
    }
}


