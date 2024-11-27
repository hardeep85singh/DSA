package com.example.dsalgo.patterns.slindingwindow;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String str = "pwwkew";
        System.out.println(findLongestSubstring(str));
    }

    public static int findLongestSubstring(String str) {

        Set<Character> seenChar = new HashSet<>();
        int left = 0;
        int longest = 0;
        for (int right = 0; right < str.length(); right++) {
            char curr = str.charAt(right);
            while (seenChar.contains(curr)) {
                seenChar.remove(str.charAt(left));
                left++;
            }

            seenChar.add(curr);

            longest = Math.max(longest, right - left + 1);
        }
        return longest;
    }
}
