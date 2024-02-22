package com.example.dsalgo.assignments;

import java.util.Scanner;

// -------------------------------------------------------
// Assignment {include number}
// Written by: {include your name and student ID}
// For COMP 248 Section {your section} – Fall 2023
// --------------------------------------------------------
public class A3_Q2 {
    // This algorithm displays the maximum 3 top ranked skiers from a total of less than equal to 20 skiers
    public static void main(String[] args) {

        // Display welcome message
        System.out.println("Welcome to Mout-Halloween Skiing Contest Ranker.");

        Scanner scanner = new Scanner(System.in);

        // Constant for max number of skiers
        final int MAX_SKIERS = 20;

        // Arrays to store skier names and their times
        String[] skierNames = new String[MAX_SKIERS];
        int[] skiingTimes = new int[MAX_SKIERS];

        // Variables to track the indices of the top 3 skiers
        int firstPodiumIndex = -1;
        int secondPodiumIndex = -1;
        int thirdPodiumIndex = -1;

        // Loop to record skiers
        for (int i = 0; i < MAX_SKIERS; i++) {
            // Ask for skier name and time
            System.out.print("Please input the skier's name: Skier ");
            String name = scanner.next();
            System.out.print("Please input the skier's time: ");
            int time = scanner.nextInt();

            // Update arrays
            skierNames[i] = name;
            skiingTimes[i] = time;

            // Update podium indices
            // If there is a new time less than the firstPodium time than we update the indexes by updating firstPodium to new time,
            // previous firstPodium will become new secondPodium time
            // previous secondPodium will become new thirdPodium time
            // same logic applies if new time is less than secondPodium or thirdPodium
            if (firstPodiumIndex == -1 || time < skiingTimes[firstPodiumIndex]) {
                thirdPodiumIndex = secondPodiumIndex;
                secondPodiumIndex = firstPodiumIndex;
                firstPodiumIndex = i;
            } else if (secondPodiumIndex == -1 || time < skiingTimes[secondPodiumIndex]) {
                thirdPodiumIndex = secondPodiumIndex;
                secondPodiumIndex = i;
            } else if (thirdPodiumIndex == -1 || time < skiingTimes[thirdPodiumIndex]) {
                thirdPodiumIndex = i;
            }

            // Display podium so far
            // if there is only 1 skier, display message for first podium
            String displayMessageForFirstPodium = "First podium goes to Skier " + skierNames[firstPodiumIndex] + " who made it in " + skiingTimes[firstPodiumIndex] + " second(s)";
            if(i == 0){
                System.out.println(displayMessageForFirstPodium);
            } else {
                // if there are only 2 skiers, display message for first & second podium
                String displayMessageForSecondPodium = "Second podium goes to Skier " + skierNames[secondPodiumIndex] + " who made it in " + skiingTimes[secondPodiumIndex] + " second(s)";
                System.out.println(displayMessageForFirstPodium);
                System.out.println(displayMessageForSecondPodium);
                // if there 3 or more skiers, display message for first, second & third podium
                if (i > 1) {
                    System.out.println(
                            "Third podium goes to Skier " + skierNames[thirdPodiumIndex] + " who made it in " + skiingTimes[thirdPodiumIndex] + " second(s)");

                }
            }
            // Ask if the user wants to add another skier
            if (i < MAX_SKIERS - 1) {
                System.out.print("Do you want to add another skier? (y/yes): ");
                String input = scanner.next();
                // if the input is not equal to y or yes, then break from the for loop
                if (!input.equals("yes") && !input.equals("y")) {
                    break;
                }
            }
        }

        // Closing banner
        System.out.println("Goodbye!");

        // Close the scanner
        scanner.close();
    }
}
