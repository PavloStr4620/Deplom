package com.example.deplom.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/profile")
public class PageProfileController {


    @GetMapping
    public String profile(){
        return "profile";
    }

}
