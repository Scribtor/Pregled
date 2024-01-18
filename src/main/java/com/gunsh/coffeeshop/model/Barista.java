package com.gunsh.coffeeshop.model;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class Barista {

	private String name;
	private int coffeeGrinderCapacity;
	private int currentCoffeeAmount;
	private boolean isRefilling;
	private Instant refillStartTime; // Timestamp when the refill started

	public Barista(String name) {
		this.name = name;
		this.coffeeGrinderCapacity = 300;
		this.currentCoffeeAmount = coffeeGrinderCapacity; // Initially, the grinder is full
		this.isRefilling = false;
		this.refillStartTime = null;
	}

	public String getName() {
		return name;
	}

	public int getCoffeeGrinderCapacity() {
		return coffeeGrinderCapacity;
	}

	public void setCoffeeGrinderCapacity(int coffeeGrinderCapacity) {
		this.coffeeGrinderCapacity = coffeeGrinderCapacity;
	}

	public int getCurrentCoffeeAmount() {
		return currentCoffeeAmount;
	}

	public void setCurrentCoffeeAmount(int currentCoffeeAmount) {
		this.currentCoffeeAmount = currentCoffeeAmount;
	}

	public void startRefill() {
		this.isRefilling = true;
		this.refillStartTime = Instant.now();
		// Additional logic if needed
	}

	public void endRefill() {
		this.isRefilling = false;
		this.refillStartTime = null;
		// Additional logic if needed
	}

	public boolean isRefilling() {
		return isRefilling;
	}

	public boolean isRefillComplete() {
		if (refillStartTime == null) {
			return true; // No refill in progress
		}

		Instant currentTime = Instant.now();
		long elapsedTimeMinutes = ChronoUnit.MINUTES.between(refillStartTime, currentTime);
		return elapsedTimeMinutes >= 2; // Refill is complete after 2 minutes
	}

	public void isRefillNeeded(int amountOrdered) {
		if (currentCoffeeAmount < amountOrdered) {
			startRefill();
			System.out.println("Refilling the coffee grinder. Please wait for 2 minutes.");
		} else {
			System.out.println("Refill is already in progress. Please wait for it to complete.");
		}
	}
}
