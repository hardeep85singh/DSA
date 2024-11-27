package com.example.dsalgo.patterns.slindingwindow;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class FindMaximumSlidingWindow {
    public static void main(String[] args) {
        int[] nums = {10,6,9,-3,23,-1,34,56,67,-1,-4,-8,-2,9,10,34,67}; // nums.length - w + 1
        int w = 3;
        System.out.println(Arrays.toString(findMaxSlidingWindow(nums, w)));
    }

    public static int[] findMaxSlidingWindow(int[] nums, int w) {

        int[] res = new int[nums.length - w + 1];
        Deque<Integer> deque = new LinkedList<>();
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            // Remove indices that are out of the bounds of the current window
            if (!deque.isEmpty() && deque.peekFirst() < i - w + 1) {
                deque.pollFirst();
            }

            // Remove elements from the deque that are smaller than the current element
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // Add the current element's index to the deque
            deque.addLast(i);

            // Start adding results to the list once the first window is processed
            if (i >= w - 1) {
                res[j] = nums[deque.peekFirst()];  // The front of the deque is the largest in the window
                j++;
            }
        }
        return res;
    }
}
