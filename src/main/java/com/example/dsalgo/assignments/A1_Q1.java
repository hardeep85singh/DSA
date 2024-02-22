package com.example.dsalgo.assignments;

// Algorithm 1: Simple Cipher Program
public class A1_Q1 {
    public static void main(String[] args) {

        // Display welcome message
        System.out.println("Project-S Access System: 6-Piece Puzzle Authentication Challenge:\n" +
                                   "+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        // Render and Display outputs
        System.out.println("7 @ 5  8 @ 3  4 @ 2  20 @ 14  9 @ 3  45 @ 20");
        System.out.println("  |      |      |       |       |       |");

        // implement cipher program algorithm
        int z4 = (20 / 14) + (20 % 14);
        int z5 = (9 / 3) + (9 % 3);
        int z6 = (45 / 20) + (45 % 20);

        System.out.println("  3      4      2       "+z4+"       "+z5+"       "+z6);
        System.out.println();

        // Display closing message
        System.out.println("At Project-S, we employ multi-factor authentication because one password is never enough.");
    }
}
