package com.pluralsight.models.enums;

import java.util.HashMap;
import java.util.Map;

public enum MeatType {

    // STANDARD SINGLE MEAT PRICES
    STEAK(Map.of(4, 1.00, 8, 2.00, 12, 3.00)),
    HAM(Map.of(4, 1.00, 8, 2.00, 12, 3.00)),
    SALAMI(Map.of(4, 1.00, 8, 2.00, 12, 3.00)),
    ROAST_BEEF(Map.of(4, 1.00, 8, 2.00, 12, 3.00)),
    CHICKEN(Map.of(4, 1.00, 8, 2.00, 12, 3.00)),
    BACON(Map.of(4, 1.00, 8, 2.00, 12, 3.00)),

    // EXTRA MEAT PRICES
    EXTRA_MEAT(Map.of(4, .50, 8, 1.00, 12, 1.50));

    private final Map<Integer, Double> priceBySize;

    MeatType(Map<Integer, Double> priceBySize) {
        this.priceBySize = priceBySize;
    }

    public double getPriceForSize(int size) {
        return priceBySize.getOrDefault(size, 0.0);
    }

}
