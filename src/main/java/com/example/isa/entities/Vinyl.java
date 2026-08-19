package com.example.isa.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
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

    @ManyToOne
    @JoinColumn(name = "artist_id")
    private Artist artist;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;
}
