package com.example.dsalgo.leetcode.easy;

import java.util.HashMap;

/**
 * @author Hardeep Singh
 */
public class E290WordPattern {
    public static void main (String [] args){
        String pattern = "abba", s = "dog cat cat dog";
        System.out.println(wordPattern(pattern, s));
    }
    public static boolean wordPatternSingleHashmap(String pattern, String s){
        // map for storing indexes
        HashMap map = new HashMap<>();
        String[] words = s.split(" ");
        if(pattern.length() != words.length){
            return false;
        }
        for (Integer i = 0; i < pattern.length(); i++){
            char c = pattern.charAt(i);
            String w = words[i];
            if(!map.containsKey(c)){
                map.put(c, i);
            }
            if(!map.containsKey(w)){
                map.put(w, i);
            }
            if(map.get(c) != map.get(w)){
                return false;
            }
        }
        return true;
    }
    public static boolean wordPattern(String pattern, String s) {
        HashMap <Character, String> map_char = new HashMap();
        HashMap <String, Character> map_word = new HashMap();
        String[] words = s.split(" ");

        if (words.length != pattern.length()) {
            return false;
        }

        for (int i = 0; i < words.length; i++) {
            char c = pattern.charAt(i);
            String w = words[i];
            if (!map_char.containsKey(c)) {
                if (map_word.containsKey(w)) {
                    return false;
                } else {
                    map_char.put(c, w);
                    map_word.put(w, c);
                }

            } else {
                String mapped_word = map_char.get(c);
                if (!mapped_word.equals(w))
                    return false;
            }
        }

        return true;
    }
}
