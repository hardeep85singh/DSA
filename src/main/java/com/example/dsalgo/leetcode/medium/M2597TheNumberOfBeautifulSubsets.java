package com.example.dsalgo.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class M2597TheNumberOfBeautifulSubsets {
    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(beautifulSubsets(nums, 1));
    }
    private static final int[] count = new int[1010]; // frequency array to keep track of elements in the subset
    private static int totalBeautifulSubsets = -1; // total count of beautiful subsets found

    // Method to find the count of beautiful subsets from a given array with respect to 'k'
    public static int beautifulSubsets(int[] nums, int k) {
        findBeautifulSubsets(nums, k, 0); // start the DFS with the first element in the array
        return totalBeautifulSubsets;
    }

    // Recursive method to perform DFS and find all subsets that are considered beautiful
    private static void findBeautifulSubsets(int[] nums, int k, int index) {
        // Base case: if we've considered all elements in 'nums'
        if (index >= nums.length) {
            totalBeautifulSubsets++; // we've formed a subset, increment the beautiful subsets count
            return;
        }
        // Option 1: Exclude the current element and explore further subsets
        findBeautifulSubsets(nums, k, index + 1);

        // Check if including nums[index] in the subset still keeps it beautiful
        boolean isBeautifulWithNext = nums[index] + k >= count.length || count[nums[index] + k] == 0;
        boolean isBeautifulWithPrevious = nums[index] - k < 0 || count[nums[index] - k] == 0;

        // If both checks pass, the subset remains beautiful with the inclusion of nums[index]
        if (isBeautifulWithNext && isBeautifulWithPrevious) {
            count[nums[index]]++; // include the current element by incrementing its frequency
            findBeautifulSubsets(nums, k, index + 1); // explore further subsets including this element
            count[nums[index]]--; // backtrack and exclude the current element
        }
    }
}
