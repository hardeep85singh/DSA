package com.example.dsalgo.graphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Hardeep Singh
 */
public class GraphBreadthFirstSearch {
    static int vertices = 4;
    static LinkedList<Integer> adj[] = new LinkedList[vertices];

    public static void main (String [] args){

        Graph graph = new Graph(vertices, adj);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(1,2);
        graph.addEdge(2,0);
        graph.addEdge(2,3);
        graph.addEdge(3,3);
        breadthFirstSearch(2);
    }

    public static void breadthFirstSearch(int start){
        boolean visited[] = new boolean[vertices];

        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()){
            start = queue.poll();
            System.out.print(start + " ");

            Iterator<Integer> iterator = adj[start].listIterator();
            while (iterator.hasNext()){
                int n = iterator.next();
                if(!visited[n]){
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }
}
