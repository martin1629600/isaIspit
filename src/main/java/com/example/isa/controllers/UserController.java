package com.example.isa.controllers;

import com.example.isa.models.UserModel;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.*;

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
//        UserModel user = new UserModel();
//        user.setFirstName(firstName);
//        user.setLastName(lastName);
        return true;
    }

    @PostMapping("create-user-body")
    public boolean createUserBody(@RequestBody UserModel userModel){
        return true;
    }
}
