package com.example.dsalgo.dynamicprogramming;

import java.util.ArrayList;

public class NumberOfBits {

    // N spaces can be filled with 0 or 1, but no 2 consecutive spaces can be filled with 1
    // how many ways this can be done
    public static void main(String[] args) {
        System.out.println(numberOfBits(5));
    }

    public static int numberOfBits(int n){
        int[] dp = new int[n];
        for (int i = 0; i < n-2; i++) {
            dp[i] = -1;
        }
        dp[n-1] = 2; // 1, 0 only 2 possible cases
        dp[n-2] = 3;  // 01, 10, 00 only 3 possible cases
        return solve(0, n, dp);
    }

    private static int solve(int i, int n, int[] dp){
        if(i >= n){
            return -1;
        }
        if(dp[i] != -1){
            return dp[i];
        } else {
            return solve(i+1, n, dp) + solve(i+2, n, dp);
        }
    }
}
