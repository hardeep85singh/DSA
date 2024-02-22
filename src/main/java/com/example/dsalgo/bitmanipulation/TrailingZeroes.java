package com.example.dsalgo.bitmanipulation;

/**
 * @author Hardeep Singh
 */
public class TrailingZeroes {
    public static void main(String[] args) {
        System.out.println(trailingZeroesRightShift(8));
    }

    public static int trailingZeroesRightShift(int num){
        int count = 0;
        while (num != 0){
            if((num & 1) == 0){
                count++;
            } else {
                break;
            }
            num = num >> 1;
        }
        return count;
    }
}
