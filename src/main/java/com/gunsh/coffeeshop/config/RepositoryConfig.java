package com.gunsh.coffeeshop.config;

import com.gunsh.coffeeshop.repository.CoffeeRepository;
import com.gunsh.coffeeshop.repository.CoffeeRepositoryImpl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfig {

    @Bean
    public CoffeeRepository coffeeRepository() {
        return new CoffeeRepositoryImpl();
    }
}
