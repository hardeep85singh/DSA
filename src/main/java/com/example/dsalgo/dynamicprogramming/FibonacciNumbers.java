package com.example.dsalgo.dynamicprogramming;

public class FibonacciNumbers {

    public static void main(String[] args) {
        System.out.println(fibonacciNumber(10));
        System.out.println(fiboDp(10));
    }

    public static int fibonacciNumber(int n){
        if(n == 0 || n == 1){
            return n;
        }
        return fibonacciNumber(n-1) + fibonacciNumber(n-2);
    }

    public static int fiboDp(int n){
        int[] dp = new int[n+1];
        return solve(n, dp);
    }

    private static int solve(int n, int[] dp) {
        if(n == 0 || n==1){
            return n;
        }
        if(dp[n] != 0){
            return dp[n];
        }
        int fibn = solve(n-1, dp) + solve(n-2, dp);
        dp[n] = fibn;
        return fibn;
    }
}
