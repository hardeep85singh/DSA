package com.example.dsalgo.patterns.mergeintervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertIntervals {
    public static void main(String[] args) {
        int[][] existingIntervals = {{1,2},{5,8},{9,15}};
        int[] newInterval = {3,7};
        int[][] result = insertInterval(existingIntervals, newInterval);
        for (int i = 0; i < result.length; i++) {
            System.out.println(Arrays.toString(result[i]));
        }
    }

    public static int[][] insertInterval(int[][] existingIntervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();

        int i = 0;

        // Step 1: Add all intervals that come before the new interval
        while (i < existingIntervals.length && existingIntervals[i][1] < newInterval[0]) {
            result.add(existingIntervals[i]);
            i++;
        }
        // Step 2: Merge the new interval with any overlapping intervals
        while (i < existingIntervals.length && existingIntervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], existingIntervals[i][0]); // update start
            newInterval[1] = Math.max(newInterval[1], existingIntervals[i][1]); // update end
            i++;
        }
        // Add the merged new interval
        result.add(newInterval);

        // Step 3: Add all intervals that come after the new interval
        while (i < existingIntervals.length) {
            result.add(existingIntervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }
}
