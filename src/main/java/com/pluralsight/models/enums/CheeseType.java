package com.pluralsight.models.enums;

import java.util.Map;

public enum CheeseType {
    // STANDARD SINGLE CHEESE PRICES
    AMERICAN("American", Map.of(4, 0.75, 8, 1.50, 12, 2.25)),
    PROVOLONE("Provolone", Map.of(4, 0.75, 8, 1.50, 12, 2.25)),
    CHEDDAR("Cheddar", Map.of(4, 0.75, 8, 1.50, 12, 2.25)),
    SWISS("Swiss", Map.of(4, 0.75, 8, 1.50, 12, 2.25));

    private final String displayName;
    private final Map<Integer, Double> priceBySize;

    CheeseType(String displayName, Map<Integer, Double> priceBySize) {
        this.displayName = displayName;
        this.priceBySize = priceBySize;
    }

    public double getPriceForSize(int size) {
        return priceBySize.getOrDefault(size, 0.0);
    }

    @Override
    public String toString() {
        return displayName;
    }
}
