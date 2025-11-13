package com.pluralsight.models;

import com.pluralsight.models.enums.MeatType;

public class MeatSelection {

    // CLASS ATTRIBUTES
    private MeatType type;
    private boolean isExtra;

    // CONSTRUCTOR
    public MeatSelection(MeatType type, boolean isExtra) {
        this.type = type;
        this.isExtra = isExtra;
    }

    // this method returns the price of the meat with conditional returns for the price depending on whether its extra meat or not
    public double getPrice(int size) {
        double price = type.getPriceForSize(size);

        if (isExtra) {
            // add extra meat surcharge
            switch (size) {
                case 4 -> price = 0.50;
                case 8 -> price = 1.00;
                case 12 -> price = 1.50;
            }
        }

        return price;
    }

    @Override
    public String toString() {
        return isExtra ? "Extra " + type : type.toString();
    }

}