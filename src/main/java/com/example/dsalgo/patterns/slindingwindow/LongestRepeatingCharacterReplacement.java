package com.example.dsalgo.patterns.slindingwindow;

import java.util.HashMap;
import java.util.Map;

/*
* Given a string s and an integer k, find the length of the longest substring in s,
*  where all characters are identical, after replacing, at most,
*  k characters with any other lowercase English character.
* */
public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        String str = "roller";
        int k = 2;
        System.out.println(longestRepeatingCharacterReplacement(str, k));
    }

    public static int longestRepeatingCharacterReplacement (String s, int k) {
        int start = 0;
        int end = 0;
        Map<Character, Integer> map = new HashMap<>();
        int lengthOfMaxSubstring = 0;
        int mostFreqChar = 0;
        while (end < s.length()){
            char ch = s.charAt(end);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            mostFreqChar = Math.max(mostFreqChar, map.get(ch));
            if(end - start + 1 - mostFreqChar > k){
                map.put(s.charAt(start), map.get(s.charAt(start)) - 1);
                start++;
            }
            lengthOfMaxSubstring = Math.max(lengthOfMaxSubstring, end - start + 1);
            end++;
        }
        return lengthOfMaxSubstring;
    }
//    public static int longestRepeatingCharacterReplacement(String s, int k) {
//        int ans = 0;
//        int i = 0;
//        int j = 0;
//        int l = 0;
//        int maxLen = 0;
//        while (i < s.length()){
//            while (j < s.length() && l < k){
//                if(s.charAt(i) != s.charAt(j)){
//                    l++;
//                }
//                maxLen++;
//                j++;
//            }
//            while (j < s.length() && s.charAt(j) == s.charAt(i)){
//                maxLen++;
//                j++;
//            }
//            ans = Math.max(maxLen, ans);
//            l = 0;
//            maxLen = 0;
//            while (i + 1 < s.length() && s.charAt(i) == s.charAt(i+1)){
//                i++;
//            }
//            i++;
//            j = i;
//        }
//        return ans;
//    }
}
