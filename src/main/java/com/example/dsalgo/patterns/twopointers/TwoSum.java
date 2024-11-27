package com.example.dsalgo.patterns.twopointers;

import java.util.Arrays;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {-1,0};
        System.out.println(twoSum(nums, -1));
    }

    private static boolean twoSum(int[] nums, int target){
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length -1;
        while (i < j){
            int sum = nums[i] + nums[j];
            if(sum == target){
                return true;
            } else if(sum < target){
                i++;
            } else {
                j--;
            }
        }
        return false;
    }
}
