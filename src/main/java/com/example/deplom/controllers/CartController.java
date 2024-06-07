package com.example.deplom.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/cart")
public class CartController {
    @GetMapping()
    public String viewCart() {
        return "cart/cart";
    }

    @GetMapping("/creatingAnOrder")
    public String creatingAnOrder(){
        return "cart/creatingAnOrder";
    }

}


