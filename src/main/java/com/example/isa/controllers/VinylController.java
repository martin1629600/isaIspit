package com.example.isa.controllers;

import com.example.isa.models.VinylModel;
import com.example.isa.models.VinylPageModel;
import com.example.isa.services.VinylService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("vinyl")
@RequiredArgsConstructor
@CrossOrigin("*")
public class VinylController {

    private final VinylService vinylService;

    @GetMapping("get-list")
    public List<VinylModel> getList(){
        return vinylService.findAll();
    }

    @GetMapping("get-page-list")
    public VinylPageModel getPageList(Integer pageNumber, Integer pageSize){
        return vinylService.findPagedList(PageRequest.of(pageNumber, pageSize));
    }

    @PostMapping("create")
    public ResponseEntity<?> create(@RequestBody VinylModel vinylModel){
        return new ResponseEntity<>(vinylService.create(vinylModel), HttpStatus.CREATED);
    }

    @PutMapping("update")
    public ResponseEntity<?> update(@RequestBody VinylModel vinylModel){
        return new ResponseEntity<>(vinylService.update(vinylModel), HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        vinylService.delete(id);
        return new ResponseEntity<>("Uspesno obrisana ploca", HttpStatus.OK);
    }
}