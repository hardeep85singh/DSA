package com.example.dsalgo.geeksofgeeks;

public class MaximumSumOfHourGlass2504 {
    public static void main(String[] args) {

    }

    public static int findMaxSum(int n, int m, int[][] mat) {
        int sum = 0;

        return sum;
    }

    public static int sumHourGlass(int[][] mat){
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sum = sum + mat[i][j];
            }
        }
        sum = sum - mat[1][0] - mat[1][2];
        return sum;
    }
}
