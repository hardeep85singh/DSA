package com.example.dsalgo.bitmanipulation;

/**
 * @author Hardeep Singh
 */
//Explanation 1:
//
//        DECIMAL    BINARY  SET BIT COUNT
//        1          01        1
//        2          10        1
//        3          11        2
//        1 + 1 + 2 = 4
//        Answer = 4 % 1000000007 = 4

public class CountTotalSetBits {
    public static void main(String[] args) {
        int n = 17;
        System.out.println(solve(n));
        System.out.println(countSetBits(n));
        System.out.println(countSetBitsRecursive(n));
    }
    static int mod = (int)1e9 + 7;

    public static int solve(int n) {
        long res = 0;
        // Integer.bitCount(num) returns number of set bit in num in constant time
        for(int i = 1; i <= n; i++){
            res += Integer.bitCount(i);
        }
        return (int)(res%mod);
    }

    public static int countSetBits(int n){
        int leftMostSetBitInd = leftMostSetBit(n);

        int totalRep, mod;
        int nearestPow;
        int totalSetBitCount = 0;
        int addRemaining = 0;
        int curr = 0; // denotes the number of set bits at index i
        for (int i = 1; i <= leftMostSetBitInd; ++i) {
            nearestPow = (int)Math.pow(2, i);
            if (nearestPow > n) {
                int lastPow = (int)Math.pow(2, i - 1);
                mod = n % lastPow;
                totalSetBitCount = totalSetBitCount + mod + 1;
            }
            else {
                if (i == 1 && n % 2 == 1) {
                    totalRep = (n + 1) / nearestPow;
                    mod = nearestPow % 2;
                    addRemaining = 0;
                }
                else {
                    totalRep = n / nearestPow;
                    mod = n % nearestPow;

                    if (mod >= (nearestPow / 2)) {
                        addRemaining = mod - (nearestPow / 2) + 1;
                    }
                    else {
                        addRemaining = 0;
                    }
                }

                curr = totalRep * (nearestPow / 2) + addRemaining;
                totalSetBitCount = totalSetBitCount + curr;
            }
        }
        return totalSetBitCount;
    }

    private static int leftMostSetBit(int n){
        int pos = 0;
        while (n > 0){
            pos++;
            n = n >> 1;
        }
        return pos;
    }

    public static int countSetBitsRecursive(int n){
        if(n <= 1){
            return n;
        }
        int x = findLargestPower(n);
        return (x * (int) Math.pow(2, (x-1)))
                + (n - (int) Math.pow(2, x) + 1)
                + countSetBits(n - (int) Math.pow(2,x));
    }
    public static int findLargestPower(int n){
        int x = 0;
        while ((1 << x) <= n){
            x++;
        }
        return x -1;
    }
}
