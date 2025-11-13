package com.pluralsight.models.enums;

public enum ChipType {
    CLASSIC("Classic"),
    BARBECUE("Barbecue"),
    SOUR_CREAM_AND_ONION("Sour Cream & Onion"),
    SALT_AND_VINEGAR("Salt & Vinegar"),
    CHEDDAR_AND_SOUR_CREAM("Cheddar & Sour Cream");

    private final String displayName;
    private final double price = 1.50;

    ChipType(String displayName) {
        this.displayName = displayName;
    }

    public double getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        return displayName;
    }

}
