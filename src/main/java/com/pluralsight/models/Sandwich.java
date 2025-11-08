package com.pluralsight.models;

import com.pluralsight.models.enums.BreadType;
import com.pluralsight.models.enums.CheeseType;
import com.pluralsight.models.enums.MeatType;
import com.pluralsight.models.enums.ToppingTypes;

import java.util.ArrayList;
import java.util.List;

public class Sandwich implements Valuable{

    // CLASS ATTRIBUTES
    // Additions List
    private List<MeatType> meats;
    private List<CheeseType> cheeses;
    private List<ToppingTypes> toppings;
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
        meats.add(meatType);

        if (isExtra) {
            meats.add(MeatType.EXTRA_MEAT);
        }
    }

    // this method adds cheese to the cheeses List
    public void addCheese(CheeseType cheeseType, boolean isExtra) {
        cheeses.add(cheeseType);

        if (isExtra) {
            cheeses.add(CheeseType.EXTRA_CHEESE);
        }
    }

    // this method adds a topping to the toppings List
    public void addTopping (ToppingTypes toppingType) {
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
                .mapToDouble(m -> m.getPriceForSize(size))
                .sum();

        // Cheese pricing
        total += cheeses.stream()
                .mapToDouble(m -> m.getPriceForSize(size))
                .sum();

        return total;
    }
}
