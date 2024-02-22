package com.example.dsalgo.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * @author Hardeep Singh
 */
public class TopologicalSortGraphDFS {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        ArrayList<Integer> arr0 = new ArrayList<>();
        arr0.add(2);
        arr0.add(3);
        graph.add(arr0);
        ArrayList<Integer> arr1 = new ArrayList<>();
        arr1.add(4);
        graph.add(arr1);
        ArrayList<Integer> arr2 = new ArrayList<>();
        arr2.add(1);
        arr2.add(3);
        graph.add(arr2);
        ArrayList<Integer> arr3 = new ArrayList<>();
        arr3.add(1);
        graph.add(arr3);
        ArrayList<Integer> arr4 = new ArrayList<>();
        graph.add(arr4);
        ArrayList<Integer> arr5 = new ArrayList<>();
        arr5.add(1);
        arr5.add(4);
        graph.add(arr5);
        int v = 6;
        System.out.println(Arrays.toString(topologicalSortDfs(v, graph)));
    }

    public static int[] topologicalSortDfs(int v, ArrayList<ArrayList<Integer>> graph){
        boolean[] visited = new boolean[v];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < v; i++){
            if(!visited[i]){
                dfs(i, graph, visited, stack);
            }
        }
        int [] ans = new int[v];
        int i = 0;
        while (!stack.isEmpty()){
            ans[i] = stack.pop();
            i++;
        }
        return ans;
    }

    public static void dfs(int v, ArrayList<ArrayList<Integer>> graph, boolean[] visited, Stack<Integer> stack){
        visited[v] = true;

        for(int next : graph.get(v)){
            if(!visited[next]){
                dfs(next, graph, visited, stack);
            }
        }
        stack.push(v);
    }
}
