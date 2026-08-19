package com.example.isa.controllers;

import com.example.isa.models.LoginModel;
import com.example.isa.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
@CrossOrigin("*")
public class AuthController {

    private final AuthService authService;

    @PostMapping("login")
    public ResponseEntity<?> login(@RequestBody LoginModel loginModel) {
        return ResponseEntity.ok(authService.login(loginModel));
    }
}