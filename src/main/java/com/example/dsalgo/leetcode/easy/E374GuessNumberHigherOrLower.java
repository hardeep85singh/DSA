package com.example.dsalgo.leetcode.easy;

/**
 * @author Hardeep Singh
 */
public class E374GuessNumberHigherOrLower {
    public static void main(String[] args) {
        int n = 100;
        System.out.println(guessNumberBinarySearch(n));
    }

    static int pick = 99;
    static int num = 80;

    public static int guessNumber(int n) {
        int left = 1;
        int right = n;
        int num = -1;
        while(left <= right){
            num = (int) (Math.random()*(right - left)) + left;
            if(guess(num) == 0){
                return num;
            } else if (guess(num) == -1){
                right = num - 1;
            } else {
                left = num + 1;
            }
        }
        return num;
    }

    public static int guessNumberBinarySearch(int n) {
        int left = 1;
        int right = n;
        while(left <= right){
            int mid = left + (right-left) /2;
            if(guess(mid) == 0){
                return mid;
            } else if (guess(mid) == -1){
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return -1;
    }

    private static int guess(int num) {
        if (num > pick) {
            return -1;
        } else if (num < pick) {
            return 1;
        } else {
            return 0;
        }
    }
}
