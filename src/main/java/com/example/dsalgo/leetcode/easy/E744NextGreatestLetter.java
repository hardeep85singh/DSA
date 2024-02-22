package com.example.dsalgo.leetcode.easy;

/**
 * @author Hardeep Singh
 * @since 05-09-2023
 */
public class E744NextGreatestLetter {
    public static void main(String[] args) {
        char[] letters = {'c', 'f', 'j'};
        System.out.println(nextGreatestLetter(letters, 'f'));
    }

    public static char nextGreatestLetter(char[] letters, char target){
        int start = 0;
        int end = letters.length -1;

        while (start <= end){
            int mid = start + (end-start) / 2;
            if(target > letters[mid]){
                start = mid + 1;
            } else {
                end = mid -1;
            }
        }
        return letters[start % letters.length];
    }
}
