package com.example.dsalgo.sorting;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] nums = {5, 2, 4, 6, 8, 1, 7};
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
        Arrays.sort(nums);
    }

    private static void quickSort(int[] nums, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int s = lo;
        int e = hi;
        int m = s + (e - s) / 2;
        int pivot = nums[m];
        while (s <= e) {
            while (nums[s] < pivot) {
                s++;
            }
            while (nums[e] > pivot) {
                e--;
            }
            if (s <= e) {
                int temp = nums[s];
                nums[s] = nums[e];
                nums[e] = temp;
                s++;
                e--;
            }
            quickSort(nums, lo, e);
            quickSort(nums, s + 1, hi);
        }
    }
}
