package com.example.isa.services;

import com.example.isa.models.LoginModel;
import com.example.isa.repositories.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final IUserRepository userRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public String login(LoginModel model) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        model.getEmail(),
                        model.getPassword()
                )
        );

        var user = userRepository
                .findByEmail(model.getEmail())
                .orElseThrow();

        return jwtService.generateToken(user);
    }
}