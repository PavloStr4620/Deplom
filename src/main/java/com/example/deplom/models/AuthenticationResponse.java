package com.example.deplom.models;

import com.example.deplom.models.enums.Role;
import lombok.Getter;

@Getter
public class AuthenticationResponse {

    private final String token;
    private String role;
    private String userName;

    public AuthenticationResponse(String token) {
        this.token = token;
    }

    public AuthenticationResponse(String token, String role, String userName) {
        this.token = token;
        this.role = role;
        this.userName = userName;
    }

}