package com.gensparkproj.boardingpass.Entity;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

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



    public void save() throws IOException {
        BufferedWriter bPass = new BufferedWriter(new FileWriter("bpass" +ticketid));
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
        ArrayList<String> returnme = new ArrayList<>(Files.readAllLines(Path.of("bpass" +ticketid)));

        Ticket bPassed = new Ticket(ticketid, returnme.get(0), returnme.get(1), returnme.get(2), returnme.get(3), returnme.get(4),
                returnme.get(5), returnme.get(6), returnme.get(7), returnme.get(8), returnme.get(9), returnme.get(10));
        return bPassed;
    }
}


