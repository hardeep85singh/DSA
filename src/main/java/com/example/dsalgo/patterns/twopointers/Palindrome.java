package com.example.dsalgo.patterns.twopointers;

public class Palindrome {

    public static void main(String[] args) {
        String s = "abcba";
        System.out.println(isPalindrome(s));
    }

    private static boolean isPalindrome(String s){
        int start = 0;
        int end = s.length() -1;

        while (start < end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            } else{
                start ++;
                end --;
            }
        }
        return true;
    }
}
