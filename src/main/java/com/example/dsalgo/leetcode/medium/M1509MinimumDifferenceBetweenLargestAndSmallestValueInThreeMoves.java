package com.example.dsalgo.leetcode.medium;

import java.util.Arrays;

public class M1509MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves {
    public static void main(String[] args) {
        int[] nums = {6,1,1,0,4,6,6};
        System.out.println(minDifference(nums));
    }
    public static int minDifference(int[] nums) {
        int n = nums.length;
        if(n < 5){
            return 0;
        }
        Arrays.sort(nums);
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i <= 3; i++){
            ans = Math.min(ans, nums[n - 4 + i] - nums[i]);
        }

        return ans;
    }
}
