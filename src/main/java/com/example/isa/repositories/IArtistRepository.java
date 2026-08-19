package com.example.isa.repositories;

import com.example.isa.entities.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IArtistRepository extends JpaRepository<Artist, Integer> {
}