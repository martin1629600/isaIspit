package com.example.isa.services;

import com.example.isa.models.VinylModel;
import com.example.isa.models.VinylPageModel;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface IVinylService {

    List<VinylModel> findAll();

    VinylModel create(VinylModel model);

    VinylModel update(VinylModel model);

    void delete(Integer id);

    VinylPageModel findPagedList(PageRequest pageRequest);
}