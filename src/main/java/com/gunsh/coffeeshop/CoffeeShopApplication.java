package com.gunsh.coffeeshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.gunsh.coffeeshop")
public class CoffeeShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoffeeShopApplication.class, args);
    }
}
