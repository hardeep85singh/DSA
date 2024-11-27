package com.example.dsalgo.patterns.twopointers;

public class ValidWordAbbreviation {
    public static void main(String[] args) {
        String word = "internationalization";
        String abbr = "13iz4n";
        System.out.println(validWordAbbreviation(word, abbr));
    }

    private static boolean validWordAbbreviation(String word, String abbr) {
        int wordPtr = 0;
        int abbrPtr = 0;

        while (abbrPtr < abbr.length()){
            if(Character.isDigit(abbr.charAt(abbrPtr))){
                if (abbr.charAt(abbrPtr) == '0') {
                    return false;
                }
                int num = 0;

                while (abbrPtr < abbr.length() && Character.isDigit(abbr.charAt(abbrPtr))) {
                    num = num * 10 + (abbr.charAt(abbrPtr) - '0');
                    abbrPtr++;
                }
                wordPtr += num;
            } else {
                if(wordPtr < word.length() && abbr.charAt(abbrPtr) == word.charAt(wordPtr)){
                    abbrPtr++;
                    wordPtr++;
                } else {
                    return false;
                }
            }
        }
        return wordPtr == word.length() && abbrPtr == abbr.length();
    }

}
