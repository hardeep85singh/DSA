package com.example.dsalgo.hashmaps;

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveElements {
    public static void main(String[] args) {
        int[] nums = {5,4,3,1,6,2, 8,10,9, 14,17, 15, 16};
        System.out.println(longestConsecutiveElements(nums));
    }

    public static int longestConsecutiveElements(int[] nums){
        Map<Integer, Boolean> map = new HashMap<>();
        // put all elements in hashmap with possibility of every number
        // starts forming the longest consecutive element
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], true);
        }
        // check if some number is less than current number, so that possibility
        // of that number will be set to false
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i]-1)){
                map.put(nums[i], false);
            }
        }
        // check for max length
        int max = 1;
        for (int i = 0; i < nums.length; i++) {
            if(map.get(nums[i]) == true){
                int currLength = 1;
                int value = nums[i];
                while (map.containsKey(value + 1)){
                    currLength++;
                    value++;
                }
                max = Math.max(max, currLength);
            }
        }
        return max;
    }
}
