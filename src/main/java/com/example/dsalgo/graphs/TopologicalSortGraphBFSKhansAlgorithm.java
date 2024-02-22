package com.example.dsalgo.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Hardeep Singh
 */
public class TopologicalSortGraphBFSKhansAlgorithm {
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
        int vertices = 6;
        System.out.println(Arrays.toString(topologicalSortBfs(vertices, graph)));
    }

    public static int[] topologicalSortBfs(int vertices, ArrayList<ArrayList<Integer>> graph) {
        boolean[] visited = new boolean[vertices];
        int[] inDegree = new int[vertices];
        for (ArrayList<Integer> list : graph) {
            for (int e : list) {
                inDegree[e]++;
            }
        }
        ArrayList<Integer> ansList = new ArrayList<>();

        bfs(vertices, graph, inDegree, ansList);
        int[] ans = new int[vertices];
        int i = 0;
        for (int num : ansList) {
            ans[i] = num;
            i++;
        }
        return ans;
    }

    public static void bfs(int vertices, ArrayList<ArrayList<Integer>> graph, int[] inDegree, ArrayList<Integer> list) {

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < vertices; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            list.add(curr);
            for (int neighbor : graph.get(curr)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }
    }
}
