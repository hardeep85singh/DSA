package com.example.dsalgo.recursion;

/**
 * @author Hardeep Singh
 * @since 17-09-2023
 */
public class Fibonacci {
    public static void main(String[] args){
        System.out.println(fibonacci(5));
    }

    public static int fibonacci(int num){
        if(num == 0){
            return 0;
        }
        if(num == 1){
            return 1;
        }
        return fibonacci(num -1) + fibonacci(num -2);
    }
}
