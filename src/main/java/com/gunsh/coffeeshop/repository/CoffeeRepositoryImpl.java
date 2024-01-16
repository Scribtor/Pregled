package com.gunsh.coffeeshop.repository;

import com.gunsh.coffeeshop.model.Coffee;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CoffeeRepositoryImpl implements CoffeeRepository {

    private static final String DATA_FILE_PATH = "data/coffees.txt";

    @Override
    public void save(Coffee coffee) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DATA_FILE_PATH, true))) {
            // Assuming a simple format for storing data in the text file
            writer.write(coffee.toFileString());
            writer.newLine();
        } catch (IOException e) {
            // Handle the exception (log it, throw a custom exception, etc.)
            e.printStackTrace();
        }
    }

    @Override
    public Iterable<Coffee> findAll() {
        List<Coffee> coffees = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(DATA_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Assuming a simple format for reading data from the text file
                coffees.add(Coffee.fromFileString(line));
            }
        } catch (IOException e) {
            // Handle the exception (log it, throw a custom exception, etc.)
            e.printStackTrace();
        }
        return coffees;
    }
    
    // You might need to add other methods for specific queries or operations
}
