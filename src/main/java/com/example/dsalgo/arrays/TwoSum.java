package com.example.dsalgo.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] arr = {-11,2,3,4,5,6};
        System.out.println(Arrays.toString(twoSumBrute(arr, -6)));
        System.out.println(Arrays.toString(twoSumUsingHashMap(arr, -6)));
    }

    public static int[] twoSumBrute(int[] arr, int target){
        int[] ans = {-1,-1};
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++){
                if((arr[i] + arr[j]) == target){
                    ans[0] = arr[i];
                    ans[1] = arr[j];
                }
            }
        }
        return ans;
    }

    public static int[] twoSumUsingHashMap(int[] arr, int target){
        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = {-1, -1};
        for (int i = 0; i < arr.length; i++) {
            int diff = target - arr[i];
            if(map.containsKey(diff)){
                ans[0] = arr[map.get(diff)];
                ans[1] = arr[i];
                break;
            } else {
                map.put(arr[i], i);
            }
        }

        return ans;
    }
}
