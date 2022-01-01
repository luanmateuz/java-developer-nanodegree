package com.udacity.dogrestapi.service;

import com.udacity.dogrestapi.entity.Dog;
import com.udacity.dogrestapi.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DogServiceImpl implements DogService {

    @Autowired
    DogRepository dogRepository;

    @Override
    public List<Dog> retrieveDogs() {
        return (List<Dog>) dogRepository.findAll();
    }

    @Override
    public List<String> retrieveDogBreed() {
        return (List<String>) dogRepository.findAllBreed();
    }

    @Override
    public String retriveDogBreedById(Long id) {
        Optional<String> optional = Optional.ofNullable(dogRepository.findBreedById(id));
        return optional.orElseThrow(DogNotFoundException::new);
    }

    @Override
    public List<String> retriveDogNames() {
        return dogRepository.findAllNames();
    }
}
