package com.example.dsalgo.hashmaps;

import java.util.HashMap;
import java.util.Map;

public class LongesstSubarrayWithSumK {
    public static void main(String[] args) {
        int[] arr = {10, 5, 2, 7, 1, 9};
        int k = 15;
        System.out.println(longestSubarrayWithSumK(arr, k));
    }

    public static int longestSubarrayWithSumK(int[] arr, int k){
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int maxLen = 0;
        int pSum = 0;
        for (int i = 0; i < arr.length; i++) {
            pSum = pSum + arr[i];
            int diff = pSum - k;
            if(map.containsKey(diff)){
                maxLen = Math.max(maxLen, i-map.get(diff));
            }
            if(!map.containsKey(pSum)){
                map.put(pSum, i);
            }
        }
        return maxLen;
    }
}
