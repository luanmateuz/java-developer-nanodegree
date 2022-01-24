package com.udacity.pricing.util;

import com.udacity.pricing.entity.Price;
import java.math.BigDecimal;

public class PriceCreator {

    public static Price createPrice() {
        return new Price("USD", new BigDecimal("20000.00"), 1L);
    }

    public static Price createPriceWithId() {
        return new Price(1L, "USD", new BigDecimal("20000.00"), 1L);
    }
}
