package com.udacity.dogrestapi.service;

import com.udacity.dogrestapi.entity.Dog;

import java.util.List;

public interface DogService {

    List<String> retrieveDogBreed();
    String retriveDogBreedById(Long id);
}
