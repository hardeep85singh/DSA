package com.example.dsalgo.leetcode.easy;

import java.util.Arrays;

/**
 * @author Hardeep Singh
 */
public class E977SquaresOfASortedArray {
    public static void main(String [] args){
        int[] nums = {-4,-1,0,3,10};
//        System.out.println(Arrays.toString(sortedSquares(nums)));
        System.out.println(Arrays.toString(sortedSquaresLinear(nums)));
    }
    // Trivial approach by sorting / O(nlogn)
    public static int[] sortedSquares(int[] nums) {
        for (int i = 0; i< nums.length; i++){
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }

    // O(n) approach
    public static int[] sortedSquaresLinear(int[] nums){
        int negCount = 0;
        int posCount = 0;
        for (int i = 0; i< nums.length; i++){
            if(nums[i] <0){
                negCount++;
            } else {
                posCount++;
            }
        }
        int[] negArr = new int[negCount];
        int[] posArr = new int[posCount];

        int a = 0;
        int b = 0;
        for(int i = 0; i< nums.length; i++){
            if(nums[i] <0){
                negArr[negCount -1 -a] = nums[i] * -1;
                a++;
            }
            if(nums[i] >= 0) {
                posArr[b] = nums[i];
                b++;
            }
        }
        nums = mergeSortedArrays(negArr, posArr, nums);
        return nums;
    }

    private static int[] mergeSortedArrays(int[] negArr, int[] posArr, int[] nums) {
        int i =0, j =0, k=0;

        while (i < negArr.length && j < posArr.length){
            if(negArr[i] <= posArr[j]){
                nums[k] = negArr[i] * negArr[i];
                i++;
            } else{
                nums[k] = posArr[j] * posArr[j];
                j++;
            }
            k++;
        }
        while ( i < negArr.length){
            nums[k] = negArr[i] * negArr[i];
            i++;
            k++;
        }
        while (j < posArr.length){
            nums[k] = posArr[j] * posArr[j];
            j++;
            k++;
        }
        return nums;
    }
}
