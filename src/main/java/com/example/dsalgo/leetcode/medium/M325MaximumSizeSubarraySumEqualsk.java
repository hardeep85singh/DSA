package com.example.dsalgo.leetcode.medium;

import java.util.HashMap;

/**
 * @author Hardeep Singh
 */
public class M325MaximumSizeSubarraySumEqualsk {
    public static void main(String[] args) {
        int[] nums = {-2,-1,2,1};
        System.out.println(maxSubArrayLenHashMap(nums, 1));
    }

    // Brute T - N2
    public static int maxSubArrayLen(int[] nums, int k) {
        int ans = 0;
        for(int i = 0; i< nums.length; i++){
            int sum = 0;
            for (int j = i; j< nums.length; j++){
                sum = sum + nums[j];
                if(sum == k){
                    ans = Math.max(ans, j-i+1);
                }
            }
        }
        return ans;
    }

    public static int maxSubArrayLenHashMap(int[] nums, int k){
        int ans = 0;
        int prefixSum = 0;
        HashMap<Integer, Integer> indices = new HashMap<>();
        for(int i = 0; i< nums.length; i++){
            prefixSum = prefixSum + nums[i];

            if(prefixSum == k){
                ans = i +1;
            }
            if(indices.containsKey(prefixSum - k)){
                ans = Math.max(ans, i - indices.get(prefixSum-k));
            }

            if(!indices.containsKey(prefixSum)){
                indices.put(prefixSum, i);
            }
        }
        return ans;
    }
}
