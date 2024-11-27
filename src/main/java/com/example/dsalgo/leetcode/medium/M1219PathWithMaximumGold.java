package com.example.dsalgo.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class M1219PathWithMaximumGold {
    public static void main(String[] args) {
        int[][] grid = {{0,6,0},{5,8,7},{0,9,0}};
        System.out.println(getMaximumGold(grid));
    }
    public static int getMaximumGold(int[][] grid) {
        int res = 0;
//        Map<Pair, Integer> hashset = new HashMap<>();
        int r = grid.length;
        int c = grid[0].length;
        for (int i = 0; i < r; i++){
            for (int j = 0; j < c; j++){
                res = Math.max(res, dfs(grid, i, j));
            }
        }

        return res;
    }

    private static int dfs( int[][] grid, int r, int c){
        if(r == grid.length || c == grid[0].length || r < 0 || c < 0 || grid[r][c] == 0){
            return 0;
        }
//        if(visited.containsKey(new Pair(r, c))){
//            return 0;
//        }
//        visited.put(new Pair(r, c), grid[r][c]);
//        int res = grid[r][c];
//        int[] rowNeighbors = {1, 0, -1, 0};
//        int[] colNeighbors = {0, 1, 0, -1};
//        for (int i = 0; i < rowNeighbors.length; i++){
//            for (int j = 0; j < colNeighbors.length; j++){
//                res = Math.max(res, grid[r][c] + dfs(r + i, c + j, visited, grid));
//            }
//        }
//        visited.remove(new Pair(r, c));
        int gold = grid[r][c];
        grid[r][c] = 0; // Mark as visited.
        int maxPath = Math.max(Math.max(dfs(grid, r + 1, c), dfs(grid, r - 1, c)),
                Math.max(dfs(grid, r, c + 1), dfs(grid, r, c - 1)));
        grid[r][c] = gold;
        return gold + maxPath;
//        return res;
    }

    static class Pair{
        int row;
        int col;

        public Pair (int row, int col){
            this.row = row;
            this.col = col;
        }
    }
}
