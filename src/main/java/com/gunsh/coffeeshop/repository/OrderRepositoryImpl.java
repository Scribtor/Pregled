package com.gunsh.coffeeshop.repository;

import com.gunsh.coffeeshop.model.*;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrderRepositoryImpl implements OrderRepository {

    private static final String DATA_FILE_PATH = "data/orders.txt";

    @Override
    public void save(Order order) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DATA_FILE_PATH, true))) {
            writer.write(String.format("%s|%s|%s",
                    order.getCoffee().getType(), order.getOrderTime(), order.isToGo()));
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
    }

    @Override
    public Order findById(String orderId) {
        // Implement the logic to find an Order by ID
        return null;
    }

    @Override
    public List<Order> findAll() {
        List<Order> orders = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(DATA_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                // Assuming the Coffee class has a static method for creating from a string
                Order order = new Order(Coffee.fromFileString(parts[0]), Boolean.parseBoolean(parts[2]));
                order.setOrderTime(LocalDateTime.parse(parts[1])); // Assuming LocalDateTime for order time
                orders.add(order);
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
        return orders;
    }

    @Override
    public void update(Order order) {
        // Implement the logic to update an Order
    }

    @Override
    public void delete(String orderId) {
        // Implement the logic to delete an Order
    }
}
