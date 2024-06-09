package com.example.deplom.controllers;

import com.example.deplom.models.Order;
import com.example.deplom.models.User;
import com.example.deplom.repository.OrderRepository;
import com.example.deplom.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AdminController {
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    public AdminController(OrderRepository orderRepository, UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/admin")
    public String adminProfile(){
        return "profileAdmin";
    }

    @GetMapping("/adminOrders")
    public String getAdminOrders(Model model) {
        List<Order> orders = orderRepository.findAll();
        model.addAttribute("allOrders", orders);
        return "Admin/adminOrders";
    }

    @GetMapping("/adminUserList")
    public String getAllUserList(Model model) {
        List<User> allUserList = userRepository.findAll();
        model.addAttribute("allUserList", allUserList);
        return "Admin/allUserList";
    }


    @GetMapping("/editOrderStatus/{orderId}")
    public String editOrderStatusForm(@PathVariable("orderId") Long orderId, Model model) {
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new IllegalArgumentException("Invalid order ID: " + orderId));
        model.addAttribute("order", order);
        return "Admin/editOrderStatus";
    }

    @PostMapping("/updateOrderStatus/{orderId}")
    public String updateOrderStatus(@PathVariable("orderId") Long orderId, @RequestParam String status, Model model) {
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new IllegalArgumentException("Invalid order ID: " + orderId));
        order.setStatus(status);
        orderRepository.save(order);
        return "redirect:/admin/adminUserList";
    }


}
