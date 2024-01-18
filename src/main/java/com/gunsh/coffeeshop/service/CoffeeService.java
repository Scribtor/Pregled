package com.gunsh.coffeeshop.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.gunsh.coffeeshop.model.Coffee;

@Service
public class CoffeeService {

    private final List<Coffee> coffeeList = new ArrayList<>();
    private final File file = new File("src/data/coffees.txt");

    public CoffeeService() {
        // Load existing data from file on service initialization
        loadDataFromFile();
    }

    public Coffee addCoffee(Coffee coffee) {
        coffee.setId(System.currentTimeMillis()); // Generate a simple unique ID
        coffeeList.add(coffee);
        saveDataToFile();
        return coffee;
    }

    public void removeCoffee(Long id) {
        coffeeList.removeIf(coffee -> coffee.getId().equals(id));
        saveDataToFile();
    }

    public Coffee modifyCoffee(Long id, Coffee modifiedCoffee) {
        Coffee existingCoffee = coffeeList.stream().filter(coffee -> coffee.getId().equals(id)).findFirst().orElse(null);
        if (existingCoffee != null) {
            existingCoffee.setType(modifiedCoffee.getType());
            existingCoffee.setPrice(modifiedCoffee.getPrice());
            existingCoffee.setAmountOfCoffeeInGrams(modifiedCoffee.getAmountOfCoffeeInGrams());
            existingCoffee.setTimeToBrew(modifiedCoffee.getTimeToBrew());
            existingCoffee.setPicture(modifiedCoffee.getPicture());
            saveDataToFile();
        }
        return existingCoffee;
    }

    public List<Coffee> getAllCoffees() {
        return new ArrayList<>(coffeeList); // Return a copy to prevent external modification
    }

    private void loadDataFromFile() {
    	coffeeList.clear();
        if (file.exists() && file.isFile()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",");
                    if (parts.length == 6) { // Ensure correct number of fields
                        Coffee coffee = new Coffee();
                        
                        coffee.setType(parts[0]);
                        coffee.setPrice(Double.parseDouble(parts[1]));
                        coffee.setPicture(parts[2]);
                        coffee.setAmountOfCoffeeInGrams(Integer.parseInt(parts[3]));
                        coffee.setTimeToBrew(Integer.parseInt(parts[4]));
                        coffee.setId(Long.parseLong(parts[5]));
                        coffeeList.add(coffee);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void saveDataToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (Coffee coffee : coffeeList) {
                writer.write(String.format("%s,%.2f,%s,%d,%d,%d",
                        coffee.getType(),
                        coffee.getPrice(),
                        coffee.getPicture(),
                        coffee.getAmountOfCoffeeInGrams(),
                        coffee.getTimeToBrew(),
                        coffee.getId()));
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public Coffee getCoffeeById(Long id) {
        loadDataFromFile(); // Ensure data is loaded from file

        // Find the coffee with the specified ID
        for (Coffee coffee : coffeeList) {
            if (coffee.getId().equals(id)) {
                return coffee; // Found the coffee with the specified ID
            }
        }

        return null; // Coffee with the specified ID not found
    }

}
