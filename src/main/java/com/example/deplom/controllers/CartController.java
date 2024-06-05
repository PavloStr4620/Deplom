package com.example.deplom.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class CartController {

//    @PostMapping("/addToCart")
//    public String addToCart(@RequestParam("name") String name, @RequestParam("price") String price, HttpSession session) {
//        Cart cart = (Cart) session.getAttribute("cart");
//        if (cart == null) {
//            cart = new Cart();
//            session.setAttribute("cart", cart);
//        }
//        cart.addItem(new Item(name, price));
//        return "redirect:/cart";
//    }

//    @GetMapping("/cart")
//    public String viewCart(HttpSession session, Model model) {
//        Cart cart = (Cart) session.getAttribute("cart");
//        if (cart == null) {
//            cart = new Cart();
//            session.setAttribute("cart", cart);
//        }
//        model.addAttribute("cart", cart);
//        return "cart";
//}

    @GetMapping("/cart")
    public String viewCart() {
        return "cart";
    }


}


