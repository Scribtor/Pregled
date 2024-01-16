package com.gunsh.coffeeshop.controller;

import com.gunsh.coffeeshop.model.Coffee;
import com.gunsh.coffeeshop.service.CoffeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/coffee")
public class CoffeeController {

    private final CoffeeService coffeeService;

    @Autowired
    public CoffeeController(CoffeeService coffeeService) {
        this.coffeeService = coffeeService;
    }

    @PostMapping("/order")
    public ResponseEntity<String> placeOrder(@RequestBody Coffee coffee) {
        try {
            coffeeService.placeOrder(coffee);
            return new ResponseEntity<>("Order placed successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/menu")
    public ResponseEntity<Iterable<Coffee>> getCoffeeMenu() {
        Iterable<Coffee> coffeeMenu = coffeeService.getCoffeeMenu();
        return new ResponseEntity<>(coffeeMenu, HttpStatus.OK);
    }
}
