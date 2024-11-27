package com.example.dsalgo.leetcode.easy;

import java.util.*;

public class E1122RelativeSortArray {
    public static void main(String[] args) {
        int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = {2,1,4,3,9,6};
        System.out.println(Arrays.toString(relativeSortArray(arr1, arr2)));
    }

    public static int[] relativeSortArray(int[] arr1, int[] arr2) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr2.length; i++) {
            map.put(arr2[i], i);
        }

        Integer[] arr1Integer = Arrays.stream(arr1).boxed().toArray(Integer[]::new);

        Arrays.sort(arr1Integer, (a, b) -> {
            int indexA = map.getOrDefault(a, arr2.length + a);
            int indexB = map.getOrDefault(b, arr2.length + b);
            return indexA - indexB;
        });

        return Arrays.stream(arr1Integer).mapToInt(Integer::intValue).toArray();
    }
}
