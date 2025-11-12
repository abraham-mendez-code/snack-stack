package com.pluralsight.models;

public class Drink implements Valuable {

    // CLASS ATTRIBUTES
    private int size;
    private double basePrice;
    private final String NAME = "Fountain Drink";

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

    // this method returns a description of the drink
    public String getDescription() {
        String sizeStr = switch (size) {
            case 1 -> "Small";
            case 2 -> "Medium";
            case 3 -> "Large";
            default -> "";
        };

        return sizeStr + " " + NAME;
    }

    // this method gets the value
    @Override
    public double getValue() {
        return basePrice;
    }
}
