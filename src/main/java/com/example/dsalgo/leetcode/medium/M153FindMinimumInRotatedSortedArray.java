package com.example.dsalgo.leetcode.medium;

/**
 * @author Hardeep Singh
 */
public class M153FindMinimumInRotatedSortedArray {
    public static void main(String[] args){
        int[] nums = {3,4,5};
        System.out.println(findMin(nums));
    }

    public static int findMin(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int pivot;
        if(nums[0] < nums[nums.length-1]){
            pivot = 0;
        } else {
            pivot = findPivot(nums, 0, nums.length -1);
        }
        return nums[pivot];
    }
    private static int findPivot(int[] nums, int left, int right) {
        while (left <= right) {
            int pivot = (left + right) / 2;
            if (nums[pivot] > nums[pivot + 1])
                return pivot + 1;
            else {
                if (nums[pivot] < nums[left])
                    right = pivot - 1;
                else
                    left = pivot + 1;
            }
        }
        return 0;
    }
}
