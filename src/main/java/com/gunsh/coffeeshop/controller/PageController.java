package com.gunsh.coffeeshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    // Example: Index Page
    @GetMapping("/")
    public String indexPage() {
    	return "forward:/index.html";
    }

    // Example: Home Page
    @GetMapping("/home")
    public String homePage() {
        return "home";
    }

    // Example: Login Page
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    // Example: Error Page
    @GetMapping("/error")
    public String errorPage() {
        return "error";
    }

    // Example: Admin Page
    @GetMapping("/admin")
    public String adminPage() {
        return "admin";
    }
}
