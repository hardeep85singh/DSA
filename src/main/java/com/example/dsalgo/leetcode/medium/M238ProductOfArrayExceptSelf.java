package com.example.dsalgo.leetcode.medium;

import java.util.Arrays;

/**
 * @author Hardeep Singh
 */
public class M238ProductOfArrayExceptSelf {
    public static void main(String[] args){
        int[] nums = {1,2,3,4};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }
    public static int[] productExceptSelf(int[] nums) {
        int temp = 1;
        int[] product = new int[nums.length];
        for(int i = 0; i< nums.length; i++){
            product[i] = 1;
        }
        for(int i = 0; i< nums.length; i++){
            product[i] = temp;
            temp = temp * nums[i];
        }
        temp = 1;
        for(int i = nums.length-1; i>=0 ; i--){
            product[i] = product[i] * temp;
            temp = temp * nums[i];
        }
        return product;
    }
}
