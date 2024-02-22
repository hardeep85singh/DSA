package com.example.dsalgo.leetcode.easy;

import java.util.*;

/**
 * @author Hardeep Singh
 */

// Given a non-empty array of integers nums, every element appears twice except for one.
// Find that single one.
public class E136SingleNumber {
    public static void main(String[] args){
        int[] nums = {4, 4, 5, 3, 3};
        System.out.println(singleNumberBitOperator(nums));
    }

    public static int singleNumberHashmap(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() == 1){
                return entry.getKey();
            }
        }
        return -1;
    }

    public static int singleNumberMath(int[] nums){
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        for(int i = 0; i< nums.length; i++){
            sum = sum + nums[i];
            set.add(nums[i]);
        }
        int setSum = 0;
        for(Integer val : set){
            setSum = setSum + val;
        }
        return 2 * setSum - sum;
    }

    public static int singleNumberBitOperator(int[] nums){
        int a = 0;
        for(int i = 0; i< nums.length; i++){
            a = a ^ nums[i];
        }
        return a;
    }
}
