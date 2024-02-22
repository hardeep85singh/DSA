package com.example.dsalgo.leetcode.medium;

import java.util.Arrays;

/**
 * @author Hardeep Singh
 */
public class M189RotateArray {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        // {5,6,7,4,3,2,1}
//        rotate(nums, 3);
//        rotate1(nums, 2);
        rotateUsingReverse(nums, 3);
        System.out.println(Arrays.toString(nums));
    }

    public static void rotate(int[] nums, int k) {

        for (int i = 0; i < k; i++) {
            int temp = nums[nums.length - 1];
            for (int j = nums.length - 1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = temp;
        }
    }

    public static void rotateBruteForce(int[] nums, int k){
        k = k % nums.length;
        int temp, previous;
        for (int i = 0; i < k; i++) {
            previous = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }
    }
    public static void rotateByExtraArray(int[] nums, int k){
        int[] a = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            a[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = a[i];
        }
    }

    public static void rotateByCyclicReplacements(int[] nums, int k){
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }

    public static void rotateUsingReverse(int[] nums, int k) {
        k = k % nums.length;
        reverseArray(nums, 0, nums.length - 1);
        reverseArray(nums, 0, k - 1);
        reverseArray(nums, k, nums.length - 1);
    }

    private static int[] reverseArray(int[] nums, int start, int end) {
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
        return nums;
    }

    public static void rotateArrayByExtraArr(int[] nums, int k) {
        if (k < nums.length) {
            int[] newArr = new int[k];

            for (int i = 0; i < k; i++) {
                newArr[i] = nums[nums.length - k + i];
            }
            for (int i = nums.length - 1; i >= k; i--) {
                nums[i] = nums[i - k];
            }
            for (int i = 0; i < k; i++) {
                nums[i] = newArr[i];
            }
        }
    }
}
