package com.gunsh.coffeeshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/home")
    public String home() {
        return "home"; // Assuming you have a Thymeleaf template named home.html
    }
}
