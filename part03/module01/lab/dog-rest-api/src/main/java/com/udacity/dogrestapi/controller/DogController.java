package com.udacity.dogrestapi.controller;

import com.udacity.dogrestapi.entity.Dog;
import com.udacity.dogrestapi.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DogController {

    @Autowired
    private DogService dogService;

    @GetMapping("/dogs/breed")
    public ResponseEntity<List<String>> getAllDogBreeds() {
        List<String> list = dogService.retrieveDogBreed();

        return new ResponseEntity<List<String>>(list, HttpStatus.OK);
    }

    @GetMapping("/dogs/breed/{id}")
    public ResponseEntity<String> getByIdDogBreed(@PathVariable Long id) {
        String dog = dogService.retriveDogBreedById(id);

        return new ResponseEntity<String>(dog, HttpStatus.OK);
    }
}
