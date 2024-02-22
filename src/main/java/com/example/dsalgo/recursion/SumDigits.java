package com.example.dsalgo.recursion;

/**
 * @author Hardeep Singh
 * @since 17-09-2023
 */
public class SumDigits {
    public static void main(String[] args) {
        System.out.println(sumDigits(1));
    }

    public static int sumDigits(int n){
        if(n == 0){
            return 0;
        }
        return (n % 10) + sumDigits(n /10);
    }
}
