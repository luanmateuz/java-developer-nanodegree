package com.udacity.doggraphqlapi.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.udacity.doggraphqlapi.entity.Dog;
import com.udacity.doggraphqlapi.exception.DogNotFoundException;
import com.udacity.doggraphqlapi.repository.DogRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Query implements GraphQLQueryResolver {

    private final DogRepository dogRepository;

    public Query(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public List<String> findDogBreeds() {
        List<String> breeds = new ArrayList<>();
        dogRepository.findAll().forEach(dog -> breeds.add(dog.getBreed()));
        return breeds;
    }

    public String findDogBreedById(Long id) {
        Dog dog = dogRepository.findById(id)
                .orElseThrow(() -> new DogNotFoundException("Not found Id = [" + id + "]", id));
        return dog.getBreed();
    }

    public List<String> findAllDogNames() {
        List<String> names = new ArrayList<>();
        dogRepository.findAll().forEach(dog -> names.add(dog.getName()));
        return names;
    }

    public Iterable<Dog> findAllDogs() {
        return dogRepository.findAll();
    }

    public Dog findDogById(Long id) {
        return dogRepository.findById(id)
                .orElseThrow(() -> new DogNotFoundException("Not found Id = [" + id + "]", id));
    }
}
