package com.example.dsalgo.arrays;

import java.util.ArrayList;

/* Given an array of integers, A of length N, find out the maximum sum sub-array of non negative numbers from A.

        The sub-array should be contiguous i.e., a sub-array created by choosing the second and fourth element and skipping the third element is invalid.

        Maximum sub-array is defined in terms of the sum of the elements in the sub-array.

        Find and return the required subarray.

        NOTE:

        If there is a tie, then compare with segment's length and return segment which has maximum length.
        If there is still a tie, then return the segment with minimum starting index.*/
public class MaxNonNegativeSubArray {

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(5);
        A.add(-7);
        A.add(2);
        A.add(3);
        A.add(3);
        A.add(3);
        System.out.println(maxset(A));
    }
    public static ArrayList<Integer> maxset(ArrayList<Integer> A) {
        long maxSum = 0;
        long currentSum = 0;
        ArrayList<Integer> maxSet = new ArrayList<>();
        ArrayList<Integer> currentSet = new ArrayList<>();

        for (int value : A) {
            if (value >= 0) {
                currentSum += value;
                currentSet.add(value);
            } else {
                currentSum = 0;
                currentSet = new ArrayList<>();
            }

            if (currentSum > maxSum || (currentSum == maxSum && currentSet.size() > maxSet.size())) {
                maxSum = currentSum;
                maxSet = new ArrayList<>(currentSet);
            }
        }
        return maxSet;
    }
}
