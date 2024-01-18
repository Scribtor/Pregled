package com.gunsh.coffeeshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.gunsh.coffeeshop.model.Coffee;
import com.gunsh.coffeeshop.service.CoffeeService;

@Controller
public class PageController {

    private final CoffeeService coffeeService;

    @Autowired
    public PageController(CoffeeService coffeeService) {
        this.coffeeService = coffeeService;
    }

    // HTML mappings
    @GetMapping("/")
    public String indexPage() {
        return "forward:/index.html";
    }

    @GetMapping("/home")
    public String homePage() {
        return "home";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    public String errorPage() {
        return "error";
    }

    @GetMapping("/admin")
    public String adminPage(Model model) {
        List<Coffee> coffeeList = coffeeService.getAllCoffees();
        model.addAttribute("coffeeList", coffeeList);
        return "admin";
    }
    

    // API mappings
    @PostMapping("/api/coffee/add")
    public ResponseEntity<String> addCoffee(@ModelAttribute Coffee coffee) {
        try {
            coffeeService.addCoffee(coffee);
            return new ResponseEntity<>("Coffee added successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/api/coffee/modify/{id}")
    public ResponseEntity<String> modifyCoffee(@PathVariable Long id, @RequestBody Coffee modifiedCoffee) {
        try {
            coffeeService.modifyCoffee(id, modifiedCoffee);
            return new ResponseEntity<>("Coffee modified successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/api/coffee/remove/{id}")
    public ResponseEntity<String> removeCoffee(@PathVariable Long id) {
        try {
            coffeeService.removeCoffee(id);
            return new ResponseEntity<>("Coffee removed successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/api/coffee/list")
    public ResponseEntity<List<Coffee>> getAllCoffees() {
        List<Coffee> allCoffees = coffeeService.getAllCoffees();
        return new ResponseEntity<>(allCoffees, HttpStatus.OK);
    }
    
    @GetMapping("/api/coffee/{id}")
    public ResponseEntity<Coffee> getCoffeeById(@PathVariable Long id) {
        try {
            Coffee coffee = coffeeService.getCoffeeById(id);
            return new ResponseEntity<>(coffee, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    
    @GetMapping("/favicon.ico")
    public String favicon() {
        return "forward:/resources/static/favicon.ico";
    }
}
