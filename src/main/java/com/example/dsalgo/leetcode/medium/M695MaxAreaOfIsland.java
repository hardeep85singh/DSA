package com.example.dsalgo.leetcode.medium;

/**
 * @author Hardeep Singh
 */
public class M695MaxAreaOfIsland {
    public static void main(String[] args) {
        int[][] grid = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};

        System.out.println(maxAreaOfIsland(grid));
    }

    public static int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;

        for(int i = 0; i< grid.length; i++){
            int area = 0;
            for(int j = 0; j< grid[0].length; j++){
                area = area + dfs(grid, i, j);
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }

    private static int dfs(int[][] grid, int i, int j) {
        int area = 0;
        if(grid[i][j] == 1){
            if(i == 0 && j >= 1 && i+1 < grid.length && j+1 < grid[0].length){
                if(grid[i+1][j] == 1 || grid[i][j-1] == 1 || grid[i][j+1] == 1){
                    area = area + 1;
                }
            } else if (i >=1 && j == 0 && i+1 < grid.length && j+1 < grid[0].length){
                if(grid[i-1][j] == 1 || grid[i+1][j] == 1 || grid[i][j+1] == 1){
                    area = area + 1;
                }
            } else if (i >=1 && j >= 1 && i == grid.length-1 && j+1 < grid[0].length){
                if(grid[i-1][j] == 1 || grid[i][j-1] == 1 || grid[i][j+1] == 1){
                    area = area + 1;
                }
            } else if (i >= 1 && j >= 1 && i+1 < grid.length && j == grid[0].length){
                if(grid[i-1][j] == 1 || grid[i+1][j] == 1 || grid[i][j-1] == 1 ){
                    area = area + 1;
                }
            } else{
                if(grid[i-1][j] == 1 || grid[i+1][j] == 1 || grid[i][j-1] == 1 || grid[i][j+1] == 1){
                    area = area + 1;
                }
            }

        }
        return area;
    }
}
