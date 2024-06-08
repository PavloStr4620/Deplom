package com.example.deplom.controllers;

import com.example.deplom.models.Cart;
import com.example.deplom.models.User;
import com.example.deplom.repository.CartRepository;
import com.example.deplom.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/cart")
public class CartController {
    private final CartRepository cartRepository;
    private final UserRepository userRepository;

    public CartController(CartRepository cartRepository, UserRepository userRepository) {
        this.cartRepository = cartRepository;
        this.userRepository = userRepository;
    }

    @GetMapping()
    public String viewCart() {
        return "cart/cart";
    }

    @GetMapping("/an-Order")
    public String creatingAnOrder(@RequestParam String userName, @RequestParam double totalAmount, Model model) {
        Optional<User> user = userRepository.findByUsername(userName);
        model.addAttribute("userAnOrder", user);
        model.addAttribute("totalAmount", totalAmount);

        return "/cart/creatingAnOrder";
    }


    @GetMapping("/load")
    @ResponseBody
    public List<Cart> loadCart(@RequestParam String userName) {
        return cartRepository.findByUserName(userName);
    }

    @PostMapping("/add-product-db")
    public String addProductDB(@RequestParam String nameProduct,
                               @RequestParam double price,
                               @RequestParam String userName) {
        Cart cart = new Cart();
        cart.setNameProduct(nameProduct);
        cart.setPrice(price);
        cart.setUserName(userName);
        cartRepository.save(cart);
        return "redirect:/cart";
    }

    @PostMapping("/delete-product-db")
    @ResponseBody
    public ResponseEntity<String> deleteProductDB(@RequestParam Long id) {
        try {
            cartRepository.deleteById(id);
            return ResponseEntity.ok("Product deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting product");
        }
    }

}
