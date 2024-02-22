package com.example.dsalgo.leetcode.medium;

import java.util.HashMap;

/**
 * @author Hardeep Singh
 */
public class M560SubarraySumEqualsK {
    public static void main(String[] args) {

    }

    public int subarraySumBrute(int[] nums, int k) {
        int count = 0;
        for (int start = 0; start < nums.length; start++) {
            for (int end = start + 1; end <= nums.length; end++) {
                int sum = 0;
                for (int i = start; i < end; i++) {
                    sum = sum + nums[i];
                    if (sum == k) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public int subarraySumExtraSpace(int[] nums, int k) {
        int count = 0;
        int[] sum = new int[nums.length + 1];
        sum[0] = 0;
        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j <= nums.length; j++) {
                if (sum[j] - sum[i] == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public int subarraySumConstantSpace(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum = sum + nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public int subarraySumHashmap(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            if (map.containsKey(sum - k)) {
                count = count + map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public int subarraySumSlidingWindow(int[] nums, int k){
        int sum = 0;
        int i = 0;
        int j = 0;
        int count = 0;
        while (i < nums.length){
            while (j < nums.length && sum < k){
                sum = sum + nums[j];
                j++;
            }
            if(sum == k){
                count++;
            }
            sum = sum - nums[i];
            i++;
        }
        return count;
    }
}
