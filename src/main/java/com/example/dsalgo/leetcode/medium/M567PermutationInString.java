package com.example.dsalgo.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Hardeep Singh
 */
public class M567PermutationInString {
    public static void main(String[] args){
        String s1 = "az";
        String s2 = "enkwekabklj";
        System.out.println(checkInclusionArray(s1,s2));
    }

    private static boolean checkInclusionBrute(String s1, String s2) {
        return false;
    }

    public static boolean checkInclusionHashmap(String s1, String s2) {
        if(s2.length() < s1.length()){
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s1.length(); i++){
            map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i), 0) +1);
        }
        for(int i = 0; i < s2.length() - s1.length() + 1; i++){
            String temp = s2.substring(i, s1.length()+i);
            char [] chars = temp.toCharArray();
            for (int j = 0; j < s1.length(); j++){
                if(!map.containsKey(chars[j])){
                    break;
                } else if(map.containsKey(chars[j])){
                    map.put(chars[j], map.get(chars[j]) - 1);
                }
            }
        }
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            if(entry.getValue() != 0){
                return false;
            }
        }
        return true;
    }

    public static boolean checkInclusionArray(String s1, String s2){
        if(s1.length() > s2.length()){
            return false;
        }
        int[] s1map = new int[26];
        for(int i = 0; i< s1.length(); i++){
            s1map[s1.charAt(i) - 'a']++;
        }
        for(int i = 0; i< s2.length() - s1.length() + 1; i++){
            int[] s2map = new int[26];
            for(int j = 0; j< s1.length(); j++){
                s2map[s2.charAt(i+j) - 'a']++;
            }
            if(matchesArray(s1map, s2map)){
                return true;
            }
        }
        return false;
    }

    private static boolean matchesArray(int[] s1map, int[] s2map) {
        for(int i = 0; i< s1map.length; i++){
            if(s1map[i] != s2map[i]){
                return false;
            }
        }
        return true;
    }

}
