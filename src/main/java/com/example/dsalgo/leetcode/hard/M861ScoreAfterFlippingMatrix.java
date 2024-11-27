package com.example.dsalgo.leetcode.hard;

public class M861ScoreAfterFlippingMatrix {
    public static void main(String[] args) {
        int[][] grid = {{0,0,1,1},{1,0,1,0},{1,1,0,0}};
        System.out.println(matrixScore(grid));
    }

    public static int matrixScore(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int ans = 0;

        // Flip the rows with a leading 0.
        for (int[] row : grid) {
            if (row[0] == 0) {
                flip(row);
            }
        }

        // Flip the columns with 1s < 0s.
        for (int j = 0; j < n; ++j) {
            if (onesColCount(grid, j) * 2 < m) {
                flipCol(grid, j);
            }
        }

        // Add a binary number for each row.
        for (int[] row : grid) {
            ans += binary(row);
        }

        return ans;
    }

    private static void flip(int[] row) {
        for (int i = 0; i < row.length; i++) {
            row[i] ^= 1;
        }
    }

    private static int onesColCount(int[][] grid, int j) {
        int ones = 0;
        for (int i = 0; i < grid.length; i++) {
            ones += grid[i][j];
        }
        return ones;
    }

    private static void flipCol(int[][] grid, int j) {
        for (int i = 0; i < grid.length; i++) {
            grid[i][j] ^= 1;
        }
    }

    private static int binary(int[] row) {
        int res = row[0];
        for (int j = 1; j < row.length; j++) {
            res = res * 2 + row[j];
        }
        return res;
    }

}
