package com.gunsh.coffeeshop.model;

public class Barman {

    private String name;
    private int maxOrdersAccepted;

    public Barman(String name) {
        this.name = name;
        this.maxOrdersAccepted = 5;
    }

    public String getName() {
        return name;
    }

    public int getMaxOrdersAccepted() {
        return maxOrdersAccepted;
    }

	public void setMaxOrdersAccepted(int maxOrdersAccepted) {
		this.maxOrdersAccepted = maxOrdersAccepted;
	}
}
