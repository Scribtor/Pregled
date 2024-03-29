package com.gunsh.coffeeshop.repository;

import com.gunsh.coffeeshop.model.Barista;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BaristaRepositoryImpl implements BaristaRepository {

    private static final String DATA_FILE_PATH = "src/data/baristas.txt";

    @Override
    public void save(Barista barista) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DATA_FILE_PATH, true))) {
            writer.write(String.format("%s",
                    barista.getName()));
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
    }

    @Override
    public List<Barista> findAll() {
        List<Barista> baristas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(DATA_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Create a new Barista object with the name from the line
                Barista barista = new Barista(line.trim());  // Use trim to remove leading/trailing whitespaces
                baristas.add(barista);
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
        return baristas;
    }
}
