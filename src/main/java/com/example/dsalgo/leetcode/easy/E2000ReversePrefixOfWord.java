package com.example.dsalgo.leetcode.easy;

public class E2000ReversePrefixOfWord {
    public static void main(String[] args) {
        System.out.println(reversePrefix("abczefd", 'd'));
    }
    public static String reversePrefix(String word, char ch) {

        String postfix = "";
        String prefix = "";
        for (int i = 0; i < word.length(); i++){
            if (word.charAt(i) == ch){
                prefix = reverseString(word.substring(0, i+1));
                postfix = word.substring(i+1);
                return prefix + postfix;
            }
        }
        return word;
    }

    public static String reverseString(String s) {
        char[] chars = s.toCharArray();
        int left = 0, right = chars.length - 1;
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return new String(chars);
    }
}
