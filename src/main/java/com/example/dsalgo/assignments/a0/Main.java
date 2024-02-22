package com.example.dsalgo.assignments.a0;

import java.util.Scanner;

public class Main {
    private static int choice;
    private static Book[] inventory;
    private static int maxBooks;
    private static final int password = 249;
    private static int newBooks;

    static Scanner sc = new Scanner(System.in);


    public static void display() {

        System.out.print(" ===================================================\n" +
                                 "What do you want to do? \n" +
                                 "1. Enter new books (password required)\n" +
                                 "2. Change information of a book (password required)\n" +
                                 "3. Display all books by a specific author\n" +
                                 "4. Display all books under a certain a price.\n" +
                                 "5. Quit\n" +
                                 "===================================================\n" +
                                 "Please enter your choice >	");

    }

    public static void userChoice() {
        switch (choice) {
            case 1:
                addBooks();
                break;
            case 2:
                updateInformation();
                break;
            case 3:
                displayBooksByAuthor();
                break;
            case 4:
                displayBooksByPrice();
                break;
            case 5:
                System.out.println("Have a nice day!");
            default:
                System.out.print("The entered value is unrecognized!");
                break;
        }
    }

    private static void updateInformation() {
        System.out.print("Enter password > ");
        int pass = sc.nextInt();
        System.out.println();
        if (password == pass) {
        }
    }

    private static void displayBooksByAuthor() {
        System.out.print("Enter author's name > ");
        String author3 = sc.next();
        int count = 0;
        for (int i = 0; i < Book.findNumberOfCreatedBooks(); i++) {
            count++;
            if (inventory[i].getAuthor().equals(author3)) {
                System.out.println(count + ". " + inventory[i].toString());
            }
        }
    }

    private static void displayBooksByPrice() {
        System.out.println("Enter author's name > ");
        int price3 = sc.nextInt();
        int count = 0;
        for (int i = 0; i <= inventory.length; i++) {
            count++;
            if (inventory[i].getPrice() <= price3) {
                System.out.println(count + ". " + inventory[i].toString());
            }
        }
    }

    private static void addBooks() {
        System.out.print("Enter password > ");
        int pass = sc.nextInt();
        System.out.println();
        if (password == pass) {
            System.out.print("How many books do you want to enter > ");
            newBooks = sc.nextInt();
            int currentBookCount = Book.findNumberOfCreatedBooks();
            if (newBooks <= (maxBooks - currentBookCount)) {
                System.out.println("There is enough space to add books!");
                for (int i = currentBookCount; i < currentBookCount + newBooks; i++) {

                    System.out.print("Enter book's title > ");
                    sc.nextLine();
                    String title2 = sc.nextLine();

                    System.out.print("Enter author's name > ");
                    String author2 = sc.nextLine();

                    System.out.print("Enter ISBN > ");
                    long ISBN2 = sc.nextLong();

                    System.out.print("Enter price > ");
                    double price2 = sc.nextDouble();


                    inventory[i] = new Book(title2, author2, ISBN2, price2);
                    if (i < newBooks - 1) {
                        System.out.println("Next Book!");
                        System.out.println("-------------------------------");
                    }
                }
            } else {
                System.out.println("Not enough space!");
            }

        } else {
            System.out.println("wrong password");
        }
    }

    public static void main(String[] args) {

        System.out.println("Welcome!");
        System.out.print("Enter Maxixmum Numbers of Books: ");
        maxBooks = sc.nextInt();
        inventory = new Book[maxBooks];
        System.out.println();

        do {
            display();
            choice = sc.nextInt();
            userChoice();
        } while (choice != 5);

    }

}

