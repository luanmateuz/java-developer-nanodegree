package com.udacity.dogrestapi.service;

import java.util.List;

public interface DogService {

    List<String> retrieveDogBreed();
    String retriveDogBreedById(Long id);
    List<String> retriveDogNames();
}
