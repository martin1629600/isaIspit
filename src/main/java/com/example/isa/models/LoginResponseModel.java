package com.example.isa.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResponseModel {

    private String accessToken;
    private String refreshToken;
}