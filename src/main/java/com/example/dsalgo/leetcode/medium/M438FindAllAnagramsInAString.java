package com.example.dsalgo.leetcode.medium;

import java.util.*;

/**
 * @author Hardeep Singh
 */
//Given two strings s and p, return an array of all the start indices of p's anagrams in s.
// You may return the answer in any order.
public class M438FindAllAnagramsInAString {
    public static void main(String[] args){
        String s = "aaaaaa";
        String p = "aaaa";
        System.out.println(findAnagramsSlidingWindow(s,p));
    }
    public static List<Integer> findAnagramArraySlidingWindow(String s, String p){
        int sL = s.length();
        int pL = p.length();
        if (pL > sL){
            return new ArrayList<>();
        }
        int[] sArr = new int[26];
        int[] pArr = new int[26];
        for(int i = 0; i< pL; i++){
            pArr[p.charAt(i) - 'a'] ++;
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i< sL; i++){
            sArr[s.charAt(i) - 'a']++;

            if(i >= pL){
                sArr[s.charAt(i - pL) - 'a']--;
            }

            if(Arrays.equals(sArr, pArr)){
                list.add(i - pL + 1);
            }
        }
        return list;
    }

    public static List<Integer> findAnagramsBrute(String s, String p) {
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i<= s.length()-p.length(); i++){
            map.put(i, s.substring(i, i+p.length()));
        }
        List<Integer> list = new ArrayList<>();
        for(Map.Entry<Integer, String> entry: map.entrySet()){
            if(isAnagram(entry.getValue(), p)){
                list.add(entry.getKey());
            }
        }
        return list;
    }

    public static List<Integer> findAnagramsSlidingWindow(String s, String p){
        int i = 0; int j = 0;
        List<Integer> list = new ArrayList<>();
        if(p.length() > s.length()){
            return list;
        }
        String temp = "";
        while (j <= s.length()){
            if (j < p.length()){
                temp = temp + s.charAt(j);
                j++;
            } else if(j-i == p.length()){
                if(isAnagramMap(temp, p)){
                    list.add(i);
                }
                if(j < s.length()) {
                    temp = s.substring(i + 1, j) + s.charAt(j);
                }
                i++;
                j++;
            }
        }
        return list;
    }

    private static boolean isAnagram(String s, String p) {
        char[] sChars = s.toCharArray();
        char[] pChars = p.toCharArray();
        Arrays.sort(sChars);
        Arrays.sort(pChars);
        for(int i = 0; i< sChars.length; i++){
            if(sChars[i] != pChars[i]){
                return false;
            }
        }
        return true;
    }

    public static boolean isAnagramMap(String s, String p){
        Map<Character, Integer> sMap = new HashMap<>();
        for (int i = 0; i< s.length(); i++){
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
        }
        for(int i = 0; i< p.length(); i++){
            char ch = p.charAt(i);
            if(!sMap.containsKey(ch)){
                return false;
            } else if (sMap.containsKey(ch)){
                sMap.put(ch, sMap.get(ch) -1);
                if(sMap.get(ch) < 0){
                    return false;
                }
            }
        }
        return true;
    }
}
