package com.pluralsight.util;

import java.util.Scanner;

public class InputParser {

    // CLASS ATTRIBUTES
    private static Scanner scanner = new Scanner(System.in);

    // CONSTRUCTOR
    private InputParser() {};

    // methods for getting parsing user input
    public static double getADouble(String message) {
        double price;
        // get a valid price
        while (true) {
            try {
                System.out.print(message);
                price = Double.parseDouble(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Only numbers allowed");
            }
        }
        return price;
    }

    public static int getAInteger(String message) {
        int odometer;
        while (true) {
            try {
                System.out.print(message);
                odometer = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Only numbers allowed");
            }
        }
        return odometer;
    }

    public static String getAString(String message) {

        String output;
        // get a valid model
        while (true) {

            System.out.print(message);
            output = scanner.nextLine().trim();

            if (output.matches("[0-9]+")) {
                System.out.println("No numbers allowed.");
                continue;
            }
            if (output.isBlank()) {
                System.out.println("Cannot be empty.");
                continue;
            }
            break;
        }
        return output;
    }

}
