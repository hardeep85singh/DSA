package com.example.dsalgo.leetcode.medium;

import java.util.Arrays;

/**
 * @author Hardeep Singh
 */

//Given an array nums with n objects colored red, white, or blue,
// sort them in-place so that objects of the same color are adjacent,
// with the colors in the order red, white, and blue.
//We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
public class M75SwapColors {
    public static void main(String[] args){
        int[] nums = {1,2,0,2,1,2,2,0};
        System.out.println(Arrays.toString(sortColorsOnePass(nums)));
    }
    // by sorting(quicksort, merge sort etc)
    // by storing values is map


    // brute
    public static int[] sortColorsBrute(int[] nums) {
        for(int i = 0; i< nums.length; i++){
            for(int j = i+1; j< nums.length; j++){
                if(nums[j] < nums[i]){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        return nums;
    }
//    {1,2,0,2,1,2,2,0}
    // 0 -> nums[low-1]
    // 1 - > nums[low] to nums[mid-1]
    // 2 -> nums[high+1]
    public static int[] sortColorsOnePass(int[] nums){
        int lo = 0;
        int mid = 0;
        int hi = nums.length-1;
        while (mid <= hi){
            if(nums[mid] == 0){
                // swap mid and lo elements and increment mid and lo
                int temp = nums[lo];
                nums[lo] = nums[mid];
                nums[mid] = temp;
                mid++;
                lo++;
            } else if(nums[mid] == 1){
                mid++;
            } else if(nums[mid] == 2){
                int temp = nums[mid];
                nums[mid] = nums[hi];
                nums[hi] = temp;
//                mid++;
                hi--;
            }
        }
        return nums;
    }
}
