package com.example.dsalgo.leetcode.medium;

/**
 * @author Hardeep Singh
 */
public class M53MaximumSubArray {
    public static void main(String[] args) {
        int[] nums = {-1, 2, -1, -4, 6, 2};
        System.out.println(maxSubArrayRecursion(nums));
    }

    public static int maxSubArrayBrute(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                maxSum = Math.max(sum, maxSum);
                sum = sum + nums[j];
            }
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
    }

    public static int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int i = 0;
        int j = 0;
        int sum = nums[i];
        maxSum = Math.max(sum, maxSum);
        while (j < nums.length - 1) {
            j++;
            if (sum >= 0) {
                sum = sum + nums[j];
            } else {
                i = j;
                sum = nums[i];
            }
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
    }

    public static int maxSubArrayRecursion(int[] nums) {
        int[] numsArray = nums;
        return findMaxSubArray(numsArray, 0, nums.length - 1);
    }

    private static int findMaxSubArray(int[] numsArray, int left, int right) {
        if (left > right) {
            return Integer.MIN_VALUE;
        }
        int mid = Math.floorDiv(left + right, 2);
        int curr = 0;
        int bestSumLeft = 0;
        int bestSumRight = 0;
        for (int i = left; i < mid; i++) {
            curr += numsArray[i];
            bestSumLeft = Math.max(bestSumLeft, curr);
        }
        curr = 0;
        for (int i = mid + 1; i <= right; i++) {
            curr += numsArray[i];
            bestSumRight = Math.max(bestSumRight, curr);
        }
        int bestSum = numsArray[mid] + bestSumLeft + bestSumRight;

        int leftHalf = findMaxSubArray(numsArray, left, mid - 1);
        int rightHalf = findMaxSubArray(numsArray, mid + 1, right);

        return Math.max(bestSum, Math.max(leftHalf, rightHalf));
    }
}
