package com.example.dsalgo.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Hardeep Singh
 */
public class M77Combinations {
    public static void main(String[] args) {

        for (List<Integer> entry : combineLexicographicSortedOrder(4, 3)) {
            System.out.println(Arrays.toString(entry.toArray()));
        }
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        int index = 1;
        generateCombinations(index, n, k, curr, result);
        return result;
    }

    private static void generateCombinations(int index, int n, int k,
                                             List<Integer> curr, List<List<Integer>> result) {
        if (curr.size() == k) {
            result.add(new ArrayList<>(curr));
            return;
        }
        for (int i = index; i <= n; i++) {
            curr.add(i);
            generateCombinations(i + 1, n, k, curr, result);
            curr.remove(curr.size() - 1);
        }
    }

    public static List<List<Integer>> combineIterative(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int i = 1; i <= n; i++) {
            int length = result.size();
            for (int j = 0; j < length; j++) {
                List<Integer> temp = new ArrayList<>(result.get(j));
                temp.add(i);
                result.add(temp);
                if (temp.size() == k) {
                    list.add(temp);
                }
            }
        }
        return list;
    }

    public static List<List<Integer>> combineLexicographicSortedOrder(int n, int k) {
        // init first combination
        LinkedList<Integer> nums = new LinkedList<Integer>();
        for (int i = 1; i < k + 1; ++i) {
            nums.add(i);
        }
        nums.add(n + 1);
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        int j = 0;
        while (j < k) {
            // add current combination
            output.add(new LinkedList(nums.subList(0, k)));
            // increase first nums[j] by one
            // if nums[j] + 1 != nums[j + 1]
            j = 0;
            while ((j < k) && (nums.get(j + 1) == nums.get(j) + 1)) {
                nums.set(j, j + 1);
                j++;
            }
            nums.set(j, nums.get(j) + 1);
        }
        return output;
    }
}
