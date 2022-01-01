package com.udacity.dogrestapi.repository;

import com.udacity.dogrestapi.entity.Dog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DogRepository extends CrudRepository<Dog, Long> {

    String FIND_ALL_BREED = "SELECT dog.breed FROM dog";
    String FIND_BREED_BY_ID = "SELECT dog.id, dog.breed FROM dog WHERE dog.id = :id";

    @Query(value = FIND_ALL_BREED, nativeQuery = true)
    List<String> findAllBreed();

    @Query(value = FIND_BREED_BY_ID, nativeQuery = true)
    String findBreedById(@Param("id") Long id);
}
