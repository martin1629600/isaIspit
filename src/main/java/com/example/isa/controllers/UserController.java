package com.example.isa.controllers;

import com.example.isa.models.UserModel;
import com.example.isa.models.UserPageModel;
import com.example.isa.models.UserProductsModel;
import com.example.isa.repositories.IUserRepository;
import com.example.isa.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import mappers.UserMapper;
import org.apache.catalina.User;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
@CrossOrigin("*")

public class UserController {
    private final IUserRepository userRepository;
    private final UserService userService;

    @GetMapping("get-list")
    public List<UserModel> getList(){ return userService.findAll();}


    @GetMapping("get-user-products-list")
    public List<UserProductsModel> getUserProductsList(){
        return userService.findUserProductsAll();
    }

    @GetMapping("get-page-list")
    public UserPageModel getPageList(Integer pageNumber, Integer pageSize){
        return userService.findPagedList(PageRequest.of(pageNumber, pageSize));
    }


    @PostMapping("create")
    public ResponseEntity<?> create(@RequestBody @Valid UserModel userModel, BindingResult result){
        if (result.hasErrors()){
            return new ResponseEntity<>("Neuspesno registrovan", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<UserModel>(userService.create(userModel), HttpStatus.CREATED);
    }

    @PutMapping("update")
    public ResponseEntity<?> update(@RequestBody @Valid UserModel userModel, BindingResult result){
        if (result.hasErrors()){
            return new ResponseEntity<>("Neuspesno", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(userService.update(userModel), HttpStatus.CREATED);
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        userService.delete(id);
        return new ResponseEntity<>("Uspesno obrisan", HttpStatus.OK);
    }

}
