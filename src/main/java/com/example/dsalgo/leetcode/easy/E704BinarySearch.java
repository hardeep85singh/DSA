package com.example.dsalgo.leetcode.easy;

/**
 * @author Hardeep Singh
 */
public class E704BinarySearch {
    public static void main(String[] args){
        int[] nums = {1,2,3,4,5,6};
        System.out.println(search(nums, 0));
    }

    public static int search(int[] nums, int target){
        int left = 0;
        int right = nums.length -1;
//        return binarySearchRecursive(nums, target, left, right);
        return binarySearch(nums, target, left, right);
    }

    public static int binarySearchRecursive(int[] nums, int target, int left, int right) {
        if(left > right){
            return -1;
        } else {
            int mid = (right + left) / 2;
            if(nums[mid] == target){
                return mid;
            } else if(target < nums[mid]){
                return binarySearchRecursive(nums, target, left, mid-1);
            } else{
                return binarySearchRecursive(nums, target, mid+1, right);
            }
        }
    }

    public static int binarySearch(int[] nums, int target, int left, int right){
        while(left <= right) {
            int mid = (right + left) / 2;
            if(nums[mid] == target){
                return mid;
            }
            if(target < nums[mid]){
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return -1;
    }
}
