package com.example.dsalgo.graphs;

import jdk.jfr.DataAmount;
import lombok.Data;

import java.util.LinkedList;

/**
 * @author Hardeep Singh
 */
@Data
public class Graph {
    // number of Vertices
    private int vertices;
    // adjacency list
    private LinkedList<Integer> adj[];

    public Graph(int vertices){
        this.vertices = vertices;
        adj = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++){
            adj[i] = new LinkedList<>();
        }
    }
    public Graph(int vertices, LinkedList<Integer> adj[]){
        this.vertices = vertices;
        this.adj = adj;
        for (int i = 0; i < vertices; i++){
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int v, int w){
        adj[v].add(w);
    }
}
