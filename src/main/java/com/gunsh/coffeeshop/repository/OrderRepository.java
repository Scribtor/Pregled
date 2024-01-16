package com.gunsh.coffeeshop.repository;

import com.gunsh.coffeeshop.model.Order;

import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository {

    void save(Order order);

    Order findById(String orderId);

    List<Order> findAll();

    void update(Order order);

    void delete(String orderId);
}
