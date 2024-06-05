package com.example.deplom.controllers;

import com.example.deplom.DTOS.UserDTO;
import com.example.deplom.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/create-user")
    public void createUser(@RequestBody UserDTO userDTO) {
        userService.createUser(userDTO);
    }

    @GetMapping("/find-by-id/{id}")
    UserDTO findById(@PathVariable("id") Long id){
        return userService.findUserById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUserById(@PathVariable("id") Long Id){
        userService.deleteUserById(Id);
    }

    @PutMapping("/update/{id}")
    public void update(@PathVariable("id") Long id, @RequestBody UserDTO userDTO) {
        userService.updateUser(id, userDTO);
    }

    @GetMapping("/get-All-Users")
    public List<UserDTO> getAllUsers(
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int size
    ){
        return userService.getAllUser(PageRequest.of(page, size, Sort.by("username")));
    }

}


