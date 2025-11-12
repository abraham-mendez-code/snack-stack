package com.pluralsight.models;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Order implements Valuable {

    // class attributes
    List<Sandwich> sandwiches;
    List<Drink> drinks;
    List<Chips> chips;
    double total;

    // constructor
    public Order (String name) {

        this.sandwiches = new ArrayList<>();
        this.drinks = new ArrayList<>();
        this.chips = new ArrayList<>();
        this.total = 0;

    }

    // this method adds a sandwich to the order
    public void addSandwich (Sandwich sandwich) {
        sandwiches.add(sandwich);
    }

    // this method adds a drink to the order
    public void addDrink (Drink drink) {
        drinks.add(drink);
    }

    // this method adds chips to the order
    public void addChips(Chips chip) {
        this.chips.add(chip);
    }


// GETTER METHODS

    // this method returns all sandwiches in the order
    public List<Sandwich> getSandwiches() {

        return sandwiches;

    }

    // this method returns all drinks in the order
    public List<Drink> getDrinks() {

        return drinks;
    }

    // this method returns all chips in the order
    public List<Chips> getChips() {

        return chips;

    }

    // this method returns a string with all order details and price
    private String getSummary() {

        double orderTotal = 0;
        StringBuilder summary = new StringBuilder(); // create a new StringBuilder

        // Header
        String header = """
                        \n+==================================================+
                        |                    YOUR ORDER                    |
                        +==================================================+
                        """;

        summary.append(header);

        // Sandwiches
        if(!this.getSandwiches().isEmpty()) {
            sandwiches.sort(Comparator.comparingDouble(Valuable::getValue)); // sort sandwiches by price

            summary.append("\nSandwiches:");
            for (Sandwich sandwich: this.getSandwiches() ) {
                summary.append(sandwich.getSummary());
                orderTotal += sandwich.getValue();
            }
        }

        // Drinks
        if (!getDrinks().isEmpty()) {
            summary.append("\nDrinks:\n");
            for (Drink drink : getDrinks()) {
                summary.append(String.format("  %-20s %10.2f%n",
                        drink.getDescription(), drink.getValue()));
                orderTotal += drink.getValue();
            }
        }

        // Chips
        if (!getChips().isEmpty()) {
            summary.append("\nChips:\n");
            for (Chips chip : getChips()) {
                summary.append(String.format("  %-20s %10.2f%n",
                        chip.getDescription(), chip.getValue()));
                orderTotal += chip.getValue();
            }
        }

        // Total
        summary.append(String.format("""
            
            +--------------------------------------------------+
            | %-30s %17.2f |
            +--------------------------------------------------+
            %n""", "TOTAL:", orderTotal));

        return summary.toString();
    }

    @Override
    public String getDescription () {

        return getSummary();
    }

    // this method calculates the order total and returns its value
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


}
