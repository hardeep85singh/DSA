package com.example.dsalgo.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Hardeep Singh
 */
public class M03LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "abcedabcbb";
        System.out.println(lengthOfLongestSubstring(s));
        System.out.println(lengthOfLongestSubstringSlidingWindowSubstring(s));
        System.out.println(lengthOfLongestSubstringHashmap(s));
    }

    // first try
    public static int lengthOfLongestSubstring(String s) {
//        int count = 1;
        int maxCount = 0;
        if (s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        List<Character> list = new ArrayList<>();
        char[] chars = s.toCharArray();
        int i = 0;
        int j = 1;
        int count = 1;
        list.add(chars[i]);
        while (j < chars.length) {
            if (!list.contains(chars[j])) {
                count++;
                list.add(chars[j]);
            } else if (list.contains(chars[j])) {
                i = list.indexOf(chars[j]) + i + 1;
                j = i;
                list.clear();
                list.add(chars[i]);
                count = 1;
            }
            j++;
            maxCount = Math.max(count, maxCount);
        }
        return maxCount;
    }

    public static int lengthOfLongestSubstringSlidingWindowSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        String test = "";
        int maxCount = -1;

        for (char c : s.toCharArray()) {
            String current = String.valueOf(c);
            if (test.contains(current)) {
                test = test.substring(test.indexOf(current) + 1);
            }
            test = test + c;
            maxCount = Math.max(test.length(), maxCount);
        }
        return maxCount;
    }

    public static int lengthOfLongestSubstringSlidingWindow(String s) {
        int res = 0;

        for (int i = 0; i < s.length(); i++) {
            boolean[] visited = new boolean[256];

            for (int j = i; j < s.length(); j++) {
                // If current character is visited, Break the loop
                if (visited[s.charAt(j)] == true) {
                    break;
                }
                // Else update the result if this window is larger, and mark
                // current character as visited.
                else {
                    res = Math.max(res, j - i + 1);
                    visited[s.charAt(j)] = true;
                }
            }
            // Remove the first character of previous window
            visited[s.charAt(i)] = false;
        }
        return res;
    }

    public static int lengthOfLongestSubstringHashmap(String s){
        Map<Character, Integer> map = new HashMap<>();
        int max = -1;
        int i = 0;
        for(int j = 0; j < s.length(); j++){
            char ch = s.charAt(j);
            if(map.containsKey(ch)){
                i = Math.max(map.get(ch), i);
            }
            max = Math.max(max, j - i + 1);
            map.put(ch, j+1);
        }
        return max;
    }
}
