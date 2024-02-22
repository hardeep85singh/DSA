package com.example.dsalgo.binarysearch;

import java.util.List;

public class CountElementOccurence {

    public int findCount(final List<Integer> A, int B) {
        int smallestIndex = findSmallest(A, B);
        int greatestIndex = findGreatest(A, B);
        if(B < A.get(0)){
            return 0;
        } else if (B > A.get(A.size()-1)){
            return 0;
        }
        return greatestIndex - smallestIndex;
    }
    private static int findSmallest(List<Integer> nums, int target) {
        int start = 0;
        int end = nums.size() -1;
        while (start <= end){
            int mid = start + (end - start) / 2;
            if(target > nums.get(mid)){
                start = mid + 1;
            } else if (target <= nums.get(mid)){
                end = mid -1;
            }
        }
        return end;
    }

    private static int findGreatest(List<Integer> nums, int target) {
        int start = 0;
        int end = nums.size() -1;
        while (start <= end){
            int mid = start + (end - start) / 2;
            if(target >= nums.get(mid)){
                start = mid + 1;
            } else {
                end = mid -1;
            }
        }
        return start;
    }
}
