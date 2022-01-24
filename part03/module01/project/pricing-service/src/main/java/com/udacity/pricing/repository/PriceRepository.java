package com.udacity.pricing.repository;

import com.udacity.pricing.entity.Price;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(path = "price")
public interface PriceRepository extends CrudRepository<Price, Long> {

    Price findByVehicleId(@Param(value = "id") Long id);
}
