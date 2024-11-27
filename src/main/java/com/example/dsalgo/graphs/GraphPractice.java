package com.example.dsalgo.graphs;

import org.springframework.boot.actuate.endpoint.web.Link;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GraphPractice {

    static class Edge{
        int src;
        int dest;

        public Edge(int src, int dest){
            this.src = src;
            this.dest = dest;
        }
    }
    private static int vertices = 5;
    private static ArrayList<Edge> [] graph = new ArrayList[vertices];

    private static ArrayList<Edge> [] initializeGraph(){
        for (int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        return graph;
    }

    public static void main(String[] args) {
//        vertices = 5;
        graph = initializeGraph();

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 3));
        graph[0].add(new Edge(0, 4));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));

        bfs(vertices, graph);
    }
    private static void bfs(int vertices, ArrayList<Edge>[] graph){
        boolean[] vis = new boolean[vertices];
        for (int i = 0; i < vertices; i++) {
            if(!vis[i]) {
                bfs(i, graph, vis);
            }
        }
    }

    private static void bfs(int start, ArrayList<Edge>[] graph, boolean[] vis){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        vis[start] = true;
        while (!queue.isEmpty()){
            int v = queue.poll();
            System.out.print(v + ", ");
            ArrayList<Edge> list = graph[v];
            for(int i = 0; i < list.size(); i++){
                int u = list.get(i).dest;
                if(!vis[u]) {
                    vis[u] = true;
                    queue.add(u);
                }
            }
        }
    }

    private static void dfs(int vertices, ArrayList<Edge>[] graph){
        boolean[] vis = new boolean[vertices];
        for (int i = 0; i < vertices; i++){
            if(!vis[i]){
                dfs(i, graph, vis);
            }
        }
    }

    private static void dfs(int start, ArrayList<Edge>[] graph, boolean[] vis){

    }
}
