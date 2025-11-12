package com.pluralsight.models;

public class Chips implements Valuable{

    // CLASS ATTRIBUTES
    private final double BASE_PRICE = 1.50;
    private final String name = "Chips";

    // constructor
    public Chips() {}

    @Override
    public String getDescription() {

        return name;
    }

    @Override
    public double getValue() {
        return BASE_PRICE;
    }
}
