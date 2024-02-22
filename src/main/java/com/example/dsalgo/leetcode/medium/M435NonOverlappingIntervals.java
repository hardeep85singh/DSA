package com.example.dsalgo.leetcode.medium;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author Hardeep Singh
 */
public class M435NonOverlappingIntervals {
    public static void main(String[] args){
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        System.out.println(eraseOverlapIntervals(intervals));
    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));
        int count = 0;
        LinkedList<int[]> list = new LinkedList<>();
        for(int[] interval : intervals){
            if(list.isEmpty() || list.getLast()[1] <= interval[0]){
                list.add(interval);
            } else{
                count++;
                list.getLast()[1] = Math.min(list.getLast()[1], interval[1]);
            }
        }
        return count;
    }
}
