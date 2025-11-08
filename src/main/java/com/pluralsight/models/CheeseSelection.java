package com.pluralsight.models;

import com.pluralsight.models.enums.CheeseType;

public class CheeseSelection {

    // CLASS ATTRIBUTES
    private CheeseType type;
    private boolean isExtra;

    // CONSTRUCTOR
    public CheeseSelection(CheeseType type, boolean isExtra) {
        this.type = type;
        this.isExtra = isExtra;
    }

    // this method returns the price of the cheese with conditional returns for the price depending on whether its extra cheese or not
    public double getPrice(int size) {
        double price = type.getPriceForSize(size);

        if (isExtra) {
            // add extra meat surcharge
            switch (size) {
                case 4 -> price += 0.30;
                case 8 -> price += 0.60;
                case 12 -> price += 0.90;
            }
        }

        return price;
    }

    @Override
    public String toString() {
        return isExtra ? "Extra " + type : type.toString();
    }

}
