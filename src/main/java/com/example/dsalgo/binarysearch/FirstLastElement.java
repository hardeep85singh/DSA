package com.example.dsalgo.binarysearch;

import java.util.Arrays;

/**
 * @author Hardeep Singh
 * @since 05-09-2023
 */
public class FirstLastElement {
    public static void main(String[] args) {
        int[] nums = {5,7,7,7,7,7,7,8,8,10};
        System.out.println(Arrays.toString(searchRange(nums, 14)));
    }

    public static int[] searchRange(int[] nums, int target){
        int[] ans = {-1, -1};

        int smallestIndex = findSmallest(nums, target);
        int greatestIndex = findGreatest(nums, target);
        ans[0] = smallestIndex + 1;
        ans[1] = greatestIndex - 1;
        if(target < nums[0]){
            ans[0] = -1;
        } else if (target > nums[nums.length-1]){
            ans[0] = -1;
            ans[1] = -1;
        }
        return ans;
    }
    private static int search(int[] nums, int target, boolean findStartIndex){
        int ans = -1;
        int start = 0;
        int end = nums.length -1;
        while (start <= end){
            int mid = start + (end - start) / 2;
            if(target > nums[mid]){
                start = mid + 1;
            } else if (target < nums[mid]){
                end = mid -1;
            } else {
                ans = mid;
                if(findStartIndex){
                    end = mid -1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return ans;
    }
    private static int findSmallest(int[] nums, int target) {
        int start = 0;
        int end = nums.length -1;
        while (start <= end){
            int mid = start + (end - start) / 2;
            if(target > nums[mid]){
                start = mid + 1;
            } else if (target <= nums[mid]){
                end = mid -1;
            }
        }
        return end;
    }

    private static int findGreatest(int[] nums, int target) {
        int start = 0;
        int end = nums.length -1;
        while (start <= end){
            int mid = start + (end - start) / 2;
            if(target >= nums[mid]){
                start = mid + 1;
            } else {
                end = mid -1;
            }
        }
        return start;
    }

}
