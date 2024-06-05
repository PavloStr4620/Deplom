package com.example.deplom.controllers;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/admin")
public class AdminController {
    @GetMapping()
    public String adminPage() {
        // Ваш код для обробки запитів на /admin
        return "admin";
    }
}

