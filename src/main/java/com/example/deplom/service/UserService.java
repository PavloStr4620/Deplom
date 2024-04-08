package com.example.deplom.service;

import com.example.deplom.DTOS.UserDTO;
import com.example.deplom.models.User;

public interface UserService {
    public void createUser(UserDTO userDTO);
    void update (UserDTO userDTO);
}
