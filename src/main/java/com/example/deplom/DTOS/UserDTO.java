package com.example.deplom.DTOS;

import com.example.deplom.models.enums.Role;
import lombok.Data;

@Data
public class UserDTO {
    private String name;
    private String password;
    private String email;
    private Role role;
}
