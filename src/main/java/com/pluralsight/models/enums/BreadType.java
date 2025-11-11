package com.pluralsight.models.enums;

import java.util.Map;

public enum BreadType {
    // BREAD INVENTORY
    WHITE("White Bread", Map.of(4, 5.50, 8, 7.00, 12, 8.50)),
    WHEAT("Wheat Bread", Map.of(4, 5.50, 8, 7.00, 12, 8.50)),
    RYE("Rye Bread", Map.of(4, 5.50, 8, 7.00, 12, 8.50)),
    WRAP("Wrap", Map.of(4, 5.50, 8, 7.00, 12, 8.50));

    private String displayName;
    private final Map<Integer, Double> priceBySize;

    BreadType(String displayName, Map<Integer, Double> priceBySize) {
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
