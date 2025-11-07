package com.pluralsight.models;

import java.util.ArrayList;
import java.util.List;

public class Sandwich implements Valuable{

    // class attributes
    protected final int[] SIZES = { 4, 8, 12 };
    protected final String[] BREAD_TYPES = { "white", "wheat", "rye", "wrap" };
    private List<String> meats;
    private List<String> cheeses;
    private List<String> toppings;
    private List<String> sauces;

    protected String bread;
    protected int size;
    private boolean isToasted;
    private double basePrice;

    // pricing rules
    private static final double EXTRA_MEAT_COST = .50;
    private static final double EXTRA_CHEESE_COST = 0.30;

    // constructor
    public Sandwich (String bread, int size, boolean isToasted) {

        this.bread = bread;
        this.size = size;
        this.isToasted = isToasted;

        this.meats = new ArrayList<>();
        this.cheeses = new ArrayList<>();
        this.toppings = new ArrayList<>();
        this.sauces = new ArrayList<>();

        switch (size) {
            case 4:
                this.basePrice = 5.5; // 4in sandwich is $5.50
                break;
            case 8:
                this.basePrice = 7.0; // 8in sandwich is $7.00
                break;
            case 12:
                this.basePrice = 8.50; // 12in sandwich is $8.50
                break;
        }

    }

    // this method adds meat to the meats List
    public void addMeat(String meat) {
        meats.add(meat);
    }

    // this method adds cheese to the cheeses List
    public void addCheese(String cheese) {
        cheeses.add(cheese);
    }

    // this method adds a topping to the toppings List
    public void addTopping (String topping) {
        toppings.add(topping);
    }

    // this method adds a sauce to the sauces list
    public void addSauce (String sauce) {
        sauces.add(sauce);
    }

    @Override
    public double getValue() {
        

        return 0;
    }
}
