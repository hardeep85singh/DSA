package com.example.dsalgo.arrays;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = {1,3,2,3,3,3,3,4,5,6,3,2,2,3,3,2,2};
        System.out.println(majorityElementUsingHashmap(nums));
        System.out.println(majorityElementMooresLaw(nums));
    }

    public static int majorityElementUsingHashmap(int[] nums){
        int majorityElement = -1;
        Map<Integer, Integer> countMap = new HashMap<>();
        int length = (nums.length / 2) + 1;
        for (int i = 0; i < nums.length; i++) {
            if(countMap.containsKey(nums[i])){
                countMap.put(nums[i], countMap.get(nums[i]) + 1);
            } else {
                countMap.put(nums[i], 1);
            }
            if(countMap.get(nums[i]) >= length){
                majorityElement = nums[i];
                return majorityElement;
            }
        }
        return majorityElement;
    }

    public static int majorityElementMooresLaw(int[] nums){
        int contender = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] == contender){
                count ++;
            } else {
                count --;
            }
            if(count == 0){
                contender = nums[i];
                count = 1;
            }
        }
        count = 0;
        int majorityVotes = nums.length /2 + 1;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == contender){
                count++;
            }
            if(count >= majorityVotes){
                return contender;
            }
        }
        return -1;
    }
}
