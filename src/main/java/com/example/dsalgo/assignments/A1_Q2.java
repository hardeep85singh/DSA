package com.example.dsalgo.assignments;

import java.util.InputMismatchException;
import java.util.Scanner;

// Algorithm 2: Simple Travel-Time Computer
public class A1_Q2 {
    public static void main(String[] args) {
        // Constants
        final int HYPERSPEED = 28000; // miles per hour
        final double MILES_TO_KILOMETERS = 1.61;

        // Display welcome message
        System.out.println("Welcome to the Simple Travel-Time Computer\n" +
                "++++++++++++++++++++++++++++++++++++++++++\n");

        // Create a scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Prompt user for distance input
        System.out.print("Please enter the distance (in kilometers) to your extraterrestrial destination: ");

        // Read user input
        if (scanner.hasNextDouble()) {
            double distance = scanner.nextDouble();

            if (distance > 0) {
                // Calculate travel time
                double timeInHours = distance / (HYPERSPEED * MILES_TO_KILOMETERS);
                long timeInDays = Math.round(timeInHours / 24);

                // Display travel time
                System.out.printf("Project-S spaceship, constantly traveling at %d mi/h, will take approximately %n%d " +
                                          "'Earth-based days' to get to its foreknown extraterrestrial destination.%n%n%n", HYPERSPEED, timeInDays);

                // Display closing message
                System.out.print("Thank you for your contribution to Project-S.");
            } else {
                // throw InputMismatchException
                throw new InputMismatchException();
            }
        } else {
            // throw InputMismatchException
            throw new InputMismatchException();
        }

        // Close the scanner
        scanner.close();
    }
}

