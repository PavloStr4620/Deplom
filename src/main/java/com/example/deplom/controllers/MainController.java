package com.example.deplom.controllers;

import com.example.deplom.models.AuthenticationResponse;
import com.example.deplom.models.User;
import com.example.deplom.models.enums.Role;
import com.example.deplom.repository.UserRepository;
import com.example.deplom.service.serviceImpl.AuthenticationService;
import com.example.deplom.service.serviceImpl.JwtService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.HashMap;
import java.util.Map;


@Controller
public class MainController {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final AuthenticationService authService;
    private final PasswordEncoder passwordEncoder;


    public MainController(UserRepository userRepository, JwtService jwtService, AuthenticationService authService, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
        this.authService = authService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/user")
    @PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<String> exampleAdminEndpoint() {
        // Ваш код для контролера, доступного тільки адміністраторам
        return ResponseEntity.ok("Цей ресурс доступний тільки юзера");
    }

    @GetMapping("/main")
    public String showMainPage1() {
        return "mainPage"; // Назва HTML-файлу без розширення .html, якщо використовується Thymeleaf або інший template engine
    }

    @GetMapping("/registerPage")
    public String registerPage() {
        return "registerPage"; // Назва HTML-файлу без розширення .html, якщо використовується Thymeleaf або інший template engine
    }

    @GetMapping("/loginPage")
    public String loginPage() {
        return "loginPage"; // Назва HTML-файлу без розширення .html, якщо використовується Thymeleaf або інший template engine
    }

    @PostMapping("/registerPage")
    public String registerUser(@RequestParam String username, @RequestParam String email, @RequestParam String password) {
        // Створення об'єкта користувача
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        user.setRole(Role.USER);

        // Збереження користувача в базі даних
        userRepository.save(user);

        return "redirect:/loginPage";
    }

    @GetMapping("/test")
    public ResponseEntity<String> yourEndpoint(@CookieValue(value = "token", defaultValue = "noToken") String token) {
        // Робіть що завгодно з отриманим токеном
        return ResponseEntity.ok(token);
    }

//    @PostMapping("/loginPage")
//    public ResponseEntity<Map<String, String>> login(@RequestParam String username, @RequestParam String password) {
//        User request = new User();
//        request.setUsername(username);
//        request.setPassword(password);
//        AuthenticationResponse response = authService.authenticate(request);
//
//        Map<String, String> responseBody = new HashMap<>();
//        responseBody.put("token", response.getToken());
//
//        return ResponseEntity.ok(responseBody);
//    }

    @PostMapping("/loginPage")
    public ResponseEntity<Map<String, String>> login(@RequestParam String username, @RequestParam String password) {
        User request = new User();
        request.setUsername(username);
        request.setPassword(password);
        AuthenticationResponse response = authService.authenticate(request);

        Map<String, String> responseBody = new HashMap<>();
        responseBody.put("token", response.getToken());
        responseBody.put("role", response.getRole()); // Include the role in the response

        return ResponseEntity.ok(responseBody);
    }


}
