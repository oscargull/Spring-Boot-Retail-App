package com.dam2.project.amazin.auth;

import com.dam2.project.amazin.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

public class JwtResponse {
    private final String token;
    private final String username;
    private final String email;
    private final Set<String> roles;

    public JwtResponse(String token, String username, String email,  Set<String>  roles) {
        this.token = token;
        this.username = username;
        this.email = email;
        this.roles = roles;
    }

    public String getToken() {
        return token;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public  Set<String>  getRoles() {
        return roles;
    }
}

