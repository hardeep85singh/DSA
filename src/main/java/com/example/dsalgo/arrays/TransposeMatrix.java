package com.example.dsalgo.arrays;

import java.util.Arrays;

public class TransposeMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };
        transposeMatrix(matrix);
        for (int i = 0; i < matrix[0].length; i++){
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    public static int[][] transposeMatrix(int[][] matrix){
        for(int i = 0; i< matrix.length; i++ ){
            for (int j = i+1; j < matrix[i].length; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        return matrix;
    }
}
