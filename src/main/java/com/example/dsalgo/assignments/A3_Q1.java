package com.example.dsalgo.assignments;

import java.util.Scanner;

// -------------------------------------------------------
// Assignment {include number}
// Written by: {include your name and student ID}
// For COMP 248 Section {your section} – Fall 2023
// --------------------------------------------------------
public class A3_Q1 {
    // This algorithm take numbers as an input and do Addition & Subtraction operation on these numbers.
    // Only one operation is allowed by selecting the operation. 1 for Addition & 2 for Subtraction.
    public static void main(String[] args) {

        // Display welcome message
        System.out.println("Welcome to this calculator, offering Addition and Subtraction.");

        // Initialize scanner to get user input
        Scanner scanner = new Scanner(System.in);

        // Initialize variable if user wants to continue calculating
        boolean continueCalculating = true;

        while (continueCalculating) {
            // Get user input for Addition or Subtraction option
            System.out.print("Please select 1 for Addition or 2 for Subtraction: ");
            int choice = scanner.nextInt();
            System.out.print("Please input your numbers: ");
            if (choice == 1) { // Do addition
                    int count = scanner.nextInt();
                    double result = 0;
                    for (int i = 0; i < count; i++) {
                        double number = scanner.nextDouble();
                        result = result + number;
                    }
                    System.out.printf("The result of your addition is: %.2f\n", result);
            } else if (choice == 2) { // Do subtraction
                int count = scanner.nextInt();
                double result = 0;
                for (int i = 0; i < count; i++) {
                    double number = scanner.nextDouble();
                    result = result - number;
                }
                System.out.printf("The result of your subtraction is: %.2f\n", result);
            } else {
                System.out.println("Operation not supported. Please try again.");
                continue;
            }

            // If user like to perform another operation
            System.out.print("Do you want to perform another operation? y/yes: ");
            String continueChoice = scanner.next();
            if (!continueChoice.equalsIgnoreCase("Y") && !continueChoice.equalsIgnoreCase("Yes")) {
                // Closing banner
                System.out.println("Goodbye!");
                continueCalculating = false;
            }
        }
        // Close the scanner
        scanner.close();
    }
}
