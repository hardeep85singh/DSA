package com.example.dsalgo.patterns.twopointers;


public class ReverseWords {
    public static void main(String[] args) {
        String str = "It love myself";
        System.out.println(reverseWords(str));
    }

    public static String reverseWords(String sentence) {
        sentence = sentence.replaceAll("\\s+", " ").trim();
        char[] charArr = sentence.toCharArray();
        reverseString(charArr, 0, sentence.length()-1);
        int start = 0;
        int end = 0;
        while (end < sentence.length()){
            if(end == sentence.length() -1 || charArr[end] == ' '){
                int endIdx = (end == sentence.length() -1 ) ? end : end -1;
                reverseString(charArr, start, endIdx);
                end++;
                start = end;
            }
            end++;
        }
        return String.valueOf(charArr);
    }

    private static void reverseString(char[] chars, int start, int end){
        while (start < end){
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }
}
