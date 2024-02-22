package com.example.dsalgo.leetcode.easy;

/**
 * @author Hardeep Singh
 */
public class E557ReverseWordsInAString {
    public static void main(String[] args) {
        String s = "Let's contest";
        System.out.println(reverseWords(s));
    }

    public static String reverseWords(String s) {
        String str = "";
        int i = 0;
        int j = 0;
        char[] chars = s.toCharArray();
        while (j < chars.length) {
            if (chars[j] != ' ') {
                j++;
                if (j == s.length()) {
                    String newStr = s.substring(i, j);
                    char[] tempCh = newStr.toCharArray();
                    str = str + reverseString(tempCh);
                }
            } else if (chars[j] == ' ') {
                String newStr = s.substring(i, j);
                char[] tempCh = newStr.toCharArray();
                str = str + reverseString(tempCh) + " ";
                j++;
                i = j;
            }
        }
        return str;
    }

    public static String reverseString(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            char temp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = temp;
        }
        return String.valueOf(s);
    }
}
