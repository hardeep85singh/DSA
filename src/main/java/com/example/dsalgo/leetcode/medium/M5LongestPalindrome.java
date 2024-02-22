package com.example.dsalgo.leetcode.medium;

/**
 * @author Hardeep Singh
 */
public class M5LongestPalindrome {
    public static void main(String[] args) {
        String str = "ababd";
        System.out.println(longestPalindrome(str));
    }

    public static String longestPalindrome(String s) {
        char[] chars = s.toCharArray();

        int i = 0;
        int j = chars.length-1;

        while(i <= j){
            char firstOcc = chars[i];
            char last = chars[j];
            int frontIndex = 0;
            while (frontIndex <= j){
                if(firstOcc == last){

                }
                j--;
            }
            if(firstOcc == last){

            }
            i++;
        }
        return null;
    }
}
