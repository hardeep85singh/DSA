package com.example.dsalgo.leetcode.medium;

/**
 * @author Hardeep Singh
 */
public class M334IncreasingTripletSubsequence {
    public static void main(String[] args) {
        int[] nums = {1, 5, 0, 4, 1, 3};
        System.out.println(increasingTriplet(nums));
    }

    public static boolean increasingTriplet(int[] nums) {
        int first_num = Integer.MAX_VALUE;
        int second_num = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n <= first_num) {
                first_num = n;
            } else if (n <= second_num) {
                second_num = n;
            } else {
                return true;
            }
        }
        return false;
    }
}
