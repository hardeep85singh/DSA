package com.example.dsalgo.leetcode.medium;

public class M1653MinimumDeletionsToMakeStringBalanced {
    public static void main(String[] args) {
        String s = "aababbab";
        System.out.println(minimumDeletions(s));
    }

    // Same as 926. Flip String to Monotone Increasing
    public static int minimumDeletions(String s) {
        // the number of characters to be deleted to make subString so far balanced
        int dp = 0;
        int countB = 0;

        for (char c : s.toCharArray()) {
            if (c == 'a') {
                // 1. Delete 'a'.
                // 2. Keep 'a' and delete the previous 'b's.
                dp = Math.min(dp + 1, countB);
            } else {
                countB++;
            }
        }
        return dp;
    }
}
