package com.udacity.dogdatarest.repository;

import com.udacity.dogdatarest.entity.Dog;
import org.springframework.data.repository.CrudRepository;

public interface DogRepository extends CrudRepository<Dog, Long> {
}
