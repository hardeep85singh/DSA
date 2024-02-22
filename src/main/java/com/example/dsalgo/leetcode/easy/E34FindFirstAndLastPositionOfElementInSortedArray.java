package com.example.dsalgo.leetcode.easy;

import java.util.Arrays;

/**
 * @author Hardeep Singh
 */
public class E34FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args){
        int[] nums = {5};
        System.out.println(Arrays.toString(searchRange(nums, 5)));
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] result = {-1,-1};
        int first = findBound(nums, target, true);

        if(first == -1){
            return result;
        }
        int last = findBound(nums, target, false);
        result[0] = first;
        result[1] = last;
        return result;
    }

    private static int findBound(int[] nums, int target, boolean isFirst) {
        int left = 0;
        int right = nums.length-1;
        while (left <= right){
            int mid = (right + left)/2;
            if(nums[mid] == target){
                if(isFirst){
                    if(mid == 0 || nums[mid-1] != nums[mid]){
                        return mid;
                    }
                    right = mid-1;
                } else {
                    if(mid == right || nums[mid+1] != nums[mid]){
                        return mid;
                    }
                    left = mid +1;
                }
            } else if(nums[mid] < target){
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        return -1;
    }


//    public static int[] searchRange(int[] nums, int target) {
//        int[] res = {-1,-1};
//        if(nums.length == 0){
//            return res;
//        }
//        int left = 0;
//        int right = nums.length -1;
//        int index = binarySearch(nums, target, left, right);
//        if(index == -1){
//            return res;
//        }
//        int leftIdx = -1;
//        int rightIdx = -1;
//        if(nums[left] == nums[index]){
//            leftIdx = left;
//        } else        if (nums[index - 1] < nums[index]) {
//            leftIdx = index;
//        } else {
//            leftIdx = searchLeftRangeHelper(nums, left, index, target);
//        }
//
//        if(nums[right] == nums[index]){
//            rightIdx = right;
//        } else if (nums[index + 1] > nums[index]) {
//            rightIdx = index;
//        } else {
//            rightIdx = searchRightRangeHelper(nums,index, right, target);
//        }
//
//        res[0] = leftIdx;
//        res[1] = rightIdx;
//        return res;
//    }
//
//    private static int searchRightRangeHelper(int[] nums, int left, int right, int target) {
//           int index = binarySearch(nums, target, left, right);
//           if (nums[index + 1] > nums[index]) {
//                return index;
//           }
//           return searchRightRangeHelper(nums, index, right, target);
//    }
//
//    private static int searchLeftRangeHelper(int[] nums, int left, int right, int target) {
//            int index = binarySearch(nums, target, left, right);
//            if (nums[index - 1] < nums[index]) {
//                return index;
//            }
//            return searchLeftRangeHelper(nums, left, index, target);
//
//    }


    private static int binarySearch(int[] nums, int target, int left, int right) {

        while (left <= right){
            int mid = left + (right - left) /2;
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
