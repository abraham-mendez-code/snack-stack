package com.pluralsight.ui;

import com.pluralsight.models.Chips;
import com.pluralsight.models.Drink;
import com.pluralsight.models.Order;
import com.pluralsight.models.Sandwich;
import com.pluralsight.models.enums.BreadType;
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
                Enter a command:/s""";
        boolean menuRunning = true;
        Order order = new Order("");

        while (menuRunning) {
            int command = InputParser.getAInteger(message);

            switch (command) {
                case 1:
                    boolean addSandwich = true;

                    while (addSandwich) {
                        // make a new sandwich
                        //Sandwich sandwich = new Sandwich(promptForBreadType(),
                                //promptForSize(),
                                //promptForToasted());

                        // get the toppings
                        //promptForMeats(sandwich);
                        //promptForCheeses(sandwich);
                        //promptForToppings(sandwich);
                        //promptForSauces(sandwich);

                        //order.addSandwich(sandwich); // add the sandwich to the order


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
                        //Drink drink = new Drink(promptForSize());
                        //order.addDrink(drink);

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

                        addChips = false; // otherwise
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
                Enter Bread Type:/s""");

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
}

