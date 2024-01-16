package com.gunsh.coffeeshop.repository;

import com.gunsh.coffeeshop.model.Coffee;
import org.springframework.stereotype.Repository;

@Repository
public interface CoffeeRepository {

    void save(Coffee coffee);

    Iterable<Coffee> findAll();

    // Add other methods for specific queries or operations if needed
}
