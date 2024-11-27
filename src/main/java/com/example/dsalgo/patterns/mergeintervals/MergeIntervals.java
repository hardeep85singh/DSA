package com.example.dsalgo.patterns.mergeintervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1,5},{3,7},{4,6}};
        int[][] res = mergeIntervals(intervals);
        for (int i = 0; i < intervals.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
    }

    public static int[][] mergeIntervals(int[][] intervals){
        List<int[]> merged = new ArrayList<>();
        merged.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++){
            int[] current = intervals[i];
            int[] lastMerged = merged.get(merged.size() - 1);
            if(current[0] <= lastMerged[1]){
                lastMerged[1] = Math.max(lastMerged[1], current[1]);
            } else {
                merged.add(current);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
}
