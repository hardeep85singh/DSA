package com.example.dsalgo.binarysearch;

public class FindPivotRotatedSortedArray {

    //{4,5,6,7,0,1,2,3}
    public static int findPivotIndex(int[] arr, int target){
        int left = 0;
        int right = arr.length -1;
        int pivotIndex = FindMinRotatedSortedArray.findMinIndex(arr);
        int ans = -1;
        if(target > arr[right]){
            right = pivotIndex -1;
        } else if (target < arr[right]){
            left = pivotIndex;
        } else {
            ans = right;
            return ans;
        }
        while (left <= right){
            int mid = (left + right)/2;
            if(target < arr[mid]){
                right = mid-1;
            } else if (target > arr[mid]){
                left = mid+1;
            } else {
                ans = mid;
                break;
            }
        }
        return ans;
    }
}
