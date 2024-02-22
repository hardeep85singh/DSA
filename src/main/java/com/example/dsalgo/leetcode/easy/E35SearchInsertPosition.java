package com.example.dsalgo.leetcode.easy;

/**
 * @author Hardeep Singh
 */
public class E35SearchInsertPosition {
    public static void main(String[] args){
        int [] arr = {1};
        int n = searchInsert(arr, 0);
        System.out.println(n);
    }

    public static int searchInsert(int[] nums, int target) {
        int first = 0;
        int last = nums.length -1;
        int index = -1;
        while(first <= last){
            int mid = first + (last - first) /2;
            if(nums[mid] == target){
                index = mid;
            }
            if(target < nums[mid]){
                last = mid-1;
            } else {
                first = mid+1;
            }
        }
        first = 0;
        last = nums.length -1;
        if(index == -1){
            while(first <= last){
                int mid = (first + last) / 2;
                if(target > nums[last]){
                    index = last+1;
                } else if(target < nums[first]){
                    index = first;
                } else if(target < nums[mid] && target > nums[mid-1]){
                    index = mid;
                }

                if(target < nums[mid]){
                    last = mid-1;
                } else if(target > nums[mid]){
                    first = mid+1;
                }
            }
        }
        return index;

    }
}
