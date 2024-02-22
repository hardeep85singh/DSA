package com.example.dsalgo.binarysearch;

public class FindMinRotatedSortedArray {
    public static int findMin(int[] arr){
        return arr[findMinIndex(arr)];
    }

    public static int findMinIndex(int[] arr){
        int left = 0;
        int right = arr.length -1;
        while (left < right){
            int mid = (left + right) / 2;
            if(arr[mid] < arr[right]){
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
