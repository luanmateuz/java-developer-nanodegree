package com.udacity.doggraphqlapi.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.udacity.doggraphqlapi.entity.Dog;
import com.udacity.doggraphqlapi.exception.BreedNotFoundException;
import com.udacity.doggraphqlapi.exception.DogNotFoundException;
import com.udacity.doggraphqlapi.repository.DogRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Mutation implements GraphQLMutationResolver {

    private final DogRepository dogRepository;

    public Mutation(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public Dog createDog(String name, String breed, String origin) {
        Dog dog = new Dog(name, breed, origin);
        return this.dogRepository.save(dog);
    }

    public boolean deleteDogBreed(String breed) {
        boolean deleted = false;
        Iterable<Dog> allDogs = dogRepository.findAll();
        for (Dog d : allDogs) {
            if (d.getBreed().equals(breed)) {
                dogRepository.delete(d);
                deleted = true;
            }
        }
        if (!deleted) {
            throw new BreedNotFoundException("Not found Breed = [" + breed + "]", breed);
        }
        return true;
    }

    public Dog updateDogName(Long id, String name) {
        Optional<Dog> optionalDog = this.dogRepository.findById(id);
        if (optionalDog.isPresent()) {
            Dog dog = optionalDog.get();
            dog.setName(name);
            return this.dogRepository.save(dog);
        } else {
            throw new DogNotFoundException("Not found Id = [" + id + "]", id);
        }
    }
}
