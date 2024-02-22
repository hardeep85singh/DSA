package com.example.dsalgo.arrays;

import java.util.Arrays;

public class RotateMatrix90Degree {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };
        rotateMatrix(matrix);
        for (int i = 0; i < matrix[0].length; i++){
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    public static int[][] rotateMatrix(int[][] matrix){
        matrix = TransposeMatrix.transposeMatrix(matrix);
        int left = 0;
        int right = matrix[0].length -1;
        while (left < right){
            for (int i = 0; i < matrix.length; i++) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
            }
            left++;
            right--;
        }
        return matrix;
    }
}
