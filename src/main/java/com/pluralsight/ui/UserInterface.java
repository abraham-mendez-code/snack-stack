package com.pluralsight.ui;

import com.pluralsight.models.*;
import com.pluralsight.models.enums.*;
import com.pluralsight.util.InputParser;

import java.util.Scanner;

public class UserInterface {

    // CLASS ATTRIBUTES
    private Scanner scanner = new Scanner(System.in);

    // CONSTRUCTOR
    public UserInterface() {
    }

    ;

    // MENUS

    // this method displays the home screen
    public void showHomeScreen() {
        String message = """    
                
                >>========================================================<<
                || ____                   _      ____  _             _    ||
                ||/ ___| _ __   __ _  ___| | __ / ___|| |_ __ _  ___| | __||
                ||\\___ \\| '_ \\ / _` |/ __| |/ / \\___ \\| __/ _` |/ __| |/ /||
                || ___) | | | | (_| | (__|   <   ___) | || (_| | (__|   < ||
                |||____/|_| |_|\\__,_|\\___|_|\\_\\ |____/ \\__\\__,_|\\___|_|\\_\\||
                >>========================================================<<
                
                1) New Order
                0) Exit
                Enter a command:\s""";

        boolean menuRunning = true;

        while (menuRunning) {

            int command = InputParser.getAInteger(message);

            switch (command) {
                case 1:
                    showOrderMenu();
                    break;
                case 0:
                    menuRunning = false;
                    break;
                default:
                    System.out.println("Invalid selection");
            }


        }
    }

    // this menu displays the order menu
    public void showOrderMenu() {
        String message = """        
                
                >>===========================<<
                ||  ___          _           ||
                || / _ \\ _ __ __| | ___ _ __ ||
                ||| | | | '__/ _` |/ _ \\ '__|||
                ||| |_| | | | (_| |  __/ |   ||
                || \\___/|_|  \\__,_|\\___|_|   ||
                >>===========================<<
                
                1) Add Sandwich
                2) Add Drink
                3) Add Chips
                4) Checkout
                0) Cancel Order
                Enter a command:\s""";
        boolean menuRunning = true;
        Order order = new Order("");

        while (menuRunning) {
            int command = InputParser.getAInteger(message);

            switch (command) {
                case 1:
                    boolean addSandwich = true;

                    while (addSandwich) {
                        // make a new sandwich
                        Sandwich sandwich = new Sandwich(promptForBreadType(),
                                promptForSize(),
                                promptForToasted());
                        // get the toppings
                        promptForMeats(sandwich);
                        promptForCheeses(sandwich);
                        promptForToppings(sandwich);
                        promptForSauces(sandwich);
                        order.addSandwich(sandwich); // add the sandwich to the order

                        String input = InputParser.getAString("Would you like to add another Sandwich(y for yes)? ");

                        if (input.equalsIgnoreCase("y") || input.contains("yes"))
                            continue; // start next Sandwich addition

                        addSandwich = false; // otherwise
                    }
                    break;
                case 2:
                    boolean addDrink = true;

                    while (addDrink) {
                        // prompt for size, add a drink, prompt for additional drinks
                        Drink drink = new Drink(promptForSize());
                        order.addDrink(drink);

                        String input = InputParser.getAString("Would you like to add another drink? ");

                        if (input.equalsIgnoreCase("y") || input.contains("yes"))
                            continue; // start next addition

                        addDrink = false; // otherwise
                    }
                    break;
                case 3:
                    boolean addChips = true;

                    while (addChips) {
                        // add chips prompt for additional chips
                        Chips chips = new Chips();
                        order.addChips(chips);

                        String input = InputParser.getAString("Would you like to add more chips? ");

                        if (input.equalsIgnoreCase("y") || input.contains("yes"))
                            continue; // start next addition

                        addChips = false; // otherwise end loop
                    }
                    break;
                case 4:
                    //checkOut();
                    break;
                case 0:
                    menuRunning = false;
                    break;
                default:
                    System.out.println("Invalid selection");
            }
        }

    }

