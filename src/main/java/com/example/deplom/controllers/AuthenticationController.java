package com.example.deplom.controllers;

import com.example.deplom.models.AuthenticationResponse;
import com.example.deplom.models.User;
import com.example.deplom.models.enums.Role;
import com.example.deplom.repository.UserRepository;
import com.example.deplom.service.serviceImpl.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")

public class AuthenticationController {

    private final AuthenticationService authService;


    public AuthenticationController(AuthenticationService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody User request){
        return ResponseEntity.ok(authService.register(request));
    }


    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody User request){
        return ResponseEntity.ok(authService.authenticate(request));
    }

}
