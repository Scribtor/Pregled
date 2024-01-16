package com.gunsh.coffeeshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gunsh.coffeeshop.model.Coffee;
import com.gunsh.coffeeshop.repository.CoffeeRepository;

@Service
public class CoffeeService {

    // Assuming you have a data repository for coffee orders
    public final CoffeeRepository coffeeRepository;

    @Autowired
    public CoffeeService(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }

    public void placeOrder(Coffee coffee) throws Exception {
        // Add business logic for placing orders
        if (isCoffeeAvailable(coffee)) {
            coffeeRepository.save(coffee);
        } else {
            throw new Exception("Selected coffee is not available");
        }
    }

    public Iterable<Coffee> getCoffeeMenu() {
        // Assuming you have a method to retrieve the coffee menu from your data repository
        return coffeeRepository.findAll();
    }

    // Additional business logic methods
    private boolean isCoffeeAvailable(Coffee coffee) {
        // Implement logic to check if the selected coffee is available
        // For example, check if there is enough coffee in the grinder
        // You can access barista or grinder details from your data repository
        // Return true if available, false otherwise
        return true;  // Placeholder, replace with actual logic
    }
}
