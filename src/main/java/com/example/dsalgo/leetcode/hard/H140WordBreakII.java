package com.example.dsalgo.leetcode.hard;

import java.util.*;

public class H140WordBreakII {

    public static void main(String[] args) {
      String s = "pineapplepenapple";
      String[] strs = {"apple","pen","applepen","pine","pineapple"};
      List<String> wordDict = Arrays.asList(strs);
      for (String str : wordBreak(s, wordDict)){
          System.out.print(str + ", ");
      }
    }

    public static List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        Map<String, List<String>> mem = new HashMap<>();
        return wordBreak(s, wordSet, mem);
    }

    private static List<String> wordBreak(final String s, Set<String> wordSet,
                                   Map<String, List<String>> mem) {
        if (mem.containsKey(s)) {
            return mem.get(s);
        }

        List<String> ans = new ArrayList<>();

        // 1 <= prefix.length() < s.length()
        for (int i = 1; i < s.length(); i++) {
            String prefix = s.substring(0, i);
            String suffix = s.substring(i);
            if (wordSet.contains(prefix)) {
                for (String word : wordBreak(suffix, wordSet, mem)) {
                    ans.add(prefix + " " + word);
                }
            }
        }

        // `wordSet` contains the whole string s, so don't add any space.
        if (wordSet.contains(s)) {
            ans.add(s);
        }

        mem.put(s, ans);
        return ans;
    }
}
