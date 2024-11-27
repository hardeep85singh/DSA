package com.example.dsalgo.leetcode.easy;

public class E1863SumOfAllSubsetXORTotals {
    public static void main(String[] args) {
        int [] nums = {5,1,6};
        System.out.println(subsetXORSum(nums));
    }

    public static int subsetXORSum(int[] nums) {
        return dfs(nums, 0, 0);
    }

    private static int dfs(int[] nums, int i, int xors) {
        if (i == nums.length) {
            return xors;
        }

        int x = dfs(nums, i + 1, xors);
        int y = dfs(nums, i + 1, nums[i] ^ xors);
        return x + y;
    }
}
