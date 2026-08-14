package com.example.isa.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class UserController {
    @GetMapping("get-first-name")
    public String getFirstName(){return "Martin";}

    @GetMapping("get-first-name-list")
    public List<String> getFirstNameList(){
        return List.of("Martin", "Milic");
    }

    @PostMapping("create-user")
    public boolean createUser(String firstName, String lastName){
        return true;
    }
}
