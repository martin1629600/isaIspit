package com.example.isa.entities;

import jakarta.persistence.*;
import jdk.jfr.Category;
import lombok.Data;
import java.util.List;

@Entity
@Table(name = "product")
@Data

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private float price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "product_animal_type",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "animal_type_id")
    )
    private List<AnimalType> animalTypes;

}
