package com.example.dsalgo.leetcode.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Hardeep Singh
 */
public class M54201Matrix {
    public static void main(String[] args) {
        int[][] mat = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        int[][] newMat = updateMatrix(mat);
        for (int i = 0; i < newMat.length; i++) {
            System.out.print(Arrays.toString(newMat[i]));
        }

    }

    public static int[][] updateMatrix(int[][] mat) {
        int rows = mat.length;
        if (rows == 0) {
            return mat;
        }
        int cols = mat[0].length;
        int[][] dist = new int[rows][cols];
        for(int i = 0; i<rows; i++){
            for (int j = 0; j< cols; j++){
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 0) {
                    dist[i][j] = 0;
                } else {
                    for (int k = 0; k < rows; k++) {
                        for (int l = 0; l < cols; l++) {
                            if (mat[k][l] == 0) {
                                int val = Math.abs(k - i) + Math.abs(l - j);
                                dist[i][j] = Math.max(dist[i][j], val);
                            }
                        }
                    }
                }

            }

        }
        return dist;
    }

    public static int[][] updateMatrixDP(int[][] mat) {
        int rows = mat.length;
        if (rows == 0) {
            return mat;
        }
        int cols = mat[0].length;
        int[][] dist = new int[rows][cols];
        for(int i = 0; i<rows; i++){
            for (int j = 0; j< cols; j++){
                dist[i][j] = Integer.MAX_VALUE-100000;
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 0) {
                    dist[i][j] = 0;
                } else {
                    if (i > 0) {
                        dist[i][j] = Math.min(dist[i][j], dist[i - 1][j] + 1);
                    }
                    if (j > 0) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][j - 1] + 1);
                    }
                }
            }
        }
        for (int i = rows-1; i >= 0; i--) {
            for (int j = cols-1; j >= 0; j--) {

                if (i < rows - 1) {
                    dist[i][j] = Math.min(dist[i][j], dist[i + 1][j] + 1);
                }
                if (j < cols - 1) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][j + 1] + 1);
                }
            }
        }
        return dist;
    }

    public int[][] updateMatrixBFS(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] dir = new int[]{0, 1, 0, -1, 0};
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 0) q.offer(new int[]{i, j});
                else mat[i][j] = -1;
            }
        }
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];
            for(int i = 0; i < 4; i++){
                int nr = r + dir[i];
                int nc = c + dir[i + 1];
                if((nr >= 0 && nr < m) && (nc >= 0 && nc < n) && mat[nr][nc] == -1){
                    mat[nr][nc] = mat[r][c] + 1;
                    q.offer(new int[]{nr, nc});
                }
            }
        }
        return mat;
    }
}
