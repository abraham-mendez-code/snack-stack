package com.pluralsight.models;

import com.pluralsight.models.enums.*;

import java.util.ArrayList;
import java.util.List;

public class Sandwich implements Valuable{

    // CLASS ATTRIBUTES
    // Additions List
    private List<MeatSelection> meats;
    private List<CheeseSelection> cheeses;
    private List<ToppingType> toppings;
    private List<String> sauces;

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
    public void addSauce (String sauce) {
        sauces.add(sauce);
    }

    // this method returns a string with all sandwich details and price
    public String getSummary() {

        return String.format("""
                %din %s Sandwich%33s$%.02f
                /tToasted %s
                /t[%s]
                /t[%s]
                /t[%s]
                /t[%s]
                """, this.size,
                this.breadType,
                "", // padding string
                getValue(),
                (isToasted == true ? "YES" : "NO"),
                TOASTED_COST,
                meats,
                cheeses,
                toppings,
                sauces);

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
}
