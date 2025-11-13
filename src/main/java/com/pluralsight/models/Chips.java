package com.pluralsight.models;

import com.pluralsight.models.enums.ChipType;

public class Chips implements Valuable{

    // CLASS ATTRIBUTES
    private ChipType type;

    // constructor
    public Chips(ChipType type) {
        this.type = type;
    }

    @Override
    public String getDescription() {
        return type.toString() + " Chips";
    }

    @Override
    public double getValue() {
        return type.getPrice();
    }
}
