package com.udacity.dogrestapi.controller;

import com.udacity.dogrestapi.entity.Dog;
import com.udacity.dogrestapi.service.DogService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@ApiResponses(value = {
        @ApiResponse(code = 400, message = "This is a bad request, please follow the API documentation for the proper request format."),
        @ApiResponse(code = 401, message = "Due to security constraints, your access request cannot be authorized."),
        @ApiResponse(code = 500, message = "The server is down. Please make sure that the Dog REST API is running.")
})
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
