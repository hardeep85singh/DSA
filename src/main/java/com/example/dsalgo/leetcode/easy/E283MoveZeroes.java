package com.example.dsalgo.leetcode.easy;

import java.util.Arrays;

/**
 * @author Hardeep Singh
 */
public class E283MoveZeroes {

    public static void main(String[] args) {
        int [] nums = {0,1,0,0,2,3,4};
        System.out.println(Arrays.toString(moveZeroesEfficient(nums)));

    }

    public static void moveZeroes(int[] nums) {
        int length = nums.length;
        int i = 0;
        int j = 1;
        while (j < length && i < length) {
            if (nums[0] == 0) {
                if (nums[j] == 0) {
                    j++;
                } else {
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
            } else {
                if (nums[j] != 0) {
                    int temp = nums[j];
                    nums[j] = nums[i + 1];
                    nums[i + 1] = temp;
                    i++;
                }
                j++;
            }
        }
    }

    public static int[] moveZeroesEfficient(int[] nums){
        int lastNonZero = 0;
        for (int curr = 0; curr< nums.length; curr++){
            if(nums[curr] != 0){
                int temp = nums[curr];
                nums[curr] = nums[lastNonZero];
                nums[lastNonZero] = temp;
                lastNonZero++;
            }
        }
        return nums;
    }
}
