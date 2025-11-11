package com.pluralsight.ui;

import com.pluralsight.models.Chips;
import com.pluralsight.models.Drink;
import com.pluralsight.models.Order;
import com.pluralsight.models.Sandwich;

import java.util.Scanner;

public class UserInterface {

    // CLASS ATTRIBUTES
    private Scanner scanner = new Scanner(System.in);

    // CONSTRUCTOR
    public UserInterface() {};

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
            try {
                int command = Integer.parseInt(scanner.nextLine());

                switch(command) {
                    case 1:
                        //showOrderMenu();
                        break;
                    case 0:
                        menuRunning = false;
                        break;
                    default:
                        System.out.println("Invalid selection");
                }

            }
            catch (NumberFormatException e) {
                System.out.println("Only numbers allowed");
            }

        }
    }


}
