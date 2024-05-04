package com.example.dsalgo.leetcode.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class M2370LongestIdealSubsequence {
    public static void main(String[] args) {
        System.out.println(longestIdealString("dyyonfvzsretqxucmavxegvlnnjubqnwrhwikmnnrpzdovjxqdsatwzpdjdsneyqvtvorlwbkb", 7));
    }

//    public static int longestIdealString(String s, int k) {
//        Map<String, Integer> map = new HashMap<>();
//        map.put(String.valueOf(s.charAt(0)), 1);
//        int ans = 1;
//
//        for (int i = 1; i < s.length(); i++) {
//            char ch = s.charAt(i);
//            Map<String, Integer> tempMap = new HashMap<>(map);
//            for (Map.Entry<String, Integer> entry : tempMap.entrySet()) {
//                String str = entry.getKey();
//                int length = entry.getValue();
//                if (Math.abs(str.charAt(str.length() - 1) - ch) <= k) {
//                    str = str + ch;
//                    length++;
//                    // Update existing entry
//                    map.put(str, length);
//                    ans = Math.max(length, ans);
//                } else{
//                    // Put the current character as a single character into the map
//                    map.put(String.valueOf(ch), 1);
//                }
//            }
//        }
//        return ans;
//    }
    public static int longestIdealString(String s, int k) {
        int lengthStr = s.length();
        int longestLength = 1;
        int[] dp = new int[lengthStr]; // Array to store the length of the longest ideal substring ending at each character.
        Arrays.fill(dp, 1);

        // HashMap to keep track of the last index of each character that is part of the longest ideal string so far.
        Map<Character, Integer> lastSeenCharacterMap = new HashMap<>(26);

        // Place the first character in the map to start the process.
        lastSeenCharacterMap.put(s.charAt(0), 0);

        // Iterate through each character in the string starting from the second character.
        for (int i = 1; i < lengthStr; ++i) {
            char currentChar = s.charAt(i); // The current character for which we are finding the ideal string.

            // Check closeness of every character in the alphabet to the current character within the limit k.
            for (char prevChar = 'a'; prevChar <= 'z'; ++prevChar) {
                // If the absolute difference in ASCII value is within the limit k, we proceed.
                if (Math.abs(currentChar - prevChar) > k) {
                    continue;
                }
                // If the previous character has been seen and is part of an ideal string,
                // we update the DP table by taking the max of the current dp value or
                // the dp value of the previous character's last index plus one.
                if (lastSeenCharacterMap.containsKey(prevChar)) {
                    dp[i] = Math.max(dp[i], dp[lastSeenCharacterMap.get(prevChar)] + 1);
                }
            }

            // Update the last seen index of the current character to be the current index.
            lastSeenCharacterMap.put(currentChar, i);
            longestLength = Math.max(longestLength, dp[i]);
        }
        return longestLength;
    }

}
