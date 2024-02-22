package com.example.dsalgo.graphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author Hardeep Singh
 */
public class GraphDepthFirstSearch {
    static int vertices = 4;
    static LinkedList<Integer> adj[] = new LinkedList[vertices];

    public static void main(String[] args) {

        Graph graph = new Graph(vertices, adj);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(1,2);
        graph.addEdge(2,0);
        graph.addEdge(2,3);
        graph.addEdge(3,3);
        dfsIterative(2);
        depthFirstSearch(2);
    }

    public static void depthFirstSearch(int start) {
        boolean isVisited[] = new boolean[vertices];
        dfsRecursive(start, isVisited);
    }

    private static void dfsRecursive(int current, boolean[] isVisited) {
        isVisited[current] = true;
        printCurrent(current);
        for (int dest : adj[current]){
            if (!isVisited[dest]){
                dfsRecursive(dest, isVisited);
            }
        }
    }

    private static void printCurrent(int value) {
        System.out.print(" " + value);
    }

    public static void dfsIterative(int start){
        Stack<Integer> stack = new Stack<>();
        boolean isVisited[] = new boolean[vertices];
        stack.push(start);
        while (!stack.isEmpty()){
            int current = stack.pop();
            System.out.print(current + " ");
            if(!isVisited[current]){
                isVisited[current] = true;
                for (int dest : adj[current]){
                    if(!isVisited[dest]){
                        stack.push(dest);
                    }
                }
            }
        }
    }
}
