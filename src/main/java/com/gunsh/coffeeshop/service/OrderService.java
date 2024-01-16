package com.gunsh.coffeeshop.service;

import com.gunsh.coffeeshop.model.Order;
import com.gunsh.coffeeshop.repository.OrderRepository;

import java.util.List;

public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void placeOrder(Order order) {
        orderRepository.save(order);
    }

    public Order getOrderById(String orderId) {
        return orderRepository.findById(orderId);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public void updateOrder(Order order) {
        orderRepository.update(order);
    }

    public void cancelOrder(String orderId) {
        orderRepository.delete(orderId);
    }
}
