package com.example.deplom.models;

import com.example.deplom.models.enums.Role;
import lombok.Getter;

@Getter
public class AuthenticationResponse {

    private String token;
    private String role;

    public AuthenticationResponse(String token) {
        this.token = token;
    }

    public AuthenticationResponse(String token, String role) {
        this.token = token;
        this.role = role;
    }

}