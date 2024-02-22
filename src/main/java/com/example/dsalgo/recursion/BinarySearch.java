package com.example.dsalgo.recursion;

/**
 * @author Hardeep Singh
 * @since 17-09-2023
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 8, 11, 15};
        System.out.println(binarySearch(nums, 30));
    }

    public static int binarySearch(int[] nums, int target) {
        int start = 0;
        int end = nums.length -1;
        return binarySearchHelper(nums, target, start, end);
    }

    private static int binarySearchHelper(int[] nums, int target, int start, int end) {
        if(start > end){
            return -1;
        }
        int mid = start + (end - start) /2;
        if(target < nums[mid]){
            return binarySearchHelper(nums, target, start, mid-1);
        } else if (target > nums[mid]){
            return binarySearchHelper(nums, target, mid + 1, end);
        } else {
            return mid;
        }
    }
}
