package com.example.dsalgo.binarysearch;

public class Main {
    public static void main(String[] args) {
        int[] arr = {9, 10, 3, 5, 6, 8};
        int[][] matrix = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}};

//        System.out.println(FindMinRotatedSortedArray.findMin(arr));
//        System.out.println(FindMinRotatedSortedArray.findMinIndex(arr));
//        System.out.println(FindPivotRotatedSortedArray.findPivotIndex(arr, 8));
        System.out.println(SortedMatrixSearch.findRow(matrix,4,3, 3));
    }
}
