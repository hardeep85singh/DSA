package com.example.dsalgo.binarysearch;

/**
 * @author Hardeep Singh
 * @since 04-09-2023
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {-10, -5, 6, 8, 9, 13, 30};
        System.out.println(binarySearch(nums, 8));
    }

    public static int binarySearch(int[] nums, int target){
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
        return -1;
    }
}
