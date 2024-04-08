package com.example.deplom.controllers;

import com.example.deplom.DTOS.UserDTO;
import com.example.deplom.models.User;
import com.example.deplom.service.UserService;
import jakarta.ws.rs.POST;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserControllers {
    private UserService userService;



    @Autowired
    public UserControllers(UserService userService) {
        this.userService = userService;

    }
    @PostMapping
public void createUser(@RequestBody UserDTO userDTO) {
    userService.createUser(userDTO);
}
}


