package com.example.isa.repositories;

import com.example.isa.entities.Vinyl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVinylRepository extends JpaRepository<Vinyl, Integer> {
}
