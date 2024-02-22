package com.example.dsalgo.sorting;

import java.util.Arrays;

/**
 * @author Hardeep Singh
 * @since 01-10-2023
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] nums = {4,8,12,3,2,6};
        int start = 0;
        int end = nums.length;
        mergeSortRecursiveInPlace(nums, start, end);
        System.out.println(Arrays.toString(nums));
    }

    public static void mergeSortRecursiveInPlace(int[] nums, int start, int end){
        if(end-start == 1){
            return;
        }
        int mid = (start + end) / 2;
        mergeSortRecursiveInPlace(nums, start, mid);
        mergeSortRecursiveInPlace(nums, mid, end);
        mergeInPlace(nums, start, mid, end);
    }

    private static void mergeInPlace(int[] nums, int start,int mid, int end) {
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

    public static int[] mergeSortRecursive(int[] nums){
        if(nums.length == 1){
            return nums;
        }
        int mid = nums.length/2;
        int[] left = mergeSortRecursive(Arrays.copyOfRange(nums, 0, mid));
        int[] right = mergeSortRecursive(Arrays.copyOfRange(nums, mid, nums.length));
        return merge(left, right);
    }

    private static int[] merge(int[] left, int[] right) {
        int i = 0;
        int j = 0;
        int k = 0;
        int[] nums = new int[left.length + right.length];
        while (i < left.length && j < right.length){
            if(left[i] > right[j]){
                nums[k] = right[j];
                j++;
            } else {
                nums[k] = left[i];
                i++;
            }
            k++;
        }
        while (i < left.length){
            nums[k] = left[i];
            i++;
            k++;
        }
        while (j < right.length){
            nums[k] = right[j];
            j++;
            k++;
        }
        return nums;
    }
}
