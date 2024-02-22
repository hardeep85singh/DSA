package com.example.dsalgo.leetcode.medium;

import java.util.Arrays;

/**
 * @author Hardeep Singh
 */
public class M59SpiralMatrixII {
    public static void main(String[] args) {
//        int[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] newMat = generateMatrix(3);
        for (int i = 0; i < newMat.length; i++) {
            System.out.print(Arrays.toString(newMat[i]));
        }
    }

    public static int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
//        int layer = (n+1)/2;
        int count = 1;
        for(int layer = 0; layer < (n+1)/2; layer++){
            // direction 1 - traverse from left to right
            // row constant - layer, col increase from layer to n-layer-1
            for(int ptr = layer; ptr < n-layer; ptr++){
                result[layer][ptr] = count++;
            }
            // direction 2 - traverse from top right to bottom right
            // row increase from layer+1 to n-layer, col constant - n-layer-1
            for(int ptr = layer+1; ptr < n-layer; ptr++){
                result[ptr][n-layer-1] = count++;
            }
            // direction 3 - traverse from bottom right to bottom left
            // row constant - n-layer-1, col decreases n-layer-2 to layer
            for(int ptr = n-layer-2; ptr>layer; ptr--){
                result[n-layer-1][ptr] = count++;
            }
            // direction 4 - traverse from bottom left to top right
            // row decreases n-layer-1 to layer, col constant - layer
            for(int ptr = n-layer-1; ptr> layer; ptr--){
                result[ptr][layer] = count++;
            }
        }
        return result;
    }
}
