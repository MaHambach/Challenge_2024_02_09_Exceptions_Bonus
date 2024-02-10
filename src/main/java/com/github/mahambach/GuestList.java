package com.github.mahambach;

import lombok.Getter;
import lombok.Setter;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.io.IOException;

@Setter
@Getter
public class GuestList {
    private List<String> guests;

    public void writeToFile(String filename) {
        Path path = Paths.get(filename);
        try {
            Files.write(path, guests);
            System.out.println("Namen erfolgreich in Datei geschrieben.");
        } catch (IOException e) {
            System.err.println("Fehler beim Schreiben der Datei: " + e.getMessage());
        }
    }

    public void readFromFile(String filename) {
        Path path = Paths.get(filename);
        try {
            List<String> names = Files.readAllLines(path);
            System.out.println("Namen erfolgreich aus Datei gelesen.");
            this.guests.addAll(names);
        } catch (IOException e) {
            System.err.println("Fehler beim Lesen der Datei: " + e.getMessage());
        }
    }
}
