package com.example.dsalgo.leetcode.medium;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Hardeep Singh
 */
public class M986IntervalListIntersections {
    public static void main(String[] args){
        int[][] firstList = {{0,2},{5,10},{13,23},{24,25}};
        int[][] secondList = {{1,5},{8,12},{15,24},{25,26}};
        for(int[] arr : intervalIntersection(firstList, secondList)){
            System.out.print(Arrays.toString(arr));
        }
    }
//    [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]

    public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int i = 0;
        int j = 0;
        LinkedList<int[]> linkedList = new LinkedList<>();
        while (i < firstList.length && j < secondList.length){
            // Let's check if A[i] intersects B[j].
            // lo - the startpoint of the intersection
            // hi - the endpoint of the intersection
            int lo = Math.max(firstList[i][0], secondList[j][0]);
            int hi = Math.min(firstList[i][1], secondList[j][1]);
            if(lo <= hi){
                linkedList.add(new int[]{lo, hi});
            }
            // Remove the interval with the smallest endpoint
            if(firstList[i][1] < secondList[j][1]){
                i++;
            } else {
                j++;
            }
        }
        return linkedList.toArray(new int[linkedList.size()][]);
    }
}
