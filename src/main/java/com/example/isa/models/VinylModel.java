package com.example.isa.models;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VinylModel {
    private Integer id;
    @NotBlank
    private String title;
    private int releaseYear;
    private Integer userId;
    private Integer artistId;
    private Integer genreId;
}
