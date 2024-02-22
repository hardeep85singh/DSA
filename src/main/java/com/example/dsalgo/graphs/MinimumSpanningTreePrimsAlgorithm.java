package com.example.dsalgo.graphs;

import java.util.ArrayList;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author Hardeep Singh
 */
public class MinimumSpanningTreePrimsAlgorithm {
    public static void main(String[] args) {

    }

    // simple code with less optimization Time = E log(E), Space = E + V
    public static int minSpanningTree(int vertices, ArrayList<ArrayList<ArrayList<Integer>>> adjList){
        boolean[] visited = new boolean[vertices];
        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>();

        priorityQueue.add(new Pair(0,0));
        int ans = 0;

        while (!priorityQueue.isEmpty()){
            Pair curr = priorityQueue.poll();
            int u = curr.vertex;
            if(visited[u]){
                continue;
            }
            ans = ans + curr.weight;
            visited[u] = true;
            ArrayList<ArrayList<Integer>> neighbors = adjList.get(u);
            for(ArrayList<Integer> neighbor : neighbors){
                int v = neighbor.get(0);
                int w = neighbor.get(1);
                if(!visited[v]){
                    priorityQueue.add(new Pair(v, w));
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
