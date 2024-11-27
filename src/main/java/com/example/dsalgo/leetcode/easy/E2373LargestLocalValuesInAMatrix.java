package com.example.dsalgo.leetcode.easy;

import java.util.Arrays;

public class E2373LargestLocalValuesInAMatrix {

    public static void main(String[] args) {
        int[][]grid = {{9,9,8,1},{5,6,2,6},{8,2,6,4},{6,2,2,2}};
        int[][] ans = largestLocal(grid);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(Arrays.toString(ans[i]));
        }
    }
    public static int[][] largestLocal(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int[][] ans = new int[r-2][c-2];

        int r1 = 0;
        int c1 = 0;
        while (r1 + 3 <= r){
            while (c1 + 3 <= c){
                int max = 0;
                for(int i = r1; i < r1 + 3; i++){
                    for (int j = c1; j < c1 + 3; j++){
                        max = Math.max(max, grid[i][j]);
                    }
                }
                ans[r1][c1] = max;
                c1++;
            }
            c1 = 0;
            r1++;
        }

        return ans;
    }
}
