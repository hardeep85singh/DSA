package com.example.dsalgo.patterns.slowfastpointers;

public class HappyNumber {
    public static void main(String[] args) {
        System.out.println(isHappyNumber(4));
    }

    public static boolean isHappyNumber(int n){
        int slowPtr = n;
        int fastPtr = squareOfNum(n);
        while (fastPtr != 1 && slowPtr != fastPtr){
            slowPtr = squareOfNum(slowPtr);
            fastPtr = squareOfNum(squareOfNum(fastPtr));
        }
        return fastPtr == 1;
    }

    private static int squareOfNum(int n){
        int r;
        int sqr = 0;
        while (n > 0){
            r = n % 10;
            n = n / 10;
            sqr = sqr + r * r;
        }
        return sqr;
    }
}
