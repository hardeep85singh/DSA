package com.example.dsalgo.leetcode.medium;

/**
 * @author Hardeep Singh
 */
public class M162FindPeakElement {
    public static void main(String[] args){
        int[] nums = {3, 4, 5, 3};
        System.out.println(findPeakElementIterative(nums));
    }

    public static int findPeakElementIterative(int[] nums){
        int left = 0;
        int right = nums.length -1;
        while(left < right){
            int mid = (right + left) / 2;
            if(nums[mid] > nums[mid + 1]){
                right = mid;
            } else {
                left = mid+1;
            }
        }
        return left;
    }

    public static int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length -1;
        return helper(nums, left, right);
    }

    public static int helper(int[] nums, int l, int r){
        if (l == r){
            return l;
        }
        int mid = (l + r) / 2;
        if(nums[mid] > nums[mid+1]){
            return helper(nums, l, mid);
        } else {
            return helper(nums, mid+1, r);
        }
    }
}
