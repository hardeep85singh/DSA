package com.example.dsalgo.leetcode.hard;

/**
 * @author Hardeep Singh
 */
public class H4MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {};
        int[] nums2 = {2, 3, 4,9};
        System.out.println(findMedianSortedArrays(nums1, nums2));
        System.out.println(findMedianSortedArraysLinear(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int nums1Length = nums1.length;
        int nums2Length = nums2.length;
        int[] nums = new int[nums1Length + nums2Length];
        double result;
        nums = mergeSortedArrays(nums1, nums2, nums);

        if (nums.length % 2 == 1) {
            result = nums[nums.length / 2];
        } else {
            int mid = nums.length / 2;
            double m1 = nums[mid];
            double m2 = nums[mid - 1];
            result = (m1 + m2) / 2;

//            result = (double)((nums[mid] + nums[mid-1])) / 2;
        }
        return result;
    }

    public static int[] mergeSortedArrays(int[] nums1, int[] nums2, int[] nums) {
        int nums1Length = nums1.length;
        int nums2Length = nums2.length;

        int i = 0;
        int j = 0;
        int k = 0;
        while (i < nums1Length && j < nums2Length) {
            if (nums1[i] <= nums2[j]) {
                nums[k] = nums1[i];
                i++;
            } else {
                nums[k] = nums2[j];
                j++;
            }
            k++;
        }
        while (i < nums1Length) {
            nums[k] = nums1[i];
            i++;
            k++;
        }
        while (j < nums2Length) {
            nums[k] = nums2[j];
            j++;
            k++;
        }
        return nums;
    }

    public static double findMedianSortedArraysLinear(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        double m1 = 0, m2 = 0;
        double result;
        int i = 0, j = 0;
        int k = 0;

        if ((m + n) % 2 == 1) {
            while (i < m && j < n && k <= (m+n)/2) {
                if (nums1[i] < nums2[j]) {
                    m1 = nums1[i];
                    i++;
                } else {
                    m1 = nums2[j];
                    j++;
                }
                k++;
            }
            while (i < m  && k <= (m+n)/2) {
                m1 = nums1[i];
                i++;
                k++;
            }
            while (j < n  && k <= (m+n)/2) {
                m1 = nums2[j];
                j++;
                k++;
            }
            result = m1;
        } else {
            while (i < m && j < n && k <= (m+n)/2) {
                m2 = m1;
                if (nums1[i] < nums2[j]) {
                    m1 = nums1[i];
                    i++;
                } else {
                    m1 = nums2[j];
                    j++;
                }
                k++;
            }
            while (i < m && k <= ((m + n) / 2)) {
                m2 = m1;
                m1 = nums1[i];
                i++;
                k++;
            }
            while (j < n && k <= ((m + n) / 2)) {
                m2 = m1;
                m1 = nums2[j];
                j++;
                k++;
            }
            result = (m1 + m2)/2;
        }
        return result;
    }
}

//        if((n+m) % 2 == 1){
//           for(count = 0; count <= (m+n)/2; count++){
//               if(i != m && j != n){
//                   if(nums1[i] > nums2[j]){
//                       m1 = nums2[j];
//                       j++;
//                   } else {
//                       m1 = nums1[i];
//                       i++;
//                   }
//               } else if(i < m){
//                   m1 = nums1[i];
//                   i++;
//               } else {
//                   m1 = nums2[j];
//                   j++;
//               }
//           }
//        } else {
//            for(count = 0; count <= (m+n)/2; count++){
//                m2 = m1;
//
//                if(i != m && j != n){
//                    if(nums1[i] > nums2[j]){
//                        m1 = nums2[j];
//                        j++;
//                    } else {
//                        m1 = nums1[i];
//                        i++;
//                    }
//                } else if(i < m){
//                    m1 = nums1[i];
//                    i++;
//                } else {
//                    m1 = nums2[j];
//                    j++;
//                }
//            }
//        }
