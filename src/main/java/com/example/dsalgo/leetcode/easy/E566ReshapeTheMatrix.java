package com.example.dsalgo.leetcode.easy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Hardeep Singh
 */
public class E566ReshapeTheMatrix {
    public static void main(String[] args) {
        int[][] mat = {{1, 2}, {3, 4}, {5,6}};
        System.out.print(Arrays.toString(matrixReshapeQueue(mat, 1, 6)));
    }

    public static int[][] matrixReshapeQueue(int[][] mat, int r, int c) {
        if (mat.length == 0 || mat.length * mat[0].length != r * c) {
            return mat;
        }
        Queue<Integer> queue = new LinkedList<>();
        int[][] res = new int[r][c];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                queue.add(mat[i][j]);
            }
        }
        for(int i = 0; i< res.length; i++){
            for (int j = 0; j< res[0].length; j++){
                res[i][j] = queue.poll();
            }
        }
        return res;
    }

    public static int[][] matrixReshapeWithoutExtraSpace(int[][] mat, int r, int c){
        if(mat.length == 0 || mat.length * mat[0].length != r * c){
            return mat;
        }
        int[][] res = new int[r][c];
        int rows= 0;
        int cols = 0;
        for(int i = 0; i< mat.length; i++){
            for(int j = 0; j< mat[0].length ; j++){
                res[rows][cols] = mat[i][j];
                cols++;
                if(cols == c){
                    rows++;
                    cols = 0;
                }
            }
        }
        return res;
    }
}
