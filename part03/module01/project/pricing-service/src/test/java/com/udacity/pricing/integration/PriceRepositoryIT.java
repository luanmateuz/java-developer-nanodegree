package com.udacity.pricing.integration;

import com.udacity.pricing.entity.Price;
import com.udacity.pricing.repository.PriceRepository;
import com.udacity.pricing.util.PriceCreator;
import java.math.BigDecimal;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class PriceRepositoryIT {

    @Autowired
    private PriceRepository priceRepository;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    @DisplayName("findByVehicleId returns details about price when successful")
    public void findByVehicleId_ReturnDetailsAboutPrice_WhenSuccessful() {
        Price expected = PriceCreator.createPrice();

        Price price = restTemplate.getForObject("/service/price/search/findByVehicleId?id=1",
                Price.class);

        Assertions.assertThat(price)
                .isNotNull()
                .isInstanceOf(Price.class)
                .hasOnlyFields("id", "currency", "price", "vehicleId");
        Assertions.assertThat(price.getPrice())
                .isEqualTo(expected.getPrice());
    }

    @Test
    @DisplayName("save returns price when successful")
    public void save_ReturnPriceOf_WhenSuccessful() {
        Price expected = PriceCreator.createPrice();
        ResponseEntity<Price> priceResponseEntity = restTemplate.postForEntity("/service/price/",
                expected, Price.class);

        Assertions.assertThat(priceResponseEntity)
                .isNotNull();
        Assertions.assertThat(priceResponseEntity.getStatusCode())
                .isEqualTo(HttpStatus.CREATED);
    }

    @Test
    @DisplayName("replace update price when successful")
    public void replace_UpdatePrice_WhenSuccessful() {
        Price priceSaved = this.priceRepository.save(PriceCreator.createPrice());
        priceSaved.setPrice(new BigDecimal("50000.00"));

        restTemplate.exchange("/service/price/", HttpMethod.PUT, new HttpEntity<>(priceSaved),
                Void.class);

        Assertions.assertThat(priceSaved).isNotNull();
        Assertions.assertThat(priceSaved.getPrice()).isEqualTo("50000.00");
    }

    @Test
    @DisplayName("delete removes price when successful")
    void delete_RemovesPrice_WhenSuccessful() {
        Price priceSaved = priceRepository.save(PriceCreator.createPriceWithId());
        ResponseEntity<Void> responseEntity = restTemplate.exchange("/service/price/{id}",
                HttpMethod.DELETE, null, Void.class, priceSaved.getId());

        Assertions.assertThat(responseEntity).isNotNull();
        Assertions.assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
    }
}