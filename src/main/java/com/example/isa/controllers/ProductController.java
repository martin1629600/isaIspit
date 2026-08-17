package com.example.isa.controllers;

import com.example.isa.entities.Product;
import com.example.isa.models.UserModel;
import com.example.isa.repositories.IProductRepository;
import lombok.RequiredArgsConstructor;
import mappers.UserMapper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("product")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ProductController {
    private final IProductRepository productRepository;

    @GetMapping("get-list")
    public List<Product> getProductList() {return productRepository.findAll() ;}
}
