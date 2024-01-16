package com.gunsh.coffeeshop.model;

import java.time.LocalDateTime;

public class Order {

    private Coffee coffee;
    private LocalDateTime orderTime;
    private boolean isToGo; // Indicates whether the order is for takeaway

    public Order(Coffee coffee, boolean isToGo) {
        this.coffee = coffee;
        this.isToGo = isToGo;
        this.orderTime = LocalDateTime.now(); // Set the current time as the order time
    }

    public Coffee getCoffee() {
        return coffee;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public void setCoffee(Coffee coffee) {
		this.coffee = coffee;
	}

	public void setOrderTime(LocalDateTime orderTime) {
		this.orderTime = orderTime;
	}

	public void setToGo(boolean isToGo) {
		this.isToGo = isToGo;
	}

	public boolean isToGo() {
        return isToGo;
    }
}
