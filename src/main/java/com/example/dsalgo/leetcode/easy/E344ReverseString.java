package com.example.dsalgo.leetcode.easy;

/**
 * @author Hardeep Singh
 */
public class E344ReverseString {
    public static void main(String[] args){
      String s = "hardeep";
      char[] ch = new char[s.length()];
//      System.out.println(String.valueOf(reverseString(ch)));
    }

    public static void reverseString(char[] s) {

        for(int i = 0; i< s.length/ 2 ; i++){
            char temp = s[i];
            s[i] = s[s.length-1-i];
            s[s.length-1-i] = temp;

        }

    }
}
