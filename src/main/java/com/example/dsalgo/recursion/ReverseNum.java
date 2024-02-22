package com.example.dsalgo.recursion;

/**
 * @author Hardeep Singh
 * @since 17-09-2023
 */
public class ReverseNum {
    public static void main(String[] args) {
        reverseNum(2367);
        System.out.println(reverse(1234));
    }

    static int sum = 0;

    private static void reverseNum(int n) {
        if (n == 0) {
            return;
        }
        sum = sum * 10 + n % 10;
        reverseNum(n / 10);
    }

    private static int reverse(int n) {
        int digits = (int) Math.log10(n) + 1;
        return helper(n, digits);
    }

    private static int helper(int n, int digits) {
        if (n % 10 == n) {
            return n;
        }
        int rem = n % 10;
        return rem * (int) Math.pow(10, digits - 1) + helper(n / 10, digits - 1);
    }

}
