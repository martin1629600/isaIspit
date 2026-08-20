package com.example.isa.models;

import com.example.isa.validator.EmailConstraint;
import lombok.Data;

@Data
public class LoginModel {
    @EmailConstraint
    private String email;
    private String password;
}