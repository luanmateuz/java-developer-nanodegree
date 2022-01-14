package com.udacity.dogsecurity.service;

import com.udacity.dogsecurity.entity.Dog;

import java.util.List;

public interface DogService {

    List<Dog> retrieveDogs();

    List<String> retrieveDogBreed();

    String retriveDogBreedById(Long id);

    List<String> retriveDogNames();
}
