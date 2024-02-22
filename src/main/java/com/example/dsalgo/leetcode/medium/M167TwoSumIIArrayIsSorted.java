package com.example.dsalgo.leetcode.medium;

import java.util.Arrays;

/**
 * @author Hardeep Singh
 */
public class M167TwoSumIIArrayIsSorted {
    public static void main(String[] args){
        int[] numbers = {2,7,11,15};
//        System.out.println(Arrays.toString(twoSum(numbers, 13)));
        System.out.println(Arrays.toString(twoSumEffective(numbers, 13)));
    }

    public static int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];

        for(int i = 0; i< numbers.length; i++){
            for(int j = i+1; j< numbers.length; j++){
                if((numbers[i] + numbers[j]) == target){
                    result[0] = i+1;
                    result[1] = j+1;
                }
            }
        }
        return result;
    }

    public static int[] twoSumEffective(int[] numbers, int target){
        int [] result = new int[2];
        int i = 0;
        int j = numbers.length-1;
        while(i < j){
            if((numbers[i] + numbers[j]) == target){
                result[0] = i+1;
                result[1] = j+1;
                return result;
            } else if ((numbers[i] + numbers[j] > target)){
                j--;
            } else {
                i++;
            }
        }
        return result;
    }
}
