package com.example.dsalgo.leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Hardeep Singh
 */
public class M1443MinimumTimeToCollectAllApplesInTree {
    public static void main(String[] args) {
        int n = 7;
        int[][] edges = {{0,1},{0,2},{1,4},{1,5},{2,3},{2,6}};
        List<Boolean> hasApple = new ArrayList<>();
        hasApple.add(false);
        hasApple.add(false);
        hasApple.add(true);
        hasApple.add(false);
        hasApple.add(true);
        hasApple.add(true);
        hasApple.add(false);

        System.out.println(minTimeRecursive(n, edges, hasApple));
        // TODO check
        System.out.println(minTimeIterative(n, edges, hasApple));
    }

    private static int minTimeIterative(int n, int[][] edges, List<Boolean> hasApple) {
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        int minTime = 0;
        Stack<Integer> stack = new Stack<>();
        boolean[] isVisited = new boolean[n];
        stack.push(0);
        while (!stack.isEmpty()){
            int current = stack.pop();
            System.out.print(current + " ");
            int time = 0;
            if(!isVisited[current]){
                isVisited[current] = true;
                for (int next : graph[current]){
                    if(!isVisited[next]){
                        stack.push(next);
                        if(hasApple.get(current)){
                            time = time + 2;
                        }
                    }
                }
            }
            if ((time > 0 || hasApple.get(current)) && current != 0) {
                minTime = minTime + time + 2;
            }
        }
        return minTime;
    }

    public static int minTimeRecursive(int n, int[][] edges, List<Boolean> hasApple){
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        int minTime = 0;
        Stack<Integer> stack = new Stack<>();
        boolean[] isVisited = new boolean[n];
        return dfs(graph, 0, hasApple, isVisited);

    }

    private static int dfs(List<Integer>[] graph, int curr, List<Boolean> hasApple, boolean[] isVisited) {
        int minTime = 0;
        System.out.print(curr + " ");
        isVisited[curr] = true;
        for (int next : graph[curr]){
            if (!isVisited[next]){
                minTime = minTime + dfs(graph, next, hasApple, isVisited);
            }
        }
        if ((minTime > 0 || hasApple.get(curr)) && curr != 0) {
            minTime = minTime + 2;
        }
        return minTime;
    }
}
