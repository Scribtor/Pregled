package com.gunsh.coffeeshop.model;

import java.io.Serializable;

public class Coffee implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String type;
    private double price;
    private String picture;
    private int amountOfCoffeeInGrams;
    private int timeToBrew;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public int getAmountOfCoffeeInGrams() {
		return amountOfCoffeeInGrams;
	}

	public void setAmountOfCoffeeInGrams(int amountOfCoffeeInGrams) {
		this.amountOfCoffeeInGrams = amountOfCoffeeInGrams;
	}

	public int getTimeToBrew() {
		return timeToBrew;
	}

	public void setTimeToBrew(int timeToBrew) {
		this.timeToBrew = timeToBrew;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
