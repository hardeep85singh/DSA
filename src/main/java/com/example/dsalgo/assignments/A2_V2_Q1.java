package com.example.dsalgo.assignments;

import java.util.Scanner;

// -------------------------------------------------------
// Assignment {include number}
// Written by: {include your name and student ID}
// For COMP 248 Section {your section} – Fall 2023
// --------------------------------------------------------
public class A2_V2_Q1 {

    public static void main(String[] args) {

        // Display welcome message
        System.out.println("-------****-------****-------****-------****-----*****-----");
        System.out.println("Welcome to BMI Calculator");
        System.out.println("-------****-------****-------****-------****-----*****-----\n");

        // Initialize scanner to get user input
        Scanner scanner = new Scanner(System.in);

        // Get user inputs
        System.out.print("Enter your weight in kilograms: ");
        double weight = scanner.nextDouble();

        System.out.print("Enter your height in meters: ");
        double height = scanner.nextDouble();

        // Calculate BMI
        double bmi = weight / (height * height);

        // Display BMI using string format method
        System.out.format("BMI %.2f%n", bmi);

        String category;
        // Select weight category with respect to BMI
        if (bmi < 18.5) {
            category = "Underweight";
        } else if (bmi >= 18.5 && bmi <= 24.9) {
            category = "Normal weight";
        } else if (bmi >= 25 && bmi <= 29.9) {
            category = "Overweight";
        } else {
            category = "Obesity";
        }

        // Display category
        System.out.println("Category: " + category);

        // Ask user for some tips
        System.out.println("Do you want some tips according to your BMI?");
        String userResponse = scanner.next();

        // Display tip
        if (userResponse.equals("yes") || userResponse.equalsIgnoreCase("y")) {
            // Display tip with respect to category if user inputs yes/Y/y
            switch (category) {
                case "Underweight":
                    System.out.println("Please eat well and do more exercises.");
                    break;
                case "Normal weight":
                    System.out.println("Congratulations, you are doing fairly well. Keep on going.");
                    break;
                case "Overweight":
                    System.out.println("Please watch out what you eat and do more exercises!");
                    break;
                default:
                    System.out.println("Please contact our experts for professional help.");
                    break;
            }
        } else {
            // Display tip with respect to category if user inputs non yes/Y/y
            System.out.println("Nice to meet you too. Bye!");
        }
        scanner.close();
    }
}
