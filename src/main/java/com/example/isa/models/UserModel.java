package com.example.isa.models;

import com.example.isa.entities.Role;
import com.example.isa.validator.EmailConstraint;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserModel {
    private int id;
    @NotBlank
    private String firstName;
    private String lastName;
    @Email
    @EmailConstraint
    private String email;
    private Role role;
}
