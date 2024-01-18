package com.gunsh.coffeeshop.repository;

import com.gunsh.coffeeshop.model.Barman;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BarmanRepositoryImpl implements BarmanRepository {

    private static final String DATA_FILE_PATH = "src/data/barman.txt";

    @Override
    public void save(Barman bartender) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DATA_FILE_PATH, true))) {
            writer.write(String.format("%s",
                    bartender.getName()));
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
    }

    @Override
    public List<Barman> findAll() {
        List<Barman> barmen = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(DATA_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Create a new Barman object with the name from the line
                Barman barman = new Barman(line.trim());  // Use trim to remove leading/trailing whitespaces
                barmen.add(barman);
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
        return barmen;
    }
}
