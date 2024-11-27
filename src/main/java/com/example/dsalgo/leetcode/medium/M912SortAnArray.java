package com.example.dsalgo.leetcode.medium;

import java.util.Arrays;

public class M912SortAnArray {
    public static void main(String[] args) {
        int[] nums = {5,1,1,2,0,0};

        System.out.println(Arrays.toString(sortArray(nums)));
    }

    public static int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length);
        return nums;
    }

    private static void mergeSort(int[] nums, int start, int end) {
        if(end - start == 1){
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(nums, start, mid);
        mergeSort(nums, mid, end);
        merge(nums, start, mid, end);
    }

    private static void merge(int[] nums, int start, int mid, int end){
        int[] mix = new int[end-start];
        int i = start;
        int j = mid;
        int k = 0;
        while (i < mid && j < end){
            if(nums[i] > nums[j]){
                mix[k] = nums[j];
                j++;
            } else {
                mix[k] = nums[i];
                i++;
            }
            k++;
        }
        while (i < mid){
            mix[k] = nums[i];
            i++;
            k++;
        }
        while (j < end){
            mix[k] = nums[j];
            j++;
            k++;
        }
        for (int l = 0; l < mix.length; l++){
            nums[start+l] = mix[l];
        }
    }
}
