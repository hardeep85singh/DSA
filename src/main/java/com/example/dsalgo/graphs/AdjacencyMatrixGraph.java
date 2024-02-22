package com.example.dsalgo.graphs;

/**
 * @author Hardeep Singh
 */
public class AdjacencyMatrixGraph {
    static int vertices = 5;
    static int edges = 10;
    static int [][] adjMatrix = new int[vertices + 1][vertices + 1];
    public static void main(String[] args) {

    }

    public static void addEdge(int source, int destination){
        adjMatrix[source][destination] = 1;
        adjMatrix[destination][source] = 1;
    }
}