    // this method prompts the user for a bread type
    public BreadType promptForBreadType() {
        int command = InputParser.getAInteger("""
                Bread Selection:
                1) White Bread
                2) Wheat Bread
                3) Rye Bread
                4) Wrap
                Enter Bread Type:\s""");

        BreadType breadType = null; // initialize breadType
        boolean menuRunning = true;

        while (menuRunning) {
            switch (command) {
                case 1:
                    breadType = BreadType.WHITE;
                    break;
                case 2:
                    breadType = BreadType.WHEAT;
                    break;
                case 3:
                    breadType = BreadType.RYE;
                    break;
                case 4:
                    breadType = BreadType.WRAP;
                    break;
                default:
                    System.out.println("Invalid selection");
                    break;
            }
            if (breadType != null) {
                menuRunning = false;
            }
            else {
                System.out.println("Bread Type is null!");
            }
        }

        return breadType;
    }

    // this method prompts the user for a size
    public int promptForSize() {

        int size = 0;
        boolean menuRunning = true;

        while (menuRunning) {
            char input = InputParser.getAString("""
                    (s)mall
                    (m)edium
                    (l)arge
                    Enter a size:\s""").toLowerCase().charAt(0);

            menuRunning = false;

            switch (input) {
                case 's':
                    size = 1;
                    break;
                case 'm':
                    size = 2;
                    break;
                case 'l':
                    size = 3;
                    break;
                default:
                    System.out.println("Invalid selection");
                    menuRunning = true;
            }
        }

        return size;
    }

    // this method asks the user if they want their sandwich toasted
    public boolean promptForToasted() {
        boolean isToasted = false;

        String input = InputParser.getAString("Would you like your sandwich toasted? ");

        if (input.equalsIgnoreCase("y") || input.contains("yes"))
            isToasted = true;


        return isToasted;
    }

    // this method asks the user for meats they want to add to the sandwich
    public void promptForMeats(Sandwich sandwich) {

        boolean isExtra = false;
        boolean addMeat = true;

        String message = """
                +-------------+-------+-------+-------+
                | Type        |  4"   |  8"   | 12"  |
                +-------------+-------+-------+-------+
                | Steak       | $1.00 | $2.00 | $3.00 |
                | Ham         | $1.00 | $2.00 | $3.00 |
                | Salami      | $1.00 | $2.00 | $3.00 |
                | Roast Beef  | $1.00 | $2.00 | $3.00 |
                | Chicken     | $1.00 | $2.00 | $3.00 |
                | Bacon       | $1.00 | $2.00 | $3.00 |
                | Extra Meat  | $0.50 | $1.00 | $1.50 |
                +-------------+-------+-------+-------+
                
                Enter your Meat selection (none for no meat):\s""";

        while (addMeat) {
            addMeat = false;
            String input = InputParser.getAString(message).toLowerCase();

            switch (input) {
                case "steak":
                    sandwich.addMeat(MeatType.STEAK, isExtra);
                    break;
                case "ham":
                    sandwich.addMeat(MeatType.HAM, isExtra);
                    break;
                case "salami":
                    sandwich.addMeat(MeatType.SALAMI, isExtra);
                    break;
                case "roast beef":
                    sandwich.addMeat(MeatType.ROAST_BEEF, isExtra);
                    break;
                case "chicken":
                    sandwich.addMeat(MeatType.CHICKEN, isExtra);
                    break;
                case "bacon":
                    sandwich.addMeat(MeatType.BACON, isExtra);
                    break;
                default:
                    if (!input.equals("none")) { // check if the user doesn't want any meat
                        System.out.println("Invalid selection");
                        addMeat = true;
                    }
            }
            if (!input.equals("none")) {
                String command = InputParser.getAString("Would you like to add more meat? ").toLowerCase();

                if (command.startsWith("y") || command.contains("yes"))
                    addMeat = true;
            }

        }
    }

    // this method asks the user for cheeses they want to add to the sandwich
    public void promptForCheeses(Sandwich sandwich) {

        boolean isExtra = false;
        boolean addCheese = true;

        String message = """
                +---------------+-------+-------+-------+
                | Type          |  4"   |  8"   | 12"  |
                +---------------+-------+-------+-------+
                | American      | $0.75 | $1.50 | $2.25 |
                | Provolone     | $0.75 | $1.50 | $2.25 |
                | Cheddar       | $0.75 | $1.50 | $2.25 |
                | Swiss         | $0.75 | $1.50 | $2.25 |
                | Extra Cheese  | $0.30 | $0.60 | $0.90 |
                +---------------+-------+-------+-------+
                
                Enter your cheese selection (none for no cheese):\s""";

        while (addCheese) {
            addCheese = false;
            String input = InputParser.getAString(message).toLowerCase();

            switch (input) {
                case "american":
                    sandwich.addCheese(CheeseType.AMERICAN, isExtra);
                    break;
                case "provolone":
                    sandwich.addCheese(CheeseType.PROVOLONE, isExtra);
                    break;
                case "cheddar":
                    sandwich.addCheese(CheeseType.CHEDDAR, isExtra);
                    break;
                case "swiss":
                    sandwich.addCheese(CheeseType.SWISS, isExtra);
                    break;
                default:
                    if (!input.equals("none")) { // check if the user doesn't want any meat
                        System.out.println("Invalid selection");
                        addCheese = true;
                    }
            }
            if (!input.equals("none")) {
                String command = InputParser.getAString("Would you like to add more cheese? ").toLowerCase();

                if (command.startsWith("y") || command.contains("yes"))
                    addCheese = true;
            }

        }
    }

