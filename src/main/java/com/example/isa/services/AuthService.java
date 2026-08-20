package com.example.isa.services;

import com.example.isa.models.LoginModel;
import com.example.isa.models.LoginResponseModel;
import com.example.isa.models.RefreshTokenModel;
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

    public LoginResponseModel login(LoginModel model) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        model.getEmail(),
                        model.getPassword()
                )
        );

        var user = userRepository
                .findByEmail(model.getEmail())
                .orElseThrow();

        String accessToken =
                jwtService.generateToken(user);

        String refreshToken =
                jwtService.generateRefreshToken(user);

        return new LoginResponseModel(
                accessToken,
                refreshToken
        );
    }

    public LoginResponseModel refresh(RefreshTokenModel model) {

        String email =
                jwtService.extractUsername(
                        model.getRefreshToken()
                );

        var user = userRepository
                .findByEmail(email)
                .orElseThrow();

        if (!jwtService.isTokenValid(
                model.getRefreshToken(),
                user
        )) {
            throw new RuntimeException(
                    "Invalid refresh token"
            );
        }

        String newAccessToken =
                jwtService.generateToken(user);

        return new LoginResponseModel(
                newAccessToken,
                model.getRefreshToken()
        );
    }
}