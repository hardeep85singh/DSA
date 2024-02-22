package com.example.dsalgo.binarysearch;

/**
 * @author Hardeep Singh
 * @since 05-09-2023
 */
public class SmallerNoThanTarget {
    public static void main(String[] args) {
        int [] nums = {2, 4, 7, 9, 14, 19, 23, 29};
        System.out.println(smallerNoThanTarget(nums, 8));
    }

    public static int smallerNoThanTarget(int[] nums, int target){
        if(target < nums[0]){
            return -1;
        }
        int start = 0;
        int end = nums.length -1;

        while (start <= end){
            int mid = start + (end -start) / 2;
            if(target < nums[mid]){
                end = mid - 1 ;
            } else {
                start = mid +1;
            }
        }
        return nums[end];
    }
}
