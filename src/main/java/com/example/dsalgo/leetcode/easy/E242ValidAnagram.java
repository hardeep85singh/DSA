package com.example.dsalgo.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Hardeep Singh
 */
public class E242ValidAnagram {
    public static void main(String [] args){
        String s = "a";
        String t = "b";
        System.out.println(isAnagramSorting(s,t));
        System.out.println(isAnagramArray(s,t));
        System.out.println(isAnagramHashmap(s,t));
    }

    public static boolean isAnagramSorting(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        char[] sArr = s.toCharArray();
        char[] tArr  =t.toCharArray();
        Arrays.sort(sArr);
        Arrays.sort(tArr);
        for(int i = 0; i< sArr.length; i++){
            if(sArr[i] != tArr[i]){
                return false;
            }
        }
        return true;
    }

    public static boolean isAnagramArray(String s, String t){
        if(s.length() != t.length()){
            return false;
        }
        int[] sArr = new int[26];
        int[] tArr = new int[26];
        for(int i = 0; i< s.length(); i++){
            sArr[s.charAt(i) - 'a']++;
        }
        for(int i = 0; i < t.length(); i++){
            int index = t.charAt(i) - 'a';
            if(sArr[index] == 0){
                return false;
            }
            sArr[index]--;
        }
        return true;
    }

    public static boolean isAnagramHashmap(String s, String t){
        if(s.length() != t.length()){
            return false;
        }
        Map<Character, Integer> sMap = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
        }
        for(int i = 0; i< t.length(); i++){
            char ch = t.charAt(i);
            int count = sMap.getOrDefault(ch, 0);
            if(count == 0){
                return false;
            }
            sMap.put(ch, sMap.get(ch) - 1);
        }
        return true;
    }
}
