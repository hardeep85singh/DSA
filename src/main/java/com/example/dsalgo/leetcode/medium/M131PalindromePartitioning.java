package com.example.dsalgo.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class M131PalindromePartitioning {

    public static void main(String[] args) {
        String s = "aab";
        List<List<String>> ans = partition(s);
        for (List<String> l : ans) {
            System.out.println(Arrays.toString(l.toArray()));
        }
    }
    public static List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        dfs(s, 0, new ArrayList<>(), ans);
        return ans;
    }

    private static void dfs(String s, int start, List<String> path, List<List<String>> ans) {
        if (start == s.length()) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < s.length(); ++i) {
            if (isPalindrome(s, start, i)) {
                path.add(s.substring(start, i + 1));
                dfs(s, i + 1, path, ans);
                path.remove(path.size() - 1);
            }
        }
    }

    private static boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) {
                return false;
            }
        }
        return true;
    }
}
