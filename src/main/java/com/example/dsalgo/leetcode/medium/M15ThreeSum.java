package com.example.dsalgo.leetcode.medium;

import java.util.*;

/**
 * @author Hardeep Singh
 */

// Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
// such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
//Notice that the solution set must not contain duplicate triplets.
public class M15ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSumHashmap(nums));
    }
    // without sorting
    public static List<List<Integer>> threeSumHashmap(int[] nums){
        Set<List<Integer>> res = new HashSet<>();
        Set<Integer> dups = new HashSet<>();
        Map<Integer, Integer> seen = new HashMap<>();
        for(int i = 0; i< nums.length; i++){
            if(dups.add(nums[i])){
                for(int j = i+1; j< nums.length; j++){
                    int complement = - nums[j] - nums[i];
                    if(seen.containsKey(complement) && seen.get(complement) == i){
                        List<Integer> triplet = Arrays.asList(complement, nums[i], nums[j]);
                        Collections.sort(triplet);
                        res.add(triplet);
                    }
                    seen.put(nums[j], i);
                }
            }
        }
        return new ArrayList<>(res);
    }
    public static List<List<Integer>> threeSumSortingAndHashset(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < nums.length && nums[i] <= 0; i++){
            if(i== 0 || nums[i-1] != nums[i]){
                twoSumHashset(nums, i, res);
            }
        }
        return res;
    }

    private static void twoSumHashset(int[] nums, int i, List<List<Integer>> res) {
        HashSet<Integer> seen = new HashSet<>();
        for (int j = i + 1; j < nums.length; j++) {
            int complement = -nums[i] - nums[j];
            if (seen.contains(complement)) {
                res.add(Arrays.asList(nums[i], nums[j], complement));
                while (j + 1 < nums.length && nums[j] == nums[j + 1]) {
                    j++;
                }
            }
            seen.add(nums[j]);
        }
    }

    public static List<List<Integer>> threeSumSortingAnd2Pointers(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length && nums[i] <= 0; i++) {
            if (i == 0 || nums[i - 1] != nums[i]) {
                twoSumII(nums, i, res);
            }
        }
        return res;
    }

    public static void twoSumII(int[] nums, int i, List<List<Integer>> res) {
        int low = i +1;
        int high = nums.length -1;
        while (low < high) {
            int sum = nums[i] + nums[low] + nums[high];
            if(sum == 0){
                List<Integer> list = new ArrayList<>();
                list.add(nums[i]);
                list.add(nums[low]);
                list.add(nums[high]);
                res.add(list);
                low++;
                high--;
                while (low < high && nums[low] == nums[low-1]){
                    low++;
                }
            } else if (sum > 0){
                high--;
            } else {
                low++;
            }

        }
    }

    public static List<List<Integer>> threeSumBrute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                sum = sum + nums[j];
                for (int k = j + 1; k < nums.length; k++) {
                    sum = sum + nums[k];
                    if (sum == 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        result.add(list);
                    }
                    sum = sum - nums[k];
                }
                sum = sum - nums[j];
            }
            sum = sum - nums[i];
        }
        Set<List<Integer>> set = new HashSet<>();
        for (List<Integer> list : result) {
            set.add(list);
        }
        result = new ArrayList<>();
        for (List<Integer> s : set) {
            result.add(s);
        }
        return result;
    }
}
