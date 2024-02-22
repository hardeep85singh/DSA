package com.example.dsalgo.leetcode.medium;

/**
 * @author Hardeep Singh
 */
public class M1060MissingElementInSortedArray {
    public static void main(String[] args) {
        int[] nums = {1,2,4};
        System.out.println(missingElement(nums, 3));
    }
    public static int missingElement(int[] nums, int k) {
        int res = nums[0]-1;
        int j=0;
        for(int i = 1; i< nums.length && j <k; i++){
            while(nums[i-1] != nums[i]-1 && j < k){
                j++;
                res = nums[i-1] +1;
                nums[i-1] = res;
            }
        }
        if(j < k){
            res = res +1;
        }

        while(j < k){
            res = res+1;
            j++;
        }
        return res;
    }
}
