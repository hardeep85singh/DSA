package com.example.dsalgo.bitmanipulation;

/**
 * @author Hardeep Singh
 */
public class CheckOddEven {
    public static void main(String[] args) {
        System.out.print(isEven(66666669));
    }

    public static boolean isEven(int num){
        if((num & 1) == 0){
            return true;
        } else {
            return false;
        }
    }
}
