package com.example.deplom.service;

import com.example.deplom.DTOS.UserDTO;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface UserService {
    void createUser(UserDTO userDTO);
    UserDTO findUserById(Long id);
    void deleteUserById(Long Id);
    void updateUser(Long Id, UserDTO userDTO);
    List<UserDTO> getAllUser(PageRequest pageRequest);


}
