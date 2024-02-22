package com.example.dsalgo.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Hardeep Singh
 */
public class E387FirstUniqueCharacterInAString {
    public static void main(String[] args){
        String s = "loveleetcode";
        System.out.print(firstUniqueCharArray(s));
    }

    public static int firstUniqueCharHashmap(String s) {

        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        for(int i = 0 ; i< s.length(); i++){
            if(map.get(s.charAt(i)) == 1){
                return i;
            }
        }
        return -1;
    }

    public static int firstUniqueCharArray(String s){
        char[] chars = new char[26];

        for(int i = 0; i< s.length(); i++){
           int index = s.charAt(i) - 'a';
           chars[index] ++;
        }

        for(int i = 0; i < s.length(); i++){
            int index = s.charAt(i) - 'a';
            if(chars[index] == 1){
                return i;
            }
        }
        return -1;
    }
}
