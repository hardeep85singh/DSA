package com.example.dsalgo.patterns.slindingwindow;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String s = "cabwefgewcwaefgcf";
        String t = "cae";
        System.out.println(minWindow(s, t));
    }

    public static String minWindow(String s, String t) {
        int left = 0;
        int right;
        Map<Character, Integer> reqCount = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char ch : t.toCharArray()){
            reqCount.put(ch, reqCount.getOrDefault(ch, 0) + 1);
            window.put(ch, 0);
        }
        int current = 0;
        int required = window.size();
        int[] res = {-1, -1};
        int resLen = Integer.MAX_VALUE;
        for (right = 0; right < s.length(); right++){
            char c = s.charAt(right);

            if (t.indexOf(c) != -1) {
                window.put(c, 1 + window.getOrDefault(c, 0));
            }

            if (reqCount.containsKey(c) && window.get(c).equals(reqCount.get(c))) {
                current++;
            }
            while (current == required){
                if ((right - left + 1) < resLen) {
                    res[0] = left;
                    res[1] = right;
                    resLen = (right - left + 1);
                }

                char leftChar = s.charAt(left);
                if (t.indexOf(leftChar) != -1) {
                    window.put(leftChar, window.get(leftChar) - 1);
                }

                if (reqCount.containsKey(leftChar) && window.get(leftChar) < reqCount.get(leftChar)) {
                    current--;
                }
                left++;
            }

        }

        int leftIndex = res[0];
        int rightIndex = res[1];
        return resLen != Integer.MAX_VALUE ? s.substring(leftIndex, rightIndex + 1) : "";
    }
}
