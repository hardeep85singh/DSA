package com.example.dsalgo.leetcode.medium;

import java.util.Stack;

public class M1717MaximumScoreFromRemovingSubstrings {
    public static void main(String[] args) {
//        String s = "cdbcbbaaabab";
        String s = "aabbaaxybbaabb";
        System.out.println(maximumGain(s, 5, 4));
    }

    public static int maximumGain(String s, int x, int y) {
        int ans = 0;
        if(x > y){
            ans = maximumGain(s, x, y, 'a', 'b');
        } else {
            ans = maximumGain(s, y, x, 'b', 'a');
        }
        return ans;
    }

    private static int maximumGain(String s, int firstValue, int secondValue, char firstChar, char secondChar) {
        int ans = 0;
        Stack<Character> stack = new Stack<>();

        // First pass: remove the more valuable substring
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == firstChar && c == secondChar) {
                stack.pop();
                ans += firstValue;
            } else {
                stack.push(c);
            }
        }

        // Remaining string after first pass
        StringBuilder remaining = new StringBuilder();
        while (!stack.isEmpty()) {
            remaining.insert(0, stack.pop());
        }

        // Second pass: remove the less valuable substring
        for (char c : remaining.toString().toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == secondChar && c == firstChar) {
                stack.pop();
                ans += secondValue;
            } else {
                stack.push(c);
            }
        }

        return ans;
    }

}
