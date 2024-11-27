package com.example.dsalgo.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Hardeep Singh
 */
public class M78Subsets {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3};

        for (List<Integer> list : subSets(nums)) {
            System.out.println(Arrays.toString(list.toArray()));
        }
        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, 0, new ArrayList<>(), result);
        for (List<Integer> list : result) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }

    public static List<List<Integer>> subSets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        for (int i = 0; i < nums.length; i++) {
            int n = result.size();
            for (int j = 0; j < n; j++) {
                List<Integer> temp = new ArrayList<>(result.get(j));
                temp.add(nums[i]);
                result.add(temp);
            }
        }
        return result;
    }

    public static void dfs(int[] nums, int s, ArrayList<Integer> list, List<List<Integer>> result){
        result.add(new ArrayList<>(list));
        for (int i = s; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(nums, i + 1, list, result);
            list.remove(list.size() - 1);
        }
    }
}
