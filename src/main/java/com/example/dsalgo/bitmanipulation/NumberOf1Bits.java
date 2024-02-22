package com.example.dsalgo.bitmanipulation;

/**
 * @author Hardeep Singh
 */
public class NumberOf1Bits {
    public static void main(String[] args) {
        System.out.println(numberOf1Bits(7));
        System.out.println(numberOf1BitsRightShift(7));
    }

    // timecomplexity - number of 1 bits operations
    public static int numberOf1Bits(int num){
        int count = 0;
        while (num != 0){
            num = num & (num-1);
            count++;
        }
        return count;
    }

    public static int numberOf1BitsRightShift(int num){
        int count = 0;
        while (num != 0){
            if((num & 1) != 0){
                count++;
            }
            num = num >> 1;
        }
        return count;
    }
}
