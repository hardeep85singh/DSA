package com.example.dsalgo.leetcode.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Hardeep Singh
 */
public class M56MergeIntervals {
    public static void main(String[] args){
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        System.out.println(mergeIntervals(intervals));
    }
    public static int[][] mergeIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        LinkedList<int[]> list = new LinkedList<>();
        for(int[] interval : intervals){
            // if the list of merged intervals is empty or if the current
            // interval does not overlap with the previous, simply append it.
            if(list.isEmpty() || list.getLast()[1] < interval[0]){
                list.add(interval);
            }
            // otherwise, there is overlap, so we merge the current and previous
            // intervals.
            else {
                list.getLast()[1] = Math.max(list.getLast()[1], interval[1]);
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}
