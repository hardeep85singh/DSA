package com.example.dsalgo.hashmaps;

import java.util.HashMap;
import java.util.Map;

public class SubArrayWithSumK {
    public static void main(String[] args) {
        int[] arr = {9, 4, 20, 3, 10, 5};
        int k = 33;
        System.out.println(countSubArraysWithSumK(arr, k));
    }

    public static int countSubArraysWithSumK(int[] arr, int k){
        int[] prefixSumArr = new int[arr.length];
        prefixSumArr[0] = arr[0];
        for (int i = 1; i < prefixSumArr.length; i++) {
            prefixSumArr[i] = prefixSumArr[i-1] + arr[i];
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0;
        for (int i = 0; i < prefixSumArr.length; i++) {
            int diff = prefixSumArr[i] - k;
            if(map.containsKey(diff)){
                count = count + map.get(diff);
            }
            map.put(prefixSumArr[i], map.getOrDefault(prefixSumArr[i], 0) + 1);
        }
        return count;
    }
}
