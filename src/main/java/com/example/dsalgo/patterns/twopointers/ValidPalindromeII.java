package com.example.dsalgo.patterns.twopointers;

public class ValidPalindromeII {

    public static void main(String[] args) {
        String str = "madame";
        System.out.println(isPalindrome(str));
    }

    public static boolean isPalindrome(String str){
        int start = 0;
        int end = str.length() - 1;
        while (start < end){
            if (str.charAt(start) != str.charAt(end)) {
                return isPalindrome(str, start + 1, end) || isPalindrome(str, start, end - 1);
            }
            start++;
            end--;
        }
        return true;
    }

    private static boolean isPalindrome(String str, int start, int end){
        while (start < end){
            if(str.charAt(start) != str.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
