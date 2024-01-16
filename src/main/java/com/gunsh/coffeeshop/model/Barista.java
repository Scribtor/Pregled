package com.gunsh.coffeeshop.model;

public class Barista {

    private String name;
    private int coffeeGrinderCapacity;
    private int currentCoffeeAmount;

    public Barista(String name, int coffeeGrinderCapacity) {
        this.name = name;
        this.coffeeGrinderCapacity = coffeeGrinderCapacity;
        this.currentCoffeeAmount = coffeeGrinderCapacity; // Initially, the grinder is full
    }

    public String getName() {
        return name;
    }

    public int getCoffeeGrinderCapacity() {
        return coffeeGrinderCapacity;
    }

    public int getCurrentCoffeeAmount() {
        return currentCoffeeAmount;
    }

    public void setCurrentCoffeeAmount(int currentCoffeeAmount) {
        this.currentCoffeeAmount = currentCoffeeAmount;
    }
}
