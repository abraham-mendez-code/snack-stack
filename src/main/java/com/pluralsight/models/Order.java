package com.pluralsight.models;

import java.util.ArrayList;
import java.util.List;

public class Order implements Valuable {

    // class attributes
    List<Valuable> items;
    double total;

    // constructor
    public Order (String name) {

        this.items = new ArrayList<>();
        this.total = 0;

    }

    // this method adds a sandwich to the order
    public void addSandwich (Valuable sandwich) {
        items.add(sandwich);
    }

    // this method adds a drink to the order
    public void addDrink (Valuable drink) {
        items.add(drink);
    }

    // this method adds chips to the order
    public void addChips(Valuable chips) {
        items.add(chips);
    }

    // this method removes an item from the order
    public void remove (int index) {

        items.remove(index);

    }

    // get the order total
    @Override
    public double getValue() {

        // Sum the value of each item in an order
        total = items.stream()
                    .mapToDouble(Valuable::getValue)
                .sum();

        return total;

    }




}
