package com.example.dsalgo.leetcode.easy;

/**
 * @author Hardeep Singh
 */
public class E191NumberOf1Bits {
    public static void main(String[] args){
        int n = hammingWeight(1011);
        System.out.println(n);
    }

    public static int hammingWeight(int n) {
        int ans = 0;
        while(n > 0 || n < 0){
            n = n & (n - 1);
            ans++;
        }
        return ans;
//        int count = 0;
//        return hammingWeightRecur(n, count);
    }
    public static int hammingWeightRecur(int n, int count){
        if(n / 10 == 0 && n % 10 == 0){
            return count;
        }
        if(n /10 == 0 && n % 10 == 1){
            return count+1;
        }
        int quotient = n / 10;
        int remainder = n % 10;
        if(remainder == 1){
            count = count+1;
        }
        return hammingWeightRecur(quotient, count);
    }
}
