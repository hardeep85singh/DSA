package com.example.dsalgo.leetcode.easy;

import java.util.*;


/**
 * Given two strings s and t, determine if they are isomorphic.
 * Two strings s and t are isomorphic if the characters in s can be replaced to get t.
 * All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.
 */
public class E205IsomorphicStrings {
    public static void main(String[] args) {
        System.out.println(isIsomorphic("egg", "add"));
    }

//    public static boolean isIsomorphic(String s, String t) {
//        Map<Character, Character> map = new HashMap<>();
//        if(s.length() != t.length()){
//            return false;
//        }
//        for(int i = 0; i< s.length(); i++){
//            if(map.containsKey(s.charAt(i))){
//                if(map.get(s.charAt(i)) != t.charAt(i)){
//                    return false;
//                }
//            }
//            map.put(s.charAt(i), t.charAt(i));
//        }
//
//        return true;
//    }

    public static boolean isIsomorphic(String s, String t){
        Map<Character, List<Integer>> mapS = new HashMap<>();
        Map<Character, List<Integer>> mapT = new HashMap<>();
        if(s.length() != t.length()){
            return false;
        }
        for(int i = 0; i< s.length(); i++){
            List<Integer> list;
            if(mapS.containsKey(s.charAt(i))){
                list = mapS.get(s.charAt(i));
            } else {
                list = new ArrayList<>();
            }
            list.add(i);
            mapS.put(s.charAt(i), list);

            List<Integer> listT;
            if(mapT.containsKey(t.charAt(i))){
                listT = mapT.get(t.charAt(i));
            } else {
                listT = new ArrayList<>();
            }
            listT.add(i);
            mapT.put(t.charAt(i), listT);
        }

        for(int i = 0; i < s.length(); i++){
            List<Integer> listS = mapS.get(s.charAt(i));
            List<Integer> listT = mapT.get(t.charAt(i));
            for(int j = 0; j < listS.size(); j++){
                if(!Objects.equals(listS.get(j), listT.get(j))){
                    return false;
                }
            }
        }
        return true;
    }

}
