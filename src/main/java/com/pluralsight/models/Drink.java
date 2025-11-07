package com.pluralsight.models;

public class Drink implements Valuable {

    // CLASS ATTRIBUTES
    private int size;
    private double basePrice;

    public Drink (int size) {
        this.size = size;

        switch (size) {
            case 1:
                this.basePrice = 2; // Small drink is $2.00
                break;
            case 2:
                this.basePrice = 2.5; // Medium drink is $2.50
                break;
            case 3:
                this.basePrice = 3; // Large drink is $3.50
                break;
        }

    }

    // GETTER METHODS

    // this method gets the size
    public int getSize() {
        return size;
    }

    // this method gets the value
    @Override
    public double getValue() {
        return basePrice;
    }
}
