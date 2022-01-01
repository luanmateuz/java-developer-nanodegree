package com.udacity.dogrestapi.service;

import com.udacity.dogrestapi.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DogServiceImpl implements DogService {

    @Autowired
    DogRepository dogRepository;

    @Override
    public List<String> retrieveDogBreed() {
        return (List<String>) dogRepository.findAllBreed();
    }

    @Override
    public String retriveDogBreedById(Long id) {
        return dogRepository.findBreedById(id);
    }

    @Override
    public List<String> retriveDogNames() {
        return dogRepository.findAllNames();
    }
}
