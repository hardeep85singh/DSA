package com.example.dsalgo.leetcode.medium;

import java.util.Arrays;

public class M3075MaximizeHappinessOfSelectedChildren {
    public static void main(String[] args) {
        System.out.println(maximumHappinessSum(new int[]{12, 1, 42}, 3));
    }

    public static long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        reverseArray(happiness);
        int maxSum = happiness[0];
        int i = 1;
        k = k - 1;
        while (k != 0) {
            maxSum = maxSum + Math.max(happiness[i] - i, 0);
            i++;
            k--;
        }
        return maxSum;
    }

    private static void reverseArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
