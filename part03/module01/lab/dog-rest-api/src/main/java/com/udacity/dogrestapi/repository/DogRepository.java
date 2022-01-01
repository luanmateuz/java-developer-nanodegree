package com.udacity.dogrestapi.repository;

import com.udacity.dogrestapi.entity.Dog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DogRepository extends CrudRepository<Dog, Long> {

    String FIND_ALL_BREED = "SELECT dog.breed FROM dog";

    @Query(value = FIND_ALL_BREED, nativeQuery = true)
    List<String> findAllBreed();
}
