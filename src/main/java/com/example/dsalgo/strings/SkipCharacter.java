package com.example.dsalgo.strings;

public class SkipCharacter {
    public static void main(String[] args) {
        String str = "abcabcakfa";
        skipCharacter("", str, 'a');
        System.out.println(skipCharacter(str, 'a'));
    }

    private static void skipCharacter(String ans, String str, Character ch){
        if(str.length() == 0){
            System.out.println(ans);
            return;
        }
        if(str.charAt(0) == ch){
            skipCharacter(ans, str.substring(1), ch);
        } else {
            skipCharacter(ans + str.charAt(0), str.substring(1), ch);
        }
    }

    private static String skipCharacter(String str, Character ch){
        if(str.length() == 0){
            return "";
        }
        if(str.charAt(0) == ch){
            return skipCharacter(str.substring(1), ch);
        } else {
            return str.charAt(0) + skipCharacter(str.substring(1), ch);
        }
    }
}
