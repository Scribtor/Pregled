package com.gunsh.coffeeshop.repository;

import com.gunsh.coffeeshop.model.Barista;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BaristaRepositoryImpl implements BaristaRepository {

    private static final String DATA_FILE_PATH = "data/baristas.txt";

    @Override
    public void save(Barista barista) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DATA_FILE_PATH, true))) {
            writer.write(String.format("%s|%s|%s",
                    barista.getName(), barista.getCoffeeGrinderCapacity(), barista.getCurrentCoffeeAmount()));
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
    }

    @Override
    public Barista findById(String name) {
        // Implement the logic to find a Barista by name
        return null;
    }

    @Override
    public List<Barista> findAll() {
        List<Barista> baristas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(DATA_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                Barista barista = new Barista(parts[0], Integer.parseInt(parts[1]));
                barista.setCurrentCoffeeAmount(Integer.parseInt(parts[2]));
                baristas.add(barista);
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
        return baristas;
    }

    @Override
    public void update(Barista barista) {
        // Implement the logic to update a Barista
    }

    @Override
    public void delete(String name) {
        // Implement the logic to delete a Barista
    }
}
