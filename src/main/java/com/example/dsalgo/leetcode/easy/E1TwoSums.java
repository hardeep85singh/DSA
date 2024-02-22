package com.example.dsalgo.leetcode.easy;

import java.util.*;

/**
 * @author Hardeep Singh
 */
//Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
//You may assume that each input would have exactly one solution, and you may not use the same element twice.
public class E1TwoSums {

    public static void main(String[] args){
        int[] nums = {2,4,11,3};
        System.out.println(Arrays.toString(twoSumHashmapOnePass(nums, 6)));
    }

    public static int[] twoSum(int[] nums, int target) {
        int [] result = new int[2];

        for(int i = 0; i< nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                if((nums[i] + nums[j]) == target){
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }

    // Two pass
    public static int[] twoSumHashmap(int[] nums, int target){
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i< nums.length; i++){
            map.put(nums[i], i);
        }
        for(int i = 0; i < nums.length ; i++){
            int x = target - nums[i];
            if(map.containsKey(x) && map.get(x) != i){
                result[0] = i;
                result[1] = map.get(x);
            }
        }
        return result;
    }
    // One pass
    public static int[] twoSumHashmapOnePass(int[] nums, int target){

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i< nums.length; i++){
            int complement = target - nums[i];
            if(map.containsKey(complement) && map.get(complement) != i){
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }

        return null;
    }
}
