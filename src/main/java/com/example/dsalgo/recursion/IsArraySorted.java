package com.example.dsalgo.recursion;

/**
 * @author Hardeep Singh
 * @since 18-09-2023
 */
public class IsArraySorted {
    public static void main(String[] args) {
        int[] nums = {1,2,3,2};
        System.out.println(isArraySorted(nums));
    }

    private static boolean isArraySorted(int[] nums) {
        return helper(nums, 0);
    }

    private static boolean helper(int[] nums, int i) {
        if(i == nums.length-1){
            return true;
        }
        if(nums[i] <= nums[i+1]){
            return helper(nums, i+1);
        }
        return false;
    }
}
