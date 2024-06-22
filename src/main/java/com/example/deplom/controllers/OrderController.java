package com.example.deplom.controllers;

import com.example.deplom.models.Order;
import com.example.deplom.models.Cart;
import com.example.deplom.models.OrderItem;
import com.example.deplom.repository.CartRepository;
import com.example.deplom.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CartRepository cartRepository;

    @PostMapping("/an-Order")
    public String creatingAnOrder(
            @RequestParam String userName,
            @RequestParam String email,
            @RequestParam String numberPhone,
            @RequestParam String region,
            @RequestParam String city,
            @RequestParam String deliveryService,
            @RequestParam String address,
            @RequestParam int zip,
            @RequestParam double totalAmount,
            Model model) {

        List<Cart> cartItems = cartRepository.findByUserName(userName);

        Order order = new Order();
        order.setUserName(userName);
        order.setEmail(email);
        order.setNumberPhone(numberPhone);
        order.setRegion(region);
        order.setCity(city);
        order.setDeliveryService(deliveryService);
        order.setAddress(address);
        order.setZip(zip);
        order.setSum(totalAmount);
        order.setOrderDate(LocalDateTime.now());

        List<OrderItem> orderItems = new ArrayList<>();
        for (Cart cartItem : cartItems) {
            OrderItem orderItem = new OrderItem();
            orderItem.setName(cartItem.getNameProduct());
            orderItem.setPrice(cartItem.getPrice());
            orderItem.setOrder(order);
            orderItems.add(orderItem);
        }
        order.setItems(orderItems);

        orderRepository.save(order);

        cartRepository.deleteAll(cartItems);

        model.addAttribute("totalAmount", totalAmount);
        return "redirect:/userOrders?userName=" + userName;
    }

    @GetMapping("/userOrders")
    public String getUserOrders(@RequestParam("userName") String userName, Model model) {
        List<Order> orders = orderRepository.findByUserName(userName);
        model.addAttribute("orders", orders);
        return "cart/userOrders";
    }

    @GetMapping("/admin/editOrderStatus/{orderId}")
    public String editOrderStatusForm(@PathVariable("orderId") Long orderId, Model model) {
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new IllegalArgumentException("Invalid order ID: " + orderId));
        model.addAttribute("order", order);
        return "Admin/editOrderStatus";
    }

    @PostMapping("/admin/updateOrderStatus/{orderId}")
    public String updateOrderStatus(@PathVariable("orderId") Long orderId, @RequestParam String status, Model model) {
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new IllegalArgumentException("Invalid order ID: " + orderId));
        order.setStatus(status);
        orderRepository.save(order);
        return "redirect:/adminUserList";
    }
}

