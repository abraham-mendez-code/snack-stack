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
    private static final double BASE_MEAT_COST = 1.00;
    private static final double EXTRA_MEAT_COST = .50;
    private static final double BASE_CHEESE_COST = 0.75;
    private static final double EXTRA_CHEESE_COST = 0.30;
    private static final double TOASTED_COST = 0.0;

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
                this.bread,
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
        /*
        MEATS Pricing
            Type 	    4" 	    8" 	    12"
            Steak 	    $1.00 	$2.00 	$3.00
            Ham 	    $1.00 	$2.00 	$3.00
            Salami 	    $1.00 	$2.00 	$3.00
            Roast Beef 	$1.00 	$2.00 	$3.00
            Chicken 	$1.00 	$2.00 	$3.00
            Bacon 	    $1.00 	$2.00 	$3.00
            Extra Meat 	$0.50 	$1.00 	$1.50
         */

        double total = basePrice;
        double multiplier = size / 4; // e.g., 8" → 2.0, 12" → 3.0

        // Meat pricing
        if (!meats.isEmpty()) {
            total += BASE_MEAT_COST * multiplier; // single meat
            if (meats.size() > 1) {
                total += (meats.size() - 1) * EXTRA_MEAT_COST * multiplier; // extra meats
            }
        }

        // Cheese pricing
        if (!cheeses.isEmpty()) {
            total += BASE_CHEESE_COST * multiplier; // single cheese
            if (cheeses.size() > 1) {
                total += (cheeses.size() - 1) * EXTRA_CHEESE_COST * multiplier; // extra cheeses
            }
        }

        return total;
    }
}
