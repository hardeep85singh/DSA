package com.example.dsalgo.graphs;

import java.util.Arrays;

/**
 * @author Hardeep Singh
 */
public class IsNegativeWeightCycle {
    public static void main(String[] args) {
        // source, destination, weight
        int[][] edges = {{0,1,-1}};
    }

    public static int isNegativeWeightCycle(int n, int[][] edges){
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        // if source given, then make dest[source] = 0
        dist[0] = 0;
        for(int count = 1; count < n; count++){
            for(int j = 0; j < edges.length; j++){
                int src = edges[j][0];
                int dest = edges[j][1];
                int weight = edges[j][2];
                if(dist[src] != Integer.MAX_VALUE && (dist[src] + weight) < dist[dest]){
                    dist[dest] = dist[src] + weight;
                }
            }
        }
        for(int j =0 ; j < edges.length; j++){
            int src = edges[j][0];
            int dest = edges[j][1];
            int weight = edges[j][2];
            if(dist[src] != Integer.MAX_VALUE && (dist[src] + weight) < dist[dest]){
               return 1;
            }
        }
        return 0;
    }
}
