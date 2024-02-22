package com.example.dsalgo.leetcode.easy;

import java.util.Arrays;

/**
 * @author Hardeep Singh
 */
public class E1480RunningSumOf1dArray {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        System.out.println(Arrays.toString(runningSum(nums)));
    }

    public static int[] runningSum(int[] nums) {

        for(int i = 0; i< nums.length-1; i++){
            nums[i+1] = nums[i] + nums[i+1];
        }
        return nums;
    }
}
