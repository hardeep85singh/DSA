package com.example.dsalgo.leetcode.medium;

public class M1975MaximumMatrixSum {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{-1,-2,0},{1,-2,3}};
        System.out.println(maxMatrixSum(matrix));
    }
    public static long maxMatrixSum(int[][] matrix) {
        int negCount = 0;
        long sum = 0;
        long min = Long.MAX_VALUE;
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] < 0){
                    negCount ++;
                }
                sum = sum + Math.abs(matrix[i][j]);
                min = Math.min(min, Math.abs(matrix[i][j]));
            }
        }
        if(negCount % 2 == 0){
            return sum;
        } else {
            return sum - 2 * min;
        }
    }
}
