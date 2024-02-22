package com.example.dsalgo.leetcode.medium;

import java.util.Arrays;

/**
 * @author Hardeep Singh
 */
public class M33SearchInRotatedSortedArray {
    public static void main(String[] args){
        int[] nums = {4,5,6,7,8,1,2,3};
        System.out.println(search1(nums, 8));
    }

    public static int search1(int[] nums, int target){
        int left = 0;
        int right = nums.length-1;

        return binarySearchIndex(nums, left, right, target);
    }

    public static int binarySearchIndex(int[] nums, int start, int end, int target){
        while (start <= end){
            int mid = (start + end) / 2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[start] <= nums[mid]){
                if(target >= nums[start] && target < nums[mid]){
                    return binarySearchIndex(nums, start, mid-1, target);
                } else {
                    return binarySearchIndex(nums, mid+1, end, target);
                }
            } else{
                if(target <= nums[end] && target > nums[mid]){
                    return binarySearchIndex(nums, mid+1, end, target);
                } else {
                    return binarySearchIndex(nums, start, mid-1, target);
                }
            }
        }
        return -1;
    }
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int pivot = 0;
        if(nums.length == 1){
            pivot = 0;
        } else {
            pivot = findPivot(nums, left, right);
        }
        if(target == nums[pivot]){
            return pivot;
        } else if(target >= nums[pivot+1] && target <= nums[right]){
            return binarySearch(nums, pivot+1, right, target) ;
        } else if (target <= nums[pivot] && target >= nums[left]){
            return binarySearch(nums, left, pivot, target);
        } else {
            return -1;
        }
    }

    private static int findPivot(int[] nums, int left, int right) {
        while(left <= right){
            int mid = (left + right) / 2;
            if(nums[mid] > nums[mid+1]){
                return mid +1;
            }
            // nums[pivot] < nums[left]
            if(nums[mid] < nums[left]){
                left = mid +1;
            } else {
                right = mid-1;
            }
        }
        return 0;
    }
    private static int binarySearch(int[] nums, int left, int right, int target) {

        while (left <= right){
            int mid = (right + left) /2;
            if(target == nums[mid]){
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
