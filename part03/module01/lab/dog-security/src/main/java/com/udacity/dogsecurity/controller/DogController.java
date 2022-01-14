package com.udacity.dogsecurity.controller;

import com.udacity.dogsecurity.entity.Dog;
import com.udacity.dogsecurity.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
public class DogController {

    @Autowired
    private DogService dogService;

    @GetMapping("/dogs")
    public ResponseEntity<List<Dog>> getAllDogs() {
        List<Dog> dogs = dogService.retrieveDogs();

        return new ResponseEntity<List<Dog>>(dogs, HttpStatus.OK);
    }

    @GetMapping("/dogs/breed")
    public ResponseEntity<List<String>> getAllDogBreeds() {
        List<String> list = dogService.retrieveDogBreed();

        return new ResponseEntity<List<String>>(list, HttpStatus.OK);
    }

    @GetMapping("/dogs/{id}/breed/")
    public ResponseEntity<String> getDogBreedById(@PathVariable Long id) {
        String breed = dogService.retriveDogBreedById(id);

        return new ResponseEntity<String>(breed, HttpStatus.OK);
    }

    @GetMapping("/dogs/names")
    public ResponseEntity<List<String>> getAllDogNames() {
        List<String> names = dogService.retriveDogNames();

        return new ResponseEntity<List<String>>(names, HttpStatus.OK);
    }
}
