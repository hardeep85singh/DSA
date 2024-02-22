package com.example.dsalgo.leetcode.medium;

/**
 * @author Hardeep Singh
 */
public class M74SearchA2DMatrix {

    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        System.out.print(searchMatrix(matrix, 3));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int r = matrix.length;
        if(r == 0){
            return false;
        }
        int c = matrix[0].length;
        int left = 0;
        int right = r * c - 1;
        while (left <= right) {
            int mid = (right + left) / 2;
            int pivotElement = matrix[mid / c][mid % c];
            if (target == pivotElement){
                return true;
            } else {
                if(target < pivotElement){
                    right = mid-1;
                } else {
                    left = mid+1;
                }
            }
        }
        return false;
    }

    public static int binarySearchIndex(int[] nums, int left, int right, int target) {

        while (left < right) {
            int mid = (right + left) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            if (target < nums[mid]) {
                binarySearchIndex(nums, left, mid - 1, target);
            } else {
                binarySearchIndex(nums, mid + 1, right, target);
            }
        }
        return -1;
    }
}
