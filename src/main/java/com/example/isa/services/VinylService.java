package com.example.isa.services;

import com.example.isa.entities.Vinyl;
import com.example.isa.models.VinylModel;
import com.example.isa.models.VinylPageModel;
import com.example.isa.repositories.IArtistRepository;
import com.example.isa.repositories.IGenreRepository;
import com.example.isa.repositories.IVinylRepository;
import lombok.RequiredArgsConstructor;
import mappers.VinylMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VinylService implements IVinylService {

    private final IVinylRepository vinylRepository;
    private final IArtistRepository artistRepository;
    private final IGenreRepository genreRepository;

    @Override
    public List<VinylModel> findAll(){
        var result = vinylRepository.findAll();
        return VinylMapper.toModelList(result);
    }

    @Override
    public VinylModel create(VinylModel model){
        Vinyl entity = new Vinyl();

        entity.setTitle(model.getTitle());
        entity.setReleaseYear(model.getReleaseYear());
        entity.setAvailable(model.isAvailable());
        entity.setRentedUntil(model.getRentedUntil());

        var artist = artistRepository.findById(model.getArtistId()).orElseThrow();
        entity.setArtist(artist);

        var genres = genreRepository.findAllById(model.getGenreIds());
        entity.setGenres(genres);

        var result = vinylRepository.save(entity);

        return VinylMapper.toModel(result);
    }

    @Override
    public VinylModel update(VinylModel model){
        var entity = vinylRepository.findById(model.getId()).orElseThrow();

        entity.setTitle(model.getTitle());
        entity.setReleaseYear(model.getReleaseYear());
        entity.setAvailable(model.isAvailable());
        entity.setRentedUntil(model.getRentedUntil());

        var artist = artistRepository.findById(model.getArtistId()).orElseThrow();
        entity.setArtist(artist);

        var genres = genreRepository.findAllById(model.getGenreIds());
        entity.setGenres(genres);

        var result = vinylRepository.save(entity);

        return VinylMapper.toModel(result);
    }

    @Override
    public void delete(Integer id){
        vinylRepository.deleteById(id);
    }

    @Override
    public VinylPageModel findPagedList(PageRequest pageRequest){
        var result = vinylRepository.findAll(pageRequest);
        return VinylMapper.toModelPagedList(result);
    }
}