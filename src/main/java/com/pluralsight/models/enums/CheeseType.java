package com.pluralsight.models.enums;

import java.util.Map;

public enum CheeseType {
    // STANDARD SINGLE CHEESE PRICES
    AMERICAN(Map.of(4 , 0.75, 8, 1.50, 12, 2.25)),
    PROVOLONE(Map.of(4 , 0.75, 8, 1.50, 12, 2.25)),
    CHEDDAR(Map.of(4 , 0.75, 8, 1.50, 12, 2.25)),
    SWISS(Map.of(4 , 0.75, 8, 1.50, 12, 2.25)),

    // EXTRA CHEESE PRICES
    EXTRA_CHEESE(Map.of(4, 0.30, 8, 0.60, 12, 0.90));

    private final Map<Integer, Double> priceBySize;

    CheeseType(Map<Integer, Double> priceBySize) {
        this.priceBySize = priceBySize;
    }

    public double getPriceForSize(int size) {
        return priceBySize.getOrDefault(size, 0.0);
    }
}
