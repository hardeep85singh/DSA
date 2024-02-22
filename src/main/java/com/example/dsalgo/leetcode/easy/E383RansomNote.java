package com.example.dsalgo.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Hardeep Singh
 */
public class E383RansomNote {
    public static void main(String[] args) {
        String ransomNote = "aa";
        String magazine = "ab";
        System.out.println(canConstructHashmap(ransomNote, magazine));
    }

    public static boolean canConstructHashmap(String ransomNote, String magazine) {
        if (magazine.length() < ransomNote.length()) {
            return false;
        }
        Map<Character, Integer> magazineMap = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            magazineMap.put(magazine.charAt(i), magazineMap.getOrDefault(magazine.charAt(i), 0) + 1);
        }
        Map<Character, Integer> ransomMap = new HashMap<>();
        for (int i = 0; i < ransomNote.length(); i++) {
            ransomMap.put(ransomNote.charAt(i), ransomMap.getOrDefault(ransomNote.charAt(i), 0) + 1);
        }
        for(int i = 0; i< ransomNote.length(); i++){
            char key = ransomNote.charAt(i);
            if(!magazineMap.containsKey(key)){
                return false;
            } else if (ransomMap.get(key) > magazineMap.get(key)){
                return false;
            }
        }
        return true;
    }

    public static boolean canConstructArray(String ransomNote, String magazine) {
        if (magazine.length() < ransomNote.length()) {
            return false;
        }
        int[] ransomNoteArr = new int[26];
        int[] magazineArr = new int[26];
        for (int i = 0; i < ransomNote.length(); i++) {
            ransomNoteArr[ransomNote.charAt(i) - 'a']++;
        }
        for (int i = 0; i < magazine.length(); i++) {
            magazineArr[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            int index = ransomNote.charAt(i) - 'a';
            if (ransomNoteArr[index] > magazineArr[index]) {
                return false;
            }
        }
        return true;
    }
}
