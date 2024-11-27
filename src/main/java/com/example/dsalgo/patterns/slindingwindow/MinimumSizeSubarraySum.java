package com.example.dsalgo.patterns.slindingwindow;

public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        System.out.println(minSubArrayLen(7, nums));
    }

    public static int minSubArrayLen(int target, int[] nums){
        int windowSize = Integer.MAX_VALUE;
        int sum = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++){
            sum = sum + nums[right];
            while (sum >= target){
                windowSize = Math.min(windowSize, right - left + 1);
                sum = sum - nums[left];
                left++;
            }
        }

        return windowSize == Integer.MAX_VALUE ? 0 : windowSize;
    }
}
