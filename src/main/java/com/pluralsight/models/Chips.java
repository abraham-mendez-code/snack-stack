package com.pluralsight.models;

public class Chips implements Valuable{

    // CLASS ATTRIBUTES
    private final double BASE_PRICE = 1.50;

    // constructor
    public Chips() {}

    @Override
    public double getValue() {
        return BASE_PRICE;
    }
}
