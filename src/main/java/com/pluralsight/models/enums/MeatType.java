package com.pluralsight.models.enums;

import java.util.HashMap;
import java.util.Map;

public enum MeatType {

    // STANDARD SINGLE MEAT PRICES
    STEAK("Steak", Map.of(4, 1.00, 8, 2.00, 12, 3.00)),
    HAM("Ham", Map.of(4, 1.00, 8, 2.00, 12, 3.00)),
    TURKEY("TURKEY", Map.of(4, 1.00, 8, 2.00, 12, 3.00)),
    SALAMI("Salami", Map.of(4, 1.00, 8, 2.00, 12, 3.00)),
    ROAST_BEEF("Roast Beef", Map.of(4, 1.00, 8, 2.00, 12, 3.00)),
    CHICKEN("Chicken", Map.of(4, 1.00, 8, 2.00, 12, 3.00)),
    BACON("Bacon", Map.of(4, 1.00, 8, 2.00, 12, 3.00));


    private final String displayName;
    private final Map<Integer, Double> priceBySize;

    MeatType(String displayName, Map<Integer, Double> priceBySize) {
        this.displayName = displayName;
        this.priceBySize = priceBySize;
    }

    public double getPriceForSize(int size) {
        return priceBySize.getOrDefault(size, 0.0);
    }

    @Override
    public String toString(){
        return displayName;
    }

}
