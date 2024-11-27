package com.example.dsalgo.leetcode.medium;

import java.util.Arrays;

public class M2976MinimumCostToConvertStringI {

    public static void main(String[] args) {
        String source = "abcd";
        String target = "acbe";
        char[] original = {'a','b','c','c','e','d'};
        char[] changed = {'b','c','b','e','b','e'};
        int[] cost = {2,5,5,1,2,20};

        System.out.println(minimumCost(source, target, original, changed, cost));
    }

    public static long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int ans = 0;
        // dist[u][v] := the minimum distance to change ('a' + u) to ('a' + v)
        long[][] dist = new long[26][26];
        Arrays.stream(dist).forEach(A -> Arrays.fill(A, Long.MAX_VALUE));

        for (int i = 0; i < cost.length; ++i) {
            int u = original[i] - 'a';
            int v = changed[i] - 'a';
            dist[u][v] = Math.min(dist[u][v], cost[i]);
        }

        for (int k = 0; k < 26; ++k) {
            for (int i = 0; i < 26; ++i) {
                if (dist[i][k] < Long.MAX_VALUE) {
                    for (int j = 0; j < 26; ++j) {
                        if (dist[k][j] < Long.MAX_VALUE) {
                            dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                        }
                    }
                }
            }
        }

        for (int i = 0; i < source.length(); ++i) {
            if (source.charAt(i) == target.charAt(i))
                continue;
            int u = source.charAt(i) - 'a';
            int v = target.charAt(i) - 'a';
            if (dist[u][v] == Long.MAX_VALUE) {
                return -1;
            }
            ans += dist[u][v];
        }
        return ans;
    }

}
