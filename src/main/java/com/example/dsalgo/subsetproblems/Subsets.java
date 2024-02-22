package com.example.dsalgo.subsetproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Hardeep Singh
 */
public class Subsets {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        res.add(curr);
        subsetRecur(0, nums, res);
        for (List<Integer> list : res) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }

    public static List<List<Integer>> subsetsIterative(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            int n = list.size();
            for (int j = 0; j < n; j++) {
                List<Integer> temp = new ArrayList<>(list.get(j));
                temp.add(nums[i]);
                list.add(temp);
            }
        }
        return list;
    }

    public static List<List<Integer>> subsetsRecursive(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        int left = 0;
        int right = nums.length - 1;
//        result.add();
        return generateSubsets(left, right, nums, curr, result);
    }

    public static List<List<Integer>> generateSubsets(int left, int right, int[] nums, List<Integer> curr,
                                                      List<List<Integer>> res) {
        res.add(new ArrayList<>(curr));
        for (int i = left; i <= right; i++) {
            curr.add(nums[i]);
            generateSubsets(i + 1, right, nums, curr, res);
            curr.remove(curr.size() - 1);
        }
        return res;
    }

    public static void subsetRecur(int index, int[] nums, List<List<Integer>> res) {
        while (index < nums.length) {
            int currNum = nums[index];
            List<Integer> curr1 = new ArrayList<>();
            curr1 = res.get(index);
            curr1.add(currNum);
            res.add(curr1);
            subsetRecur(index + 1, nums, res);
            res.add(curr1);
            subsetRecur(index + 1, nums, res);
        }
    }

    public static List<List<Integer>> combinationRecursive(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        result.add(curr);
        int start = 1;
        generateCombinations(start, n, k, curr, result);
        return result;
    }

    private static void generateCombinations(int start, int n, int k, List<Integer> curr, List<List<Integer>> result) {
        if (result.size() == k) {
            result.add(new ArrayList<>(curr));
            return;
        }
        for (int i = start; i <= n; i++) {
            curr.add(i);
            generateCombinations(i + 1, n, k, curr, result);
            curr.remove(curr.size() - 1);
        }
    }

    public static List<List<Integer>> combinationIterative(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());
        for (int i = 1; i <= n; i++) {
            int length = result.size();
            for (int j = 0; j < length; j++) {
                List<Integer> temp = new ArrayList<>(list.get(j));
                temp.add(i);
                list.add(temp);
                if (temp.size() == k) {
                    result.add(temp);
                }
            }
        }
        return result;
    }

    public static List<List<Integer>> permutationsRecursive(int[] nums){
        return null;
    }
}
