package com.pluralsight.models;

import com.pluralsight.models.enums.*;

import java.util.ArrayList;
import java.util.List;

public class Sandwich implements Valuable, Comparable<Valuable>{

    // CLASS ATTRIBUTES
    // Additions List
    private List<MeatSelection> meats;
    private List<CheeseSelection> cheeses;
    private List<ToppingType> toppings;
    private List<SauceType> sauces;

    //
    protected BreadType breadType;
    protected int size;
    private boolean isToasted;

    // pricing rules
    private static final double TOASTED_COST = 0.0;

    // constructor
    public Sandwich (BreadType breadType, int size, boolean isToasted) {

        this.breadType = breadType;
        this.size = size;
        this.isToasted = isToasted;

        this.meats = new ArrayList<>();
        this.cheeses = new ArrayList<>();
        this.toppings = new ArrayList<>();
        this.sauces = new ArrayList<>();


    }

    // this method adds meat to the meats List
    public void addMeat(MeatType meatType, boolean isExtra) {
        meats.add(new MeatSelection(meatType, isExtra));
    }

    // this method adds cheese to the cheeses List
    public void addCheese(CheeseType cheeseType, boolean isExtra) {
        cheeses.add(new CheeseSelection(cheeseType, isExtra));
    }

    // this method adds a topping to the toppings List
    public void addTopping (ToppingType toppingType) {
        toppings.add(toppingType);
    }

    // this method adds a sauce to the sauces list
    public void addSauce (SauceType sauce) {
        sauces.add(sauce);
    }

    // this method returns a string with all sandwich details and price
    public String getSummary() {
        String meatsSummary = meats.stream()
                .map(Object::toString)
                .reduce((a, b) -> a + ", " + b)
                .orElse("None");

        String cheesesSummary = cheeses.stream()
                .map(Object::toString)
                .reduce((a, b) -> a + ", " + b)
                .orElse("None");

        String toppingsSummary = toppings.stream()
                .map(Object::toString)
                .reduce((a, b) -> a + ", " + b)
                .orElse("None");

        String saucesSummary = sauces.stream()
                .map(Object::toString)
                .reduce((a, b) -> a + ", " + b)
                .orElse("None");

        return String.format(
                "  %-20s %10.2f%n" +
                        "    Bread: %s%n" +
                        "    Size: %d\"%n" +
                        "    Meats: %s%n" +
                        "    Cheeses: %s%n" +
                        "    Toppings: %s%n" +
                        "    Sauces: %s%n%n",
                getDescription(), getValue(),
                breadType,
                size,
                meats,
                cheeses,
                toppingsSummary,
                saucesSummary
        );
    }


    @Override
    public String getDescription() {
        return size + "\" " + breadType + " Sandwich";
    }

    @Override
    public double getValue() {

        double total = breadType.getPriceForSize(size);

        // Meat pricing
        total += meats.stream()
                .mapToDouble(m -> m.getPrice(size))
                .sum();

        // Cheese pricing
        total += cheeses.stream()
                .mapToDouble(c -> c.getPrice(size))
                .sum();

        return total;
    }

    @Override
    public int compareTo(Valuable valuable) {
        return Double.compare(this.getValue(), valuable.getValue());
    }
}
