package com.example.dsalgo.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Hardeep Singh
 */
public class E409LongestPalindrome {
    public static void main (String[] args){
        String s = "ccc";
        System.out.println(longestPalindrome(s));
    }
    public static int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i< s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        int count = 0;
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            count = count + (entry.getValue() / 2) * 2;
            if(count % 2 == 0 && entry.getValue() % 2 == 1){
                count++;
            }
        }
        return count;
    }
}
