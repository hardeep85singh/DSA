package com.example.dsalgo.leetcode.easy;

import java.util.*;

/**
 * @author Hardeep Singh
 */

// The majority element is the element that appears more than ⌊n / 2⌋ times.
// You may assume that the majority element always exists in the array.
public class E169MajorityElement {
    public static void main(String[] args){
        int[] nums = {3, 4, 5, 3, 3};
        System.out.println(majorityElementMoore(nums));
    }

    public static int majorityElementHashmap(int[] nums) {
        int value = Integer.MAX_VALUE;
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i< nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if(map.get(nums[i]) > nums.length / 2){
                return nums[i];
            }
        }
        return -1;
    }

    public static int majorityElementBySorting(int[] nums){
        Arrays.sort(nums);
        int count = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i-1] == nums[i]){
                count ++;
            } else {
                count = 1;
            }
            if(count > nums.length / 2 ){
                return nums[i];
            }
        }
        return -1;
    }

    public static int majorityElementMoore(int[] nums){

        int majorityElement = nums[0];
        int i = 0;
        int j = 0;
        int count = 0;
        while (j < nums.length){
            if(nums[i] == nums[j]){
                count++;
                j++;
            } else{
                count--;
            }
            if(count <= 0){
                i++;
                majorityElement = nums[i];
            }
        }
        count = 0;
        for(i = 0; i< nums.length ; i++){
            if(nums[i] == majorityElement){
                count++;
            }
            if(count > nums.length /2){
                return majorityElement;
            }
        }
        return -1;
    }
}
