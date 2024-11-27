package com.example.dsalgo.leetcode.medium;

import java.util.Arrays;

public class M1482MinimumNumberOfDaysToMakeMBouquets {

    public static void main(String[] args) {
        int[] bloomDay = {7,7,7,7,12,7,7};
        int m = 2, k = 2;
        System.out.println(minDays(bloomDay, m, k));
    }
    public static int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if((long) m * k > n){
            return -1;
        }
        int left = Arrays.stream(bloomDay).min().getAsInt();
        int right = Arrays.stream(bloomDay).max().getAsInt();
        int ans = -1;

        while (left <= right){
            int mid = (left + right) / 2;
            if(isOkayDays(mid, bloomDay, m, k)){
                ans = mid;
                right = mid -1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    private static boolean isOkayDays(int mid, int[] bloomDay, int m, int k) {
        int consecCount = 0;
        int numOfBouquet = 0;
        for (int i = 0; i < bloomDay.length; i++) {
            if(bloomDay[i] <= mid){
                consecCount++;
            } else {
                consecCount = 0;
            }
            if(consecCount == k){
                numOfBouquet++;
                consecCount = 0;
            }
        }

        return numOfBouquet >= m;
    }
}
