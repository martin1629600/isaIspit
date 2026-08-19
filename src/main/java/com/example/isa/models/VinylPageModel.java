package com.example.isa.models;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class VinylPageModel {
    private long totalElements;
    private int totalPages;
    private List<VinylModel> vinyls;
}