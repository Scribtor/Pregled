package com.gunsh.coffeeshop.model;

public class Bartender {

    private String name;
    private int maxOrdersAccepted;

    public Bartender(String name, int maxOrdersAccepted) {
        this.name = name;
        this.maxOrdersAccepted = maxOrdersAccepted;
    }

    public String getName() {
        return name;
    }

    public int getMaxOrdersAccepted() {
        return maxOrdersAccepted;
    }
}
