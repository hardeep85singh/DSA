package com.example.dsalgo.graphs;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author Hardeep Singh
 */
public class AdjacencyListGraph {
//    static ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
//    static int vertices;
//    public static void main(String[] args) {
//        for(int i = 0; i< vertices; i++){
//            adjList.add(new ArrayList<>());
//        }
//    }
//
//    public static void addEdge(int source, int destination){
//        adjList.get(source).add(destination);
//        adjList.get(destination).add(source);
//    }
    static class Edge{
        int src;
        int dest;

        public Edge(int src, int dest){
            this.src = src;
            this.dest = dest;
        }
    }
    private int vertices;
    private ArrayList<Edge> graph[] = new ArrayList[vertices];

    public void initialize(){
        for (int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }
    }

}
