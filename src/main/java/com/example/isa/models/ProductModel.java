package com.example.isa.models;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductModel {
    private int id;
    @NotBlank
    private String name;
    private String description;
    private float price;
    private int category_id;
}
