package com.example.dsalgo.recursion;

/**
 * @author Hardeep Singh
 * @since 17-09-2023
 */
public class Factorial {
    public static void main(String[] args) {
        System.out.println(factorial(10));
    }

    private static int factorial(int num) {
        if(num == 1){
            return 1;
        }
        return factorial(num -1) * num;
    }
}
