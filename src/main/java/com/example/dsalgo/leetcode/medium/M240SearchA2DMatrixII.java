package com.example.dsalgo.leetcode.medium;

import java.util.Arrays;

/**
 * @author Hardeep Singh
 */
public class M240SearchA2DMatrixII {
    public static void main(String[] args) {
        int[][] mat = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        System.out.println(searchMatrixDiagonally(mat, 5));
    }
    public static boolean searchMatrixPruning(int[][] matrix, int target){
        int row = matrix.length-1;
        int col = 0;
        while (row >= 0 && col < matrix[0].length){
            if(matrix[row][col] > target){
                row--;
            } else if (matrix[row][col] < target){
                col++;
            } else {
                return true;
            }
        }
        return false;
    }
    public static boolean searchMatrixDiagonally(int[][] matrix, int target){
        if(matrix == null || matrix.length == 0){
            return false;
        }
        int shorterPath = Math.min(matrix.length, matrix[0].length);

        for(int i = 0; i< shorterPath; i++){
            boolean verticalFound = binarySearch(matrix, target, i, true);
            boolean horizontalFound = binarySearch(matrix, target, i, false);
            if (verticalFound || horizontalFound) {
                return true;
            }
        }
        return false;
    }

    private static boolean binarySearch(int[][] matrix, int target, int start, boolean isVertical) {
        int hi = isVertical ? matrix[0].length-1 : matrix.length-1;
        int low = start;

        while (low <= hi){
            int mid = (low + hi)/2;
            if(isVertical){
                if(matrix[start][mid] == target){
                    return true;
                } else if ( target < matrix[start][mid]){
                    hi = mid-1;
                } else {
                    low = mid +1;
                }
            } else {
                if(matrix[mid][start] == target){
                    return true;
                } else if ( target < matrix[mid][start]){
                    hi = mid-1;
                } else {
                    low = mid +1;
                }
            }
        }
        return false;
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int leftCol = 0;
        int rightCol = matrix[0].length-1;
//        int col = searchMatrixRow(matrix, leftCol, rightCol, target);

//        if(target == matrix[topRow][col]){
//            return true;
//        }
        for(int col = 0; col < matrix[0].length; col++) {
            int topRow = 0;
            int bottomRow = matrix.length-1;
            while (topRow <= bottomRow) {
                int mid = (topRow + bottomRow) / 2;
                if (target == matrix[mid][col]) {
                    return true;
                }
                if (target < matrix[mid][col]) {
                    bottomRow = mid - 1;
                } else {
                    topRow = mid + 1;
                }
            }
        }
        return false;
    }

    private static int searchMatrixRow(int[][] matrix, int leftCol, int rightCol, int target) {
        while (leftCol < rightCol){
            int mid = (rightCol + leftCol) /2;
            if(target == matrix[0][mid]){
                return mid;
            }
            if(target < matrix[0][mid] && target >= matrix[0][mid-1]){
                return mid-1;
            } else if(target < matrix[0][mid]) {
                rightCol = mid -1;
            } else if(target > matrix[0][mid] && target <= matrix[0][mid+1]){
                return mid+1;
            } else {
                leftCol = mid+1;
            }
        }
        return -1;
    }
}
