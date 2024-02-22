package com.example.dsalgo.timecomplexity;

/**
 * @author Hardeep Singh
 */
public class PalindromicTime {
    public static void main(String[] args) {
        System.out.println(palindromicTime("23:59"));
    }

    public static int palindromicTime(String A) {
        int ans = 0;
        int hour = (A.charAt(0) - '0') * 10 + (A.charAt(1) - '0');
        int minute = (A.charAt(3) - '0') * 10 + (A.charAt(4) - '0');
        int temHour = (A.charAt(1) - '0') * 10 + (A.charAt(0) - '0');
        if (hour >= 6 && hour < 10 || hour == 5 && minute > 50) {
            ans = (10 - hour) * 60 - minute + 1;
        } else if (hour >= 16 && hour < 20 || hour == 15 && minute > 51) {
            ans = (20 - hour) * 60 - minute + 2;
        } else if (temHour - minute >= 0) {
            ans = temHour - minute;
        } else if (hour == 23) {

            ans = 60 - minute;
        } else {
            ans = 60 - minute + temHour + 10;
        }
        return ans;
    }

}
