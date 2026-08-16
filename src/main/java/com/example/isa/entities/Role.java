package com.example.isa.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "role")
@Data

public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;
}
