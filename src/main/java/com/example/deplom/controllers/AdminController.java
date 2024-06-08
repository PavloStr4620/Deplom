package com.example.deplom.controllers;

import com.example.deplom.models.Order;
import com.example.deplom.repository.OrderRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AdminController {
    private final OrderRepository orderRepository;

    public AdminController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping("/admin")
    public String adminProfile(){
        return "profileAdmin";
    }

//    @GetMapping("/adminOrders")
//    public String getUserOrders(Model model) {
//        List<Order> orders = orderRepository.findAll();
//        model.addAttribute("all-orders", orders);
//        return "cart/adminOrders";
//    }
}
