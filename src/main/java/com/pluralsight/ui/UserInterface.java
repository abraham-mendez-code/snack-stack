package com.pluralsight.ui;

import com.pluralsight.models.*;
import com.pluralsight.models.enums.*;
import com.pluralsight.util.InputParser;
import com.pluralsight.util.ReceiptWriter;

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
                        processMakeSandwichRequest(order);

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
                        System.out.println("Fountain Drink added to your order");

                        String input = InputParser.getAString("Would you like to add another drink? ");

                        if (input.equalsIgnoreCase("y") || input.contains("yes"))
                            continue; // start next addition

                        addDrink = false; // otherwise
                    }
                    break;
                case 3:
                    boolean addChips = true;

                    while (addChips) {

                        order.addChips(promptForChip());

                        String input = InputParser.getAString("Would you like to add more chips? ");

                        if (input.equalsIgnoreCase("y") || input.contains("yes"))
                            continue; // start next addition

                        addChips = false; // otherwise end loop
                    }
                    break;
                case 4:
                    processCheckoutRequest(order);
                    break;
                case 0:
                    menuRunning = false;
                    break;
                default:
                    System.out.println("Invalid selection");
            }
        }

    }

    private void processMakeSandwichRequest(Order order) {

        boolean menuRunning = true;
        String message = """
                
                +==================================================+
                |           SNACK STACK SIGNATURE SANDWICHES       |
                +==================================================+
                | 1) The Classic Club                              |
                |     Ham, Turkey, bacon, cheddar, lettuce,        |
                |     tomato, and mayo on White Bread (Toasted).   |
                |     Price: $12.50 (8")                            |
                |--------------------------------------------------|
                | 2) Philly Supreme                                |
                |     Steak, provolone, grilled onions, peppers,   |
                |     and mushrooms on Wheat Bread (Toasted).      |
                |     Price: $10.50 (8")                            |
                |--------------------------------------------------|
                | 3) Italian Stallion                              |
                |     Salami, ham, provolone, lettuce, tomato,     |
                |     onion, vinaigrette, and Italian herbs on     |
                |     White Bread (Toasted).                       |
                |     Price: $11.50 (8")                            |
                |--------------------------------------------------|
                | 4) Chicken Ranch Melt                            |
                |     Grilled chicken, bacon, cheddar, lettuce,    |
                |     tomato, and ranch on a Wrap (Toasted).       |
                |     Price: $11.50 (8")                            |
                |--------------------------------------------------|
                | 5) Veggie Delight                                |
                |     Swiss cheese, cucumber, tomato, lettuce,     |
                |     pickles, peppers, mushrooms, and vinaigrette |
                |     on Wheat Bread (Toasted).                    |
                |     Price: $8.50 (8")                            |
                |--------------------------------------------------|
                | 6) BBQ Bacon Beast                               |
                |     Roast beef, bacon, cheddar, onions, and      |
                |     BBQ sauce on Rye Bread (Toasted).            |
                |     Price: $11.50 (8")                            |
                |--------------------------------------------------|
                | 7) Turkey Avocado Crunch                         |
                |     Turkey, provolone, lettuce, tomato,          |
                |     guacamole, and ranch on Wheat Bread (Toasted).|
                |     Price: $10.50 (8")                            |
                |--------------------------------------------------|
                | 8) Create Your Own Sandwich                      |
                |     Build your own masterpiece by selecting      |
                |     bread, size, meats, cheeses, toppings, and   |
                |     sauces.                                      |
                +==================================================+
                
                Enter your Selection:\s""";

        while (menuRunning) {
            int command = InputParser.getAInteger(message);
            menuRunning = false;

            switch (command) {
                case 1:
                    // The Classic Club
                    Sandwich classicClub = new Sandwich(
                            BreadType.WHITE,
                            8,      // size
                            true    // toasted
                    );

                    classicClub.addMeat(MeatType.HAM, false);
                    classicClub.addMeat(MeatType.TURKEY, true);
                    classicClub.addMeat(MeatType.BACON, true);
                    classicClub.addCheese(CheeseType.CHEDDAR, false);
                    classicClub.addTopping(ToppingType.LETTUCE);
                    classicClub.addTopping(ToppingType.TOMATOES);
                    classicClub.addSauce(SauceType.MAYO);
                    order.addSandwich(classicClub);
                    break;
                case 2:
                    // Philly Supreme
                    Sandwich philly = new Sandwich(
                            BreadType.WHEAT,
                            8,
                            true
                    );

                    philly.addMeat(MeatType.STEAK, false);
                    philly.addCheese(CheeseType.PROVOLONE, false);
                    philly.addTopping(ToppingType.PEPPERS);
                    philly.addTopping(ToppingType.ONIONS);
                    philly.addTopping(ToppingType.MUSHROOMS);
                    order.addSandwich(philly);
                    break;
                case 3:
                    // Italian Stallion
                    Sandwich italian = new Sandwich(
                            BreadType.WHITE,
                            8,
                            true
                    );

                    italian.addMeat(MeatType.SALAMI, false);
                    italian.addMeat(MeatType.HAM, true);
                    italian.addCheese(CheeseType.PROVOLONE, false);
                    italian.addTopping(ToppingType.LETTUCE);
                    italian.addTopping(ToppingType.TOMATOES);
                    italian.addTopping(ToppingType.ONIONS);
                    italian.addSauce(SauceType.VINAIGRETTE);
                    order.addSandwich(italian);
                    break;
                case 4:
                    // Chicken Ranch Melt
                    Sandwich chickenRanch = new Sandwich(
                            BreadType.WRAP,
                            8,
                            true
                    );

                    chickenRanch.addMeat(MeatType.CHICKEN, false);
                    chickenRanch.addMeat(MeatType.BACON, true);
                    chickenRanch.addCheese(CheeseType.CHEDDAR, false);
                    chickenRanch.addTopping(ToppingType.LETTUCE);
                    chickenRanch.addTopping(ToppingType.TOMATOES);
                    chickenRanch.addSauce(SauceType.RANCH);
                    order.addSandwich(chickenRanch);
                    break;
                case 5:
                    // Veggie Delight
                    Sandwich veggie = new Sandwich(
                            BreadType.WHEAT,
                            8,
                            true
                    );

                    veggie.addCheese(CheeseType.SWISS, false);
                    veggie.addTopping(ToppingType.CUCUMBERS);
                    veggie.addTopping(ToppingType.TOMATOES);
                    veggie.addTopping(ToppingType.LETTUCE);
                    veggie.addTopping(ToppingType.PICKLES);
                    veggie.addTopping(ToppingType.PEPPERS);
                    veggie.addTopping(ToppingType.MUSHROOMS);
                    veggie.addSauce(SauceType.VINAIGRETTE);
                    order.addSandwich(veggie);
                    break;
                case 6:
                    // BBQ Bacon Beast
                    Sandwich bbqBacon = new Sandwich(
                            BreadType.RYE,
                            8,
                            true
                    );

                    bbqBacon.addMeat(MeatType.ROAST_BEEF, false);
                    bbqBacon.addMeat(MeatType.BACON, true);
                    bbqBacon.addCheese(CheeseType.CHEDDAR, false);
                    bbqBacon.addTopping(ToppingType.ONIONS);
                    bbqBacon.addSauce(SauceType.BBQ);
                    order.addSandwich(bbqBacon);
                    break;
                case 7:
                    // Turkey Avocado Crunch
                    Sandwich turkeyAvocado = new Sandwich(
                            BreadType.WHEAT,
                            8,
                            true
                    );
                    turkeyAvocado.addMeat(MeatType.TURKEY, false);
                    turkeyAvocado.addCheese(CheeseType.PROVOLONE, false);
                    turkeyAvocado.addTopping(ToppingType.LETTUCE);
                    turkeyAvocado.addTopping(ToppingType.TOMATOES);
                    turkeyAvocado.addTopping(ToppingType.GUACAMOLE);
                    turkeyAvocado.addSauce(SauceType.RANCH);
                    order.addSandwich(turkeyAvocado);
                    break;
                case 8:
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
                    break;
                default:
                    System.out.println("Invalid selection");
                    menuRunning = true;
                    break;
            }

        }
    }

    // FUNCTION MENUS

    // this method prompts the user for a bread type
    public BreadType promptForBreadType() {
        int command = InputParser.getAInteger("""
                
                +----------------+-------+-------+-------+
                | Bread Type     |  4"   |  8"   | 12"  |
                +----------------+-------+-------+-------+
                | 1) White Bread | $5.50 | $7.00 | $8.50 |
                | 2) Wheat Bread | $5.50 | $7.00 | $8.50 |
                | 3) Rye Bread   | $5.50 | $7.00 | $8.50 |
                | 4) Wrap        | $5.50 | $7.00 | $8.50 |
                +----------------+-------+-------+-------+
                
                Enter your Bread selection:\s""");

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
            } else {
                System.out.println("Bread Type is null!");
            }
        }

        return breadType;
    }

    // this method prompts the user for a size
    public int promptForSize() {

        int size = 0;
        boolean menuRunning = true;
        String message = """
                
                +--------+
                | Size   |
                +--------+
                | Small  |
                | Medium |
                | Large  |
                +--------+
                
                Enter your size:\s""";

        while (menuRunning) {
            String input = InputParser.getAString(message).toLowerCase();

            menuRunning = false;

            switch (input) {
                case "small":
                    size = 1;
                    break;
                case "medium":
                    size = 2;
                    break;
                case "large":
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
                |Turkey       | $1.00 | $2.00 | $3.00 |
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
                
                +------------------+
                |     Toppings     |
                +------------------+
                | Lettuce          |
                | Peppers          |
                | Onions           |
                | Tomatoes         |
                | Jalapeños        |
                | Cucumbers        |
                | Pickles          |
                | Guacamole        |
                | Mushrooms        |
                +------------------+
                
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
                
                +------------------+
                |      Sauces      |
                +------------------+
                | Mayo             |
                | Mustard          |
                | BBQ              |
                | Ketchup          |
                | Ranch            |
                | Thousand Island  |
                | Vinaigrette      |
                +------------------+
                
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

    // this method prompts the user for chip type
    public Chips promptForChip() {

        boolean menuRunning = true;
        Chips chip = null;
        String message = """
                
                +------------------------+-------------------+
                |         Chips          |       Price       |
                +------------------------+-------------------+
                | 1) Classic             | $1.50             |
                | 2) Barbecue            | $1.50             |
                | 3) Sour Cream & Onion  | $1.50             |
                | 4) Salt & Vinegar      | $1.50             |
                | 5) Cheddar & Sour Cream| $1.50             |
                +------------------------+-------------------+
                
                Enter your chip selection:\s""";

        while (menuRunning) {
            int input = InputParser.getAInteger(message);
            menuRunning = false;

            switch (input) {
                case 1:
                    chip = new Chips(ChipType.CLASSIC);
                    break;
                case 2:
                    chip = new Chips(ChipType.BARBECUE);
                    break;
                case 3:
                    chip = new Chips(ChipType.SOUR_CREAM_AND_ONION);
                    break;
                case 4:
                    chip = new Chips(ChipType.SALT_AND_VINEGAR);
                    break;
                case 5:
                    chip = new Chips(ChipType.CHEDDAR_AND_SOUR_CREAM);
                    break;
                default:
                    System.out.println("Invalid Selection");
                    menuRunning = true;
            }
        }
        return chip;
    }

    // this method submits the users order
    public void processCheckoutRequest(Order order) {

        System.out.print(order.getDescription());

        String input = InputParser.getAString("Would you like to submit this order(y/n) ").toLowerCase(); // validate order

        if (input.startsWith("y") || input.contains("yes")) { // if order validated

            // orders must have a sandwich, a drink, or chips (cannot be empty)
            if (!order.getSandwiches().isEmpty() || (!order.getChips().isEmpty() || !order.getDrinks().isEmpty())) {
                ReceiptWriter receiptWriter = new ReceiptWriter();
                receiptWriter.saveReceipt(order);
                System.out.println("Order submitted successfully");
            } else {
                // otherwise
                System.out.println("Error: insufficient items in cart");
            }
        }

    }
}

