package com.udacity.pricing.repository;

import static org.junit.jupiter.api.Assertions.*;

import com.udacity.pricing.entity.Price;
import java.math.BigDecimal;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class PriceRepositoryTest {

    @Autowired
    private PriceRepository priceRepository;

    @Test
    @DisplayName(value = "test for findByVehicleId")
    void findByVehicleId() {
        Price price = new Price("USD", new BigDecimal("20000.00"), 1L);
        Price byVehicleId = priceRepository.findByVehicleId(1L);

        assertTrue(Optional.of(byVehicleId).isPresent());
        assertEquals(byVehicleId.getPrice(), price.getPrice());
        assertEquals(byVehicleId.getVehicleId(), price.getVehicleId());
    }
}