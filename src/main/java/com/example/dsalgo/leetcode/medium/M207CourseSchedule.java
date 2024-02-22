package com.example.dsalgo.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hardeep Singh
 */
public class M207CourseSchedule {
    public static void main(String[] args) {
        int n = 2;
        int[][] edges = {{1, 0}};
        System.out.println(canFinish(n, edges));
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] pre : prerequisites) {
            graph[pre[0]].add(pre[1]);
        }
        boolean[] visited = new boolean[numCourses];
        boolean[] isComplete = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (dfs(i, graph, visited, isComplete)) {
                return false;
            }
        }
        return true;
    }

    private static boolean dfs(int current, List<Integer>[] graph, boolean[] visited, boolean[] isComplete) {
//        if (visited[current]) {
//            return false;
//        }
//        if (isComplete[current]) {
//            return true;
//        }
        visited[current] = true;
        isComplete[current] = true;
        for (int next : graph[current]) {
            if (!visited[next]) {
                if (dfs(next, graph, visited, isComplete)) {
                    return true;
                }
            } else if (isComplete[next]) {
                return true;
            }
        }
        isComplete[current] = false;
        return false;
    }
}
