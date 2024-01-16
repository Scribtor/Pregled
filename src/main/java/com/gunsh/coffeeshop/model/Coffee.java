package com.gunsh.coffeeshop.model;

public class Coffee {

    private String type;
    private double price;
    private int preparationTime;
    private int coffeeAmountInGrams;
    private String pictureUrl;

    public Coffee(String type, double price, int preparationTime, int coffeeAmountInGrams, String pictureUrl) {
        this.type = type;
        this.price = price;
        this.preparationTime = preparationTime;
        this.coffeeAmountInGrams = coffeeAmountInGrams;
        this.pictureUrl = pictureUrl;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public int getPreparationTime() {
        return preparationTime;
    }

    public int getCoffeeAmountInGrams() {
        return coffeeAmountInGrams;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    // Additional methods for serialization/deserialization, if needed
    public String toFileString() {
        // Convert Coffee object to a string for saving to a file
        // Format: type|price|preparationTime|coffeeAmountInGrams|pictureUrl
        return String.format("%s|%s|%s|%s|%s", type, price, preparationTime, coffeeAmountInGrams, pictureUrl);
    }

    public static Coffee fromFileString(String fileString) {
        // Convert string from the file to a Coffee object
        String[] parts = fileString.split("\\|");
        return new Coffee(parts[0], Double.parseDouble(parts[1]), Integer.parseInt(parts[2]),
                Integer.parseInt(parts[3]), parts[4]);
    }
}
