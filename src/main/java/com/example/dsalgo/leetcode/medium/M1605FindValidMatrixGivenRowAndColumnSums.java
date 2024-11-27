package com.example.dsalgo.leetcode.medium;

import java.util.Arrays;

public class M1605FindValidMatrixGivenRowAndColumnSums {

    public static void main(String[] args) {

        int[] rowSum = {5,7,10};
        int[] colSum = {8,6,8};
        int[][] result = restoreMatrix(rowSum, colSum);
        for (int i = 0; i < result.length; i++) {
            System.out.println(Arrays.toString(result[i]));
        }
    }

    public static int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int[][] ans = new int[rowSum.length][colSum.length];

        for (int i = 0; i < rowSum.length; i++){
            for (int j = 0; j < colSum.length; j++){
                ans[i][j] = Math.min(rowSum[i], colSum[j]);
                rowSum[i] = rowSum[i] - ans[i][j];
                colSum[j] = colSum[j] - ans[i][j];
            }
        }

        return ans;
    }
}
