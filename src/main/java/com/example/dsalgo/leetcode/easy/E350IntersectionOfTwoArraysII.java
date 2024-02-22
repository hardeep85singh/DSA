package com.example.dsalgo.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Hardeep Singh
 */
//Given two integer arrays nums1 and nums2, return an array of their intersection.
// Each element in the result must appear as many times as it shows in both arrays and
// you may return the result in any order.
public class E350IntersectionOfTwoArraysII {
    public static void main(String[] args){
        int[] nums1 = {4,5,10};
        int[] nums2 = {9,4,9,8,4,5};
        System.out.print(Arrays.toString(intersectBySorting(nums1, nums2)));
    }

    public static int[] intersectHashMap(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length){
            return intersectHashMap(nums2, nums1);
        }
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i = 0; i< nums1.length; i++){
            hashMap.put(nums1[i], hashMap.getOrDefault(nums1[i], 0)+1);
        }
        int k = 0;
        for(int i = 0; i< nums2.length; i++){
            int cnt = hashMap.getOrDefault(nums2[i], 0);
            if(cnt > 0){
                nums1[k] = nums2[i];
                k++;
                hashMap.put(nums2[i], cnt-1);
            }
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }

    public static int[] intersectBySorting(int[] nums1, int[] nums2){
        if(nums1.length > nums2.length){
            intersectBySorting(nums2, nums1);
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < nums1.length && j < nums2.length){
            if(nums1[i] < nums2[j]){
                i++;
            } else if(nums1[i] > nums2[j]){
                j++;
            } else {
                nums1[k] = nums1[i];
                i++;
                j++;
                k++;
            }
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }
}
