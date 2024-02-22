package com.example.dsalgo.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author Hardeep Singh
 */
public class DijkstrasAlgorithm {
    public static void main(String[] args) {

    }
    public static int[] dijstraAlgorithm(int vertices, ArrayList<ArrayList<ArrayList<Integer>>> adj, int source){
        boolean[] visited = new boolean[vertices];
        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>();
        int[] ans = new int[vertices];
        Arrays.fill(ans, Integer.MAX_VALUE);
        ans[source] = 0;
        priorityQueue.add(new Pair(source,0));

        while (!priorityQueue.isEmpty()){
            Pair curr = priorityQueue.poll();
            int u = curr.vertex;
            if(visited[u]){
                continue;
            }
            visited[u] = true;
            ArrayList<ArrayList<Integer>> neighbors = new ArrayList<>();
            for (ArrayList<Integer> neighbor : neighbors){
                int v = neighbor.get(0);
                int w = neighbor.get(1);
                if(ans[v] > ans[u] + w){
                    ans[v] = ans[u] + w;
                    priorityQueue.add(new Pair(v, ans[v]));
                }
            }
        }
        return ans;
    }
    static class Pair implements Comparable<Pair>{
        int vertex;
        int weight;
        Pair(int vertex, int weight){
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Pair o) {
            return this.weight - o.weight;
        }
    }

}
