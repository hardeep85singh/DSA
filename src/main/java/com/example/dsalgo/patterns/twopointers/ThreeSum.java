package com.example.dsalgo.patterns.twopointers;

import java.util.Arrays;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {1,0,-1};
        System.out.println(threeSum(nums, -1));
    }

    private static boolean threeSum(int[] nums, int target){
        Arrays.sort(nums);
        int j, k, sum;
        for(int i = 0; i < nums.length -2 ; i++){
            j = i + 1; // not i++, it will increase i
            k = nums.length -1;
            while (j < k){
                sum = nums[i] + nums[j] + nums[k];
                if(sum == target){
                    return true;
                } else if(sum < target){
                    j++;
                } else{
                    k--;
                }
            }
        }
        return false;
    }
}
