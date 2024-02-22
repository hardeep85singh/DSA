package com.example.dsalgo.arrays;

import java.util.Arrays;

public class SpiralOrderMatrixII {
    public static void main(String[] args) {
//        int[][] matrix = {
//                {1,2,3,4},
//                {5,6,7,8},
//                {9,10,11,12},
//                {13,14,15,16}
//        };
        int[][] matrix = spiralOrderII(3);
        for (int i = 0; i < matrix[0].length; i++){
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    public static int[][] spiralOrderII(int num){
        int[][] ans = new int[num][num];
        int count = 1;
        int rowMin = 0;
        int rowMax = num -1;
        int colMin = 0;
        int colMax = num -1;

        while (count <= num * num){
            // go right
            for (int col = colMin; col <= colMax; col++) {
                ans[rowMin][col] = count;
                count++;
            }
            rowMin++;

            // go down
            for (int row = rowMin; row <= rowMax; row++) {
                ans[row][colMax] = count;
                count++;
            }
            colMax--;

            // go left
            for (int col = colMax; col >=  colMin; col--) {
                ans[rowMax][col] = count;
                count++;
            }
            rowMax--;

            // go up
            for (int row = rowMax; row >= rowMin ; row--) {
                ans[row][colMin] = count;
                count++;
            }
            colMin++;

        }
        return ans;
    }
}
