package com.example.dsalgo.bitmanipulation;

/**
 * @author Hardeep Singh
 */
public class SwapTwoNumbers {
    public static void main(String[] args) {
        swap(5, 7);
    }

    public static void swap(int a, int b){
        System.out.println("a -> " + a + " b -> " + b);
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("a -> " + a + " b -> " + b);
    }
}
