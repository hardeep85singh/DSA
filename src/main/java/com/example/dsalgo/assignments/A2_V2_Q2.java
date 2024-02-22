package com.example.dsalgo.assignments;

import java.util.Scanner;

// -------------------------------------------------------
// Assignment {include number}
// Written by: {include your name and student ID}
// For COMP 248 Section {your section} – Fall 2023
// --------------------------------------------------------
public class A2_V2_Q2 {
    public static void main(String[] args) {

        // Display welcome message
        System.out.println("-------****-------****-------****-------****-----*****-----");
        System.out.println("Welcome to Grade Calculator");
        System.out.println("-------****-------****-------****-------****-----*****-----\n");

        // Initialize scanner to get user input
        Scanner scanner = new Scanner(System.in);
        double score;

        // Get user inputs
        System.out.print("Enter the student's score (out to 100): ");
        score = scanner.nextDouble();

        // Conditions to display correct message
        // If score is less than 0 or greater than 100
        if (score < 0 || score > 100) {
            if (score < 0) {
                // Display below message if score is less than 0
                System.out.println("The score has to be zero or above. Please try again.");
            } else {
                // Display below message if score is greater than 100
                System.out.println("The score has to be below 100. Please try again.");
            }
            // User input for second retry
            score = scanner.nextDouble();
            // Display below message if score is still less than 0 or greater than 100
            if (score < 0 || score > 100) {
                System.out.println("It is still an invalid input. Bye!");
                System.exit(1);
            }
        } else {
            // Display grades if score is between and equal to 0 to 100
            String grade;
            if (score >= 90) {
                grade = "A";
            } else if (score >= 80) {
                grade = "B";
            } else if (score >= 70) {
                grade = "C";
            } else if (score >= 60) {
                grade = "D";
            } else {
                grade = "F";
            }
            System.out.println("The student’s grade is: " + grade);
        }
        scanner.close();
    }
}
