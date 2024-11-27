package com.example.dsalgo.leetcode.medium;

public class M2486AppendCharactersToStringToMakeSubsequence {
    public static void main(String[] args) {
        String s = "coaching";
        String t = "coding";
        System.out.println(appendCharacters(s,t));
    }
    public static int appendCharacters(String s, String t) {
        int i = 0; // t's index

        for (char c : s.toCharArray())
            if (c == t.charAt(i)) {
                i++;
                if (i == t.length()) {
                    return 0;
                }
            }

        return t.length() - i;
    }
}
