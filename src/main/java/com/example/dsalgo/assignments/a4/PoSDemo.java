package com.example.dsalgo.assignments.a4;

import java.util.Scanner;

public class PoSDemo {

    private static PoS[] createPoSInstances() {
        // PoS instance 1
        Sales sales1 = new Sales(2, 1, 0, 4, 1);
        PrePaiCard prePaiCard1A = new PrePaiCard("Vegetarian","40825164", 25, 12);
        PrePaiCard prePaiCard1B = new PrePaiCard("Carnivore","21703195", 3, 12);
        PrePaiCard[] prePaiCards1 = new PrePaiCard[2];
        prePaiCards1[0] = prePaiCard1A;
        prePaiCards1[1] = prePaiCard1B;
        PoS poS1 = new PoS(sales1, prePaiCards1);

        // PoS instance 2
        Sales sales2 = new Sales(2, 1, 0, 4, 1);
        PrePaiCard prePaiCard2A = new PrePaiCard("Vigan","40825164", 7, 12);
        PrePaiCard prePaiCard2B = new PrePaiCard("Vegetarian","21596387", 24, 8);
        PrePaiCard[] prePaiCards2 = new PrePaiCard[2];
        prePaiCards2[0] = prePaiCard2A;
        prePaiCards2[1] = prePaiCard2B;
        PoS poS2 = new PoS(sales2, prePaiCards2);

        // PoS instance 3
        Sales sales3 = new Sales(0, 1, 5, 2, 0);
        PrePaiCard prePaiCard3A = new PrePaiCard("Pescatarian","95432806", 1, 6);
        PrePaiCard prePaiCard3B = new PrePaiCard("Halal","42087913", 18, 12);
        PrePaiCard prePaiCard3C = new PrePaiCard("Kosher","40735421", 5, 4);
        PrePaiCard[] prePaiCards3 = new PrePaiCard[3];
        prePaiCards3[0] = prePaiCard3A;
        prePaiCards3[1] = prePaiCard3B;
        prePaiCards3[2] = prePaiCard3C;
        PoS poS3 = new PoS(sales3, prePaiCards3);

        // PoS instance 4
        Sales sales4 = new Sales(3, 2, 4, 1, 2);
        PrePaiCard[] prePaiCards4 = new PrePaiCard[0];
        PoS poS4 = new PoS(sales4, prePaiCards4);

        // PoS instance 5
        Sales sales5 = new Sales(3, 2, 4, 1, 2);
        PrePaiCard[] prePaiCards5 = new PrePaiCard[0];
        PoS poS5 = new PoS(sales5, prePaiCards5);
        return new PoS[]{poS1, poS2, poS3, poS4, poS5};
    }

    public static void main(String[] args) {
        // Display message
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n" +
                                   "|    Welcome to Concordia CostLessBites Catering Sales Counter Application      |\n" +
                                   "+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        // Initialize scanner for user inputs
        Scanner scanner = new Scanner(System.in);

        // Create PoS instances
        PoS[] posArray = createPoSInstances();

        // user choice to select from menu
        int choice;
        do {
            System.out.println("\n| What would you like to do?                                                    |");
            System.out.println("| 1  >> See the content of all PoSs                                             |");
            System.out.println("| 2  >> See the content of one PoS                                              |");
            System.out.println("| 3  >> List PoSs with same $ amount of sales                                   |");
            System.out.println("| 4  >> List PoS with same number of Sales categories                           |");
            System.out.println("| 5  >> List PoSs with same $ amount of Sales and same number of prepaid cards  |");
            System.out.println("| 6  >> Add a PrePaiCard to an existing PoS                                     |");
            System.out.println("| 7  >> Remove an existing prepaid card from a PoS                              |");
            System.out.println("| 8  >> Update the expiry date of an existing Prepaid card                      |");
            System.out.println("| 9  >> Add Sales to a PoS                                                      |");
            System.out.println("| 0  >> To quit                                                                 |");
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println();
            System.out.print("Please enter your choice and press <Enter>:");

            choice = scanner.nextInt();
            int index;
            switch (choice) {
                case 1:
                    displayAllPoSInfo(posArray);
                    break;
                case 2:
                    System.out.print("Which PoS you want to see the content of? (Enter number 0 to 4): ");
                    index = scanner.nextInt();
                    displaySinglePoSInfo(posArray, index, scanner);
                    break;
                case 3:
                    displayPoSInfoWithSameSalesTotal(posArray);
                    break;
                case 4:
                    displayPoSInfoWithSameSalesCategories(posArray);
                    break;
                case 5:
                    displayPoSInfoWithSameSalesTotalAndSamePrePaidCards(posArray);
                    break;
                case 6:
                    System.out.print("Which PoS to you want to add an PrePaiCard to? (Enter number 0 to 4): ");
                    index = scanner.nextInt();
                    addPrePaiCard(posArray, index, scanner);
                    break;
                case 7:
                    System.out.print("Which PoS you want to remove an PrePaiCard from? (Enter number 0 to 4): ");
                    index = scanner.nextInt();
                    removeExistingCard(posArray, index, scanner);
                    break;
                case 8:
                    System.out.print("Which PoS do you want to update an PrePaiCard from? (Enter number 0 to 4): ");
                    index = scanner.nextInt();
                    updatePrepaidCardExpiry(posArray, index, scanner);
                    break;
                case 9:
                    System.out.print("Which PoS do you want to add Sales to? (Enter number 0 to 4): ");
                    index = scanner.nextInt();
                    addSalesToPoS(posArray, index, scanner);
                    break;
                case 0:
                    System.out.println("Thank you for using Concordia CostLessBites Catering Sales Counter Application!");
                    break;
                default:
                    System.out.println("Sorry that is not a valid choice. Try again.");
            }

        } while (choice != 0);

        scanner.close();
    }

