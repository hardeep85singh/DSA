package com.example.dsalgo.leetcode.medium;

/**
 * @author Hardeep Singh
 */
// Given an array of positive integers nums and a positive integer target,
// return the minimal length of a contiguous subarray [numsl, numsl+1, ..., numsr-1, numsr]
// of which the sum is greater than or equal to target.
// If there is no such subarray, return 0 instead.
public class M209MinimumSizeSubarraySum {
    public static void main(String[] args){
        int[] nums = {1,2,3,4,5};
        System.out.println(minSubArrayLenBetterBinarySearch(15, nums));
    }
    public static int minSubArrayLenSlidingWindow(int target, int[] nums) {
        int sum = 0;
        int left = 0;
        int right = 0;
        int minLength = Integer.MAX_VALUE;
        int currLength = 0;
        while (right < nums.length){
            sum = sum + nums[right];
            while (sum >= target) {

                currLength = right - left + 1;
                minLength = Math.min(currLength, minLength);
//                if(minLength == nums.length && sum <= target){
//                    return minLength;
//                }
                sum = sum - nums[left];
                left++;
            }
            right++;
        }
        return minLength == nums.length ? 0:minLength;
    }

    public static int minSubArrayLenBrute(int target, int[] nums){
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i< nums.length; i++){
            for (int j = i; j< nums.length; j++){
                int sum = 0;
                for(int k = i; k<= j; k++){
                    sum = sum + nums[k];
                }
                if(sum >= target){
                    minLen = Math.min(minLen, (j-i+1));
                    break;
                }
            }
        }
        return minLen != Integer.MAX_VALUE ? minLen : 0;
    }

    public static int minSubArrayLenBetterThanBrute(int target, int[] nums){
        int[] sums = new int[nums.length];
        sums[0] = nums[0];
        for(int i = 1; i< nums.length; i++){
            sums[i] = sums[i-1] + nums[i];
        }
        int minLen = Integer.MAX_VALUE;

        for(int i = 0; i< nums.length; i++){
            for(int j = 1; j< nums.length; j++){
                int sum = sums[j] - sums[i] + nums[i];
                if(sum >= target){
                    minLen = Math.min(minLen, j - i +1);
                    break;
                }
            }
        }
        return minLen != Integer.MAX_VALUE ? minLen : 0;
    }

    public static int minSubArrayLenBetterBinarySearch(int target, int[] nums){
        int[] sums = new int[nums.length + 1];
        for(int i = 1; i<= nums.length; i++){
            sums[i] = sums[i-1] + nums[i-1];
        }
        int minLen = Integer.MIN_VALUE;

        for(int i = 1; i<= sums.length; i++){
            int toFind = target + sums[i-1];
            int lo = i+1;
            int hi = sums.length;
            while (lo < hi){
                int mid = (hi + lo) /2;
                if(sums[mid] >= toFind){
                    hi = mid;
                } else {
                    lo = mid+1;
                }
            }
            minLen = Math.max(minLen, (lo + i - 1));
        }
        return minLen != Integer.MIN_VALUE ? minLen : 0;
    }
}
