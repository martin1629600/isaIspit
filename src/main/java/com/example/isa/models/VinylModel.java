package com.example.isa.models;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VinylModel {
    private Integer id;
    private String title;
    private Integer releaseYear;

    private Integer artistId;
    private String artistName;

    private List<Integer> genreIds;
    private List<String> genreNames;

    private boolean available;
    private LocalDate rentedUntil;
    }
