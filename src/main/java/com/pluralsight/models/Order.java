package com.pluralsight.models;

import java.util.ArrayList;
import java.util.List;

public class Order implements Valuable {

    // class attributes
    List<Valuable> sandwiches;
    List<Valuable> drinks;
    List<Valuable> chips;
    double total;

    // constructor
    public Order (String name) {

        this.sandwiches = new ArrayList<>();
        this.drinks = new ArrayList<>();
        this.chips = new ArrayList<>();
        this.total = 0;

    }

    // this method adds a sandwich to the order
    public void addSandwich (Valuable sandwich) {
        sandwiches.add(sandwich);
    }

    // this method adds a drink to the order
    public void addDrink (Valuable drink) {
        drinks.add(drink);
    }

    // this method adds chips to the order
    public void addChips(Valuable chip) {
        this.chips.add(chip);
    }


    // get the order total
    @Override
    public double getValue() {

        // Sum the value of each item in an order
        total += sandwiches.stream()
                    .mapToDouble(Valuable::getValue)
                .sum();

        total += drinks.stream()
                .mapToDouble(Valuable::getValue)
                .sum();

        total += chips.stream()
                .mapToDouble(Valuable::getValue)
                .sum();

        return total;

    }

// GETTER METHODS

    // this method returns all sandwiches in the order
    public List<Valuable> getSandwiches() {

        return sandwiches;

    }

    // this method returns all drinks in the order
    public List<Valuable> getDrinks() {

        return drinks;
    }

    // this method returns all chips in the order
    public List<Valuable> getChips() {

        return chips;

    }


}