    private static void displayAllPoSInfo(PoS[] posArray) {
        System.out.println("Content of each PoS:\n________________");
        for (int i = 0; i < posArray.length; i++) {
            System.out.println("PoS #" + i + ":\n" + posArray[i]);
        }
    }

    private static void displaySinglePoSInfo(PoS[] posArray, int index, Scanner scanner) {
        while (index < 0 || index >= posArray.length){
            System.out.println("Sorry but there is no PoS number " + index);
            System.out.print("--> Try again: (Enter number 0 to 4): ");
            index = scanner.nextInt();
        }
        System.out.println(posArray[index].toString());
    }

    private static void displayPoSInfoWithSameSalesTotal(PoS[] posArray) {
        System.out.println("List of PoSs with same total $ Sales:\n");
        for (int i = 0; i < posArray.length; i++){
            for (int j = i + 1; j < posArray.length; j++){
                if(posArray[i].getTotalSales() == posArray[j].getTotalSales()){
                    System.out.format("     PoSs %d and %d both have %d\n", i, j, posArray[i].getTotalSales());
                }
            }
        }
    }

    private static void displayPoSInfoWithSameSalesCategories(PoS[] posArray) {
        System.out.println("List of PoSs with same Sales categories:\n");
        for (int i = 0; i < posArray.length; i++){
            for (int j = i + 1; j < posArray.length; j++){
                if(posArray[i].isEqualSalesCategories(posArray[j])){
                    System.out.format("     PoSs %d and %d both have ", i, j);
                    System.out.println(posArray[i].getSales().toString());
                }
            }
        }
    }

    private static void displayPoSInfoWithSameSalesTotalAndSamePrePaidCards(PoS[] posArray) {
        System.out.println("List of PoSs with same $ amount of sales and same number of PrePaiCards :\n");
        for (int i = 0; i < posArray.length; i++){
            for (int j = i + 1; j < posArray.length; j++){
                if(posArray[i].isEqualTotalSales(posArray[j])
                        && posArray[i].getNumberOfPrepaidCards() == posArray[j].getNumberOfPrepaidCards()){
                    System.out.format("     PoSs %d and %d\n", i, j);
                }
            }
        }
    }

    private static void addPrePaiCard(PoS[] posArray, int index, Scanner scanner) {
        System.out.print("Please enter the following information so that we may complete the PrePaiCard-\n" +
                                   "--> Type of PrePaiCard (Carnivore, Halal, Kosher, Pescatarian, Vegetarian, Vigan):");
        PoS poS = posArray[index];
        String type = scanner.next();
        System.out.print("--> Id of the prepaid card owner: ");
        String id = scanner.next();
        System.out.print("--> Expiry day number and month (seperate by a space):");
        int expiryDay = scanner.nextInt();
        int expiryMonth = scanner.nextInt();
        PrePaiCard prePaiCard = new PrePaiCard(type, id, expiryDay, expiryMonth);
        poS.addPrepaidCard(prePaiCard);
        System.out.println("You now have 1 PrePaiCard");
    }

    private static void removeExistingCard(PoS[] posArray, int index, Scanner scanner) {
        PoS poS = posArray[index];
        int totalCards = poS.getNumberOfPrepaidCards();
        if(totalCards == 0){
            System.out.println("Sorry that PoS has no PrePaiCards");
            return;
        }
        System.out.format("(Enter number 0 to %d): ", totalCards - 1);
        int cardIndex = scanner.nextInt();
        poS.removePrepaidCard(poS.getPrePaiCards()[cardIndex]);
        System.out.println("PrePaiCard was removed successfully");
    }

    private static void updatePrepaidCardExpiry(PoS[] posArray, int index, Scanner scanner) {
        PoS poS = posArray[index];
        int totalCards = poS.getNumberOfPrepaidCards();
        if(totalCards > 0){
            System.out.format("Which PrePaiCard do you want to update? (Enter number 0 to %d): ", totalCards - 1);
        } else {
            System.out.println("There is no PrePaiCard to update for PoS " + index);
            return;
        }
        int cardIndex = scanner.nextInt();
        System.out.print("--> Enter new expiry date day number and month (separate by a space): ");
        int day = scanner.nextInt();
        int month = scanner.nextInt();
        poS.updatePrepaidCardExpiry(poS.getPrePaiCards()[cardIndex], day, month);
        System.out.println("Expiry Date updated.");
    }

    private static void addSalesToPoS(PoS[] posArray, int index, Scanner scanner) {
        System.out.println("How many junior, teen ,medium,big and family meal menu do you want to add?");
        System.out.print("Enter 5 numbers seperated by a space): ");
        int count = 0;
        PoS poS = posArray[index];
        int[] mealCount = new int[5];
        while (count < 5){
            int num = scanner.nextInt();
            mealCount[count] = num;
            count++;
        }
        int sales = poS.addMealSales(mealCount[0], mealCount[1], mealCount[2], mealCount[3], mealCount[4]);
        System.out.format("You now have $%d", sales);
    }
}
