package com.dam2.project.amazin.controller;


import com.dam2.project.amazin.auth.JwtUtils;
import com.dam2.project.amazin.model.Role;
import com.dam2.project.amazin.requests.LoginRequest;
import com.dam2.project.amazin.auth.MyUserDetails;
import com.dam2.project.amazin.service.AuthService;
import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class AuthController {

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
            this.authService = authService;
        }


    @PostMapping("/login")
    private ResponseEntity<?> authenricateUser(@RequestBody LoginRequest loginRequest) {
        return authService.authenticateUser(loginRequest);
    }


}

