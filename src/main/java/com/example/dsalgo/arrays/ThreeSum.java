package com.example.dsalgo.arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ThreeSum {
    public static void main(String[] args) {

    }

    public static Set<int[]> threeSumBrute(int[] nums, int target){
        Set<int[]> ansSet = new HashSet<>();
        for (int i = 0; i< nums.length; i++){
            for (int j = i+1; j< nums.length; j++){
                for(int k = j+1; k< nums.length; k++){
                    if((nums[i] + nums[j] + nums[k]) == target){
                        int[] arr = {nums[i], nums[j], nums[k]};
                        ansSet.add(arr);
                    }
                }
            }
        }
        return ansSet;
    }
}
