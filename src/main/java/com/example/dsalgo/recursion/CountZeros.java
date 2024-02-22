package com.example.dsalgo.recursion;

/**
 * @author Hardeep Singh
 * @since 18-09-2023
 */
public class CountZeros {
    public static void main(String[] args) {
        System.out.println(countZeroes(1030490));
    }

    private static int countZeroes(int n) {
        return helper(n, 0);
    }

    private static int helper(int n, int c) {
        if(n == 0){
            return c;
        }
        int rem = n % 10;
        if(rem == 0){
            return helper(n/10, c+1);
        }
        return helper(n/10, c);
    }


}
