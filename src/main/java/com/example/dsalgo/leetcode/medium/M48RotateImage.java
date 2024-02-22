package com.example.dsalgo.leetcode.medium;

import java.util.Arrays;

/**
 * @author Hardeep Singh
 */
public class M48RotateImage {
    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] newMat = rotate4Steps(mat);
        for (int i = 0; i < newMat.length; i++) {
            System.out.print(Arrays.toString(newMat[i]));
        }
    }

    public static int[][] rotate4Steps(int[][] matrix){
        int n = matrix.length;
        for(int rows = 0; rows < (n+1) / 2; rows++){
            for(int cols= 0; cols < n /2; cols++){
                // anticlockwise
//                int temp = matrix[rows][cols];
//                matrix[rows][cols] = matrix[cols][n-1-rows];
//                matrix[cols][n-1-rows] = matrix[n-1-rows][n-cols-1];
//                matrix[n-1-rows][n-cols-1] = matrix[n-1-cols][rows];
//                matrix[n-1-cols][rows] = temp;
                // clockwise
                int temp = matrix[n-1-cols][rows];
                matrix[n-1-cols][rows] = matrix[n-1-rows][n-cols-1];
                matrix[n-1-rows][n-cols-1] = matrix[cols][n-1-rows];
                matrix[cols][n-1-rows] = matrix[rows][cols];
                matrix[rows][cols] = temp;
            }
        }
        return matrix;
    }

    public static int[][] rotate(int[][] matrix) {

        // transpose
        for (int rows = 0; rows < matrix.length; rows++) {
            for (int cols = rows + 1; cols < matrix[0].length; cols++) {
                int temp = matrix[rows][cols];
                matrix[rows][cols] = matrix[cols][rows];
                matrix[cols][rows] = temp;
            }
        }

        // reverse
        for (int rows = 0; rows < matrix.length; rows++){
            for(int cols = 0; cols < matrix[0].length/2; cols++){
                int temp = matrix[rows][cols];
                matrix[rows][cols] = matrix[rows][matrix.length-1-cols];
                matrix[rows][matrix.length-1-cols] = temp;
            }
        }
        return matrix;
    }
}
