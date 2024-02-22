package com.example.dsalgo.binarysearch;

/**
 * @author Hardeep Singh
 * @since 04-09-2023
 */
public class CeilingOfNumber {
    public static void main(String[] args) {
        int [] nums = {2, 4, 7, 9, 14, 19, 23, 29};
        System.out.println(nums[ceiling(nums, 21)]);
    }

    // return the index of the smallest number >= target
    public static int ceiling(int[] nums, int target) {
        if(target > nums[nums.length -1]){
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start <= end){
            int mid = start + (end - start) / 2; // due to integer overflow in java
            if(target < nums[mid]){
                end = mid - 1;
            } else if (target > nums[mid]){
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return start;
    }
}
