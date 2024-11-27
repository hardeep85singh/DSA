package com.example.dsalgo.leetcode.medium;

import java.util.*;

public class M2191SorttheJumbledNumbers {
    public static void main(String[] args) {
        int[] mapping = {8,9,4,0,2,1,3,5,7,6};
        int[] nums = {991,338,38};

        Arrays.toString(sortJumbled(mapping, nums));
    }

    public static int[] sortJumbled(int[] mapping, int[] nums) {
        List<Integer> ans = new ArrayList<>();
        TreeMap<Integer, List<Integer>> mappedToOriginalNums = new TreeMap<>();

        for (int num : nums) {
            int mapped = getMapped(num, mapping);
            mappedToOriginalNums.putIfAbsent(mapped, new ArrayList<>());
            mappedToOriginalNums.get(mapped).add(num);
        }

        for (List<Integer> originalNums : mappedToOriginalNums.values()) {
            ans.addAll(originalNums);
        }

        return ans.stream().mapToInt(Integer::intValue).toArray();
    }


    private static int getMapped(int num, int[] mapping) {
        StringBuilder sb = new StringBuilder();
        for (char c : String.valueOf(num).toCharArray()) {
            sb.append(mapping[c - '0']);
        }
        return Integer.parseInt(sb.toString());
    }
}

