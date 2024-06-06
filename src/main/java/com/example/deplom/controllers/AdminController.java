package com.example.deplom.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {


    @GetMapping("/admin")
    public String adminProfile(){
        return "profileAdmin";
    }
}
