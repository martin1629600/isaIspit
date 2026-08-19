package com.example.isa.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "vinyl")
@Data

public class Vinyl {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "release_year")
    private Integer releaseYear;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "available")
    private boolean available;

    @Column(name = "rented_until")
    private LocalDate rentedUntil;

    @ManyToOne
    @JoinColumn(name = "artist_id")
    private Artist artist;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "vinyl_genres",
            joinColumns = @JoinColumn(name = "vinyl_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id", referencedColumnName = "id"))
    @JsonManagedReference
    private List<Genre> genres;
}
