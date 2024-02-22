package com.example.dsalgo.sorting;

import java.util.Arrays;

/**
 * @author Hardeep Singh
 * @since 01-10-2023
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] nums = {52, 46, 72, -11, -3, 0};
        System.out.println(Arrays.toString(selectionSortMax(nums)));
    }

    // by checking the minimum number of the array & swap starting from 1st index
    public static int[] selectionSortMin(int[] nums) {
        for (int i = 0; i < nums.length-1; i++) {
            int minIndex = i;
            for (int j = i +1; j < nums.length; j++) {
                if (nums[minIndex] > nums[j]) {
                    minIndex = j;
                }
            }
            swap(nums, i, minIndex);
        }
        return nums;
    }

    // by checking the maximum number of the array & swap starting from last index
    public static int[] selectionSortMax(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int maxIndex = 0;
            for (int j = 0; j < nums.length - i; j++) {
                if (nums[maxIndex] < nums[j]) {
                    maxIndex = j;
                }
            }
            swap(nums, nums.length -1 - i, maxIndex);
        }
        return nums;
    }

    private static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
