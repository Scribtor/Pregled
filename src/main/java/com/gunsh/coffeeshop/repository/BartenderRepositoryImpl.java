package com.gunsh.coffeeshop.repository;

import com.gunsh.coffeeshop.model.Bartender;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BartenderRepositoryImpl implements BartenderRepository {

    private static final String DATA_FILE_PATH = "data/bartenders.txt";

    @Override
    public void save(Bartender bartender) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DATA_FILE_PATH, true))) {
            writer.write(String.format("%s|%s",
                    bartender.getName(), bartender.getMaxOrdersAccepted()));
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
    }

    @Override
    public Bartender findById(String name) {
        // Implement the logic to find a Bartender by name
        return null;
    }

    @Override
    public List<Bartender> findAll() {
        List<Bartender> bartenders = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(DATA_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                Bartender bartender = new Bartender(parts[0], Integer.parseInt(parts[1]));
                bartenders.add(bartender);
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
        return bartenders;
    }

    @Override
    public void update(Bartender bartender) {
        // Implement the logic to update a Bartender
    }

    @Override
    public void delete(String name) {
        // Implement the logic to delete a Bartender
    }
}
