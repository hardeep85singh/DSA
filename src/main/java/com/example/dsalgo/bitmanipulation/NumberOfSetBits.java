package com.example.dsalgo.bitmanipulation;

/**
 * @author Hardeep Singh
 */
public class NumberOfSetBits {

    public static void main(String[] args) {
        initialize();
        System.out.println(countSetBits(11));
    }

    public static int countSetBitsOfNum(int n) {
        int count = 0;
        while (n > 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }

    public static int countSetBitsOfNumRightShift(int num) {
        int count = 0;
        while (num != 0) {
            if ((num & 1) != 0) {
                count++;
            }
            num = num >> 1;
        }
        return count;
    }

    // Lookup table
    static int[] BitsSetTable256 = new int[256];

    // Function to initialise the lookup table
    public static void initialize() {
        // To initially generate the table algorithmically
        BitsSetTable256[0] = 0;
        for (int i = 0; i < 256; i++) {
            BitsSetTable256[i] = (i & 1) + BitsSetTable256[i >> 1];
        }
    }

    // Function to return the count of set bits in n
    public static int countSetBits(int n) {
        return (BitsSetTable256[n & 0xff]
                + BitsSetTable256[(n >> 8) & 0xff]
                + BitsSetTable256[(n >> 16) & 0xff]
                + BitsSetTable256[n >> 24]);
    }
}
