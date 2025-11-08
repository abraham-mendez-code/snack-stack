package com.pluralsight.models.enums;

import java.util.Map;

public enum BreadType {
    WHITE(Map.of(4, 5.50, 8, 7.00, 12, 8.50)),
    WHEAT(Map.of(4, 5.50, 8, 7.00, 12, 8.50)),
    RYE(Map.of(4, 5.50, 8, 7.00, 12, 8.50)),
    WRAP(Map.of(4, 5.50, 8, 7.00, 12, 8.50));

    private final Map<Integer, Double> priceBySize;

    BreadType(Map<Integer, Double> priceBySize) {
        this.priceBySize = priceBySize;
    }

    public double getPriceForSize(int size) {
        return priceBySize.getOrDefault(size, 0.0);
    }
}