    // this method asks the user for toppings they want to add to the sandwich
    public void promptForToppings(Sandwich sandwich) {

        boolean addTopping = true;
        String message = """
                +------------------+-------------------+
                |     Toppings     |       Price       |
                +------------------+-------------------+
                | Lettuce          | Included          |
                | Peppers          | Included          |
                | Onions           | Included          |
                | Tomatoes         | Included          |
                | Jalapeños        | Included          |
                | Cucumbers        | Included          |
                | Pickles          | Included          |
                | Guacamole        | Included          |
                | Mushrooms        | Included          |
                +------------------+-------------------+
                
                Enter your topping selection(none for no toppings):\s""";

        while (addTopping) {
            addTopping = false;
            String input = InputParser.getAString(message).toLowerCase();

            switch (input) {
                case "lettuce":
                    sandwich.addTopping(ToppingType.LETTUCE);
                    break;
                case "peppers":
                    sandwich.addTopping(ToppingType.PEPPERS);
                    break;
                case "onions":
                    sandwich.addTopping(ToppingType.ONIONS);
                    break;
                case "tomatoes":
                    sandwich.addTopping(ToppingType.TOMATOES);
                    break;
                case "jalapeños":
                    sandwich.addTopping(ToppingType.JALAPENOS);
                    break;
                case "cucumbers":
                    sandwich.addTopping(ToppingType.CUCUMBERS);
                    break;
                case "pickles":
                    sandwich.addTopping(ToppingType.PICKLES);
                    break;
                case "guacamole":
                    sandwich.addTopping(ToppingType.GUACAMOLE);
                    break;
                case "mushrooms":
                    sandwich.addTopping(ToppingType.MUSHROOMS);
                    break;
                default:
                    if (!input.equals("none")) { // check if the user doesn't want any meat
                        System.out.println("Invalid selection");
                        addTopping = true;
                    }
            }
            if (!input.equals("none")) {
                String command = InputParser.getAString("Would you like to add more toppings? ").toLowerCase();

                if (command.startsWith("y") || command.contains("yes"))
                    addTopping = true;
            }

        }
    }

    // this method asks the user for toppings they want to add to the sandwich
    public void promptForSauces(Sandwich sandwich) {

        boolean addSauce = true;
        String message = """
                +------------------+-------------------+
                |      Sauces      |      Price        |
                +------------------+-------------------+
                | Mayo             | Included          |
                | Mustard          | Included          |
                | Ketchup          | Included          |
                | Ranch            | Included          |
                | Thousand Island  | Included          |
                | Vinaigrette      | Included          |
                +------------------+-------------------+
                
                Enter your sauce selection (none for no sauce):\s""";

        while (addSauce) {
            addSauce = false;
            String input = InputParser.getAString(message).toLowerCase();

            switch (input) {
                case "mayo":
                    sandwich.addSauce(SauceType.MAYO);
                    break;
                case "mustard":
                    sandwich.addSauce(SauceType.MUSTARD);
                    break;
                case "ketchup":
                    sandwich.addSauce(SauceType.KETCHUP);
                    break;
                case "ranch":
                    sandwich.addSauce(SauceType.RANCH);
                    break;
                case "thousand island":
                    sandwich.addSauce(SauceType.THOUSAND_ISLAND);
                    break;
                case "vinaigrette":
                    sandwich.addSauce(SauceType.VINAIGRETTE);
                    break;
                default:
                    if (!input.equals("none")) { // check if the user doesn't want any meat
                        System.out.println("Invalid selection");
                        addSauce = true;
                    }
            }
            if (!input.equals("none")) {
                String command = InputParser.getAString("Would you like to add more sauce? ").toLowerCase();

                if (command.startsWith("y") || command.contains("yes"))
                    addSauce = true;
            }

        }
    }

    // this method submits the users order
}

