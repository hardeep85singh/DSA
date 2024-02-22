package com.example.dsalgo.leetcode.easy;

import java.util.Arrays;

/**
 * @author Hardeep Singh
 */
public class E88MergeSortedArray {
    public static void main(String[] args){
        int[] nums1 = {4,7,0,0,0,0,0};
        int[] nums2 = {1,2,3,5,6};

        mergeThreePointers(nums1, 2, nums2, 5);

    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        for(int i = 0; i < m; i++){
            nums1[m+n-1 - i] = nums1[m-1-i];
        }

        int i = n;
        int j = 0;
        int k = 0;
        while (i < m+n && j < n){
            if(nums1[i] <= nums2[j]){
                nums1[k] = nums1[i];
                i++;
                k++;
            } else {
                nums1[k] = nums2[j];
                j++;
                k++;
            }
        }
        while(j < n){
            nums1[k] = nums2[j];
            j++;
            k++;
        }

    }

//Interview Tip: Whenever you're trying to solve an array problem in-place,
// always consider the possibility of iterating backwards instead of forwards through the array.
// It can completely change the problem, and make it a lot easier
    public static void mergeThreePointers(int[] nums1, int m, int[] nums2, int n){
        int i = m-1;
        int j = n-1;
        int k = m + n -1;
        while (j >= 0 && i >= 0){
            if(nums1[i] >= nums2[j]){
                nums1[k] = nums1[i];
                i--;
                k--;
            } else {
                nums1[k] = nums2[j];
                j--;
                k--;
            }
        }
        while (j >= 0){
            nums1[k] = nums2[j];
            j--;
            k--;
        }
        System.out.print(Arrays.toString(nums1));
    }
}
