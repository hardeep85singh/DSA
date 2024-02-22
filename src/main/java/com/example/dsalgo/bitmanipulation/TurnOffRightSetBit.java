package com.example.dsalgo.bitmanipulation;

/**
 * @author Hardeep Singh
 * @since 05-02-2023
 */
public class TurnOffRightSetBit {
    public static void main(String[] args) {
        ShowBits.showBits(7);
        System.out.println("");
        ShowBits.showBits(turnOffRightSetBit(7));
        System.out.println("");
        ShowBits.showBits(turnOffRightSetBit1(7));
    }

    public static int turnOffRightSetBit(int n){
        return n & (n-1);
    }

//    The rightmost set bit can be switched off by subtracting the LSB from the number.
//    The LSB of a number can be obtained using (n & (-n)), therefore the number with the rightmost set bit of n switched off is equal to n – (n & (-n));

    public static int turnOffRightSetBit1(int n){
        return n - ( n & (-n));
    }

}
