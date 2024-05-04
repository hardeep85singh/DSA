package com.example.dsalgo.leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class H834SumOfDistancesInTree {
    List<List<Integer>> graph;
    int[] subtreeCount;
    int[] distSum;
    int n;

    public static void main(String[] args) {
        H834SumOfDistancesInTree solution = new H834SumOfDistancesInTree();
        int n = 6;
        int[][] edges = {{0,1},{0,2},{2,3},{2,4},{2,5}};
        int[] result = solution.sumOfDistancesInTree(n, edges);
        System.out.println(Arrays.toString(result)); // Output: [8,12,6,10,10,10]
    }
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        this.n = n;
        graph = new ArrayList<>();
        subtreeCount = new int[n];
        distSum = new int[n];

        // Initialize adjacency list
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Build adjacency list representation of the tree
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // Perform the first DFS to compute subtree sizes and sum of distances
        computeSubtreeSizesAndDistances(0, -1);

        // Perform the second DFS to compute the sum of distances for each node
        computeSumOfDistances(0, -1);

        return distSum;
    }
    // DFS to compute subtree sizes and sum of distances
    private void computeSubtreeSizesAndDistances(int node, int parent) {
        subtreeCount[node] = 1;

        for (int neighbor : graph.get(node)) {
            if (neighbor == parent) continue;
            computeSubtreeSizesAndDistances(neighbor, node);
            subtreeCount[node] += subtreeCount[neighbor];
            distSum[node] += distSum[neighbor] + subtreeCount[neighbor];
        }
    }

    // DFS to compute the sum of distances for each node
    private void computeSumOfDistances(int node, int parent) {
        for (int neighbor : graph.get(node)) {
            if (neighbor == parent) continue;
            // Update the sum of distances for the neighbor
            distSum[neighbor] = distSum[node] - subtreeCount[neighbor] + (n - subtreeCount[neighbor]);
            // Recursively compute the sum of distances for the neighbor
            computeSumOfDistances(neighbor, node);
        }
    }
}
