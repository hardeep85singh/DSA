package com.example.dsalgo.leetcode.easy;

/**
 * @author Hardeep Singh
 */
public class E1588SumOfAllOddLengthSubarrays {
    public static void main(String[] args) {
        int[] nums = {1,4,2,5,3};
        System.out.println(sumOddLengthSubarraysBrute(nums));
    }

    public static int sumOddLengthSubarraysBrute(int[] arr) {
//        int totalOddLengthSum = 0;
//
//        for(int i = 0; i< arr.length; i++){
//            int sum = 0;
//            for (int j = i; j< arr.length; j++){
//                sum = sum + arr[j];
//                if((j-i) % 2 == 0){
//                    totalOddLengthSum = totalOddLengthSum + sum;
//                }
//            }
//        }
//        return totalOddLengthSum;
        int result = 0;
        int n = arr.length;
        for(int i=0; i<arr.length; i++){
            int end = i+1;
            int start = n-i;
            int total = start*end;
            int odd = total/2;
            if( total%2 == 1)
                odd++;
            result += odd * arr[i];
        }
        return result;
    }
}
