package com.example.dsalgo.leetcode.easy;

/* Given an array of integers nums, calculate the pivot index of this array.
 The pivot index is the index where the sum of all the numbers strictly to the left of the index is equal to the sum of all the numbers strictly to the index's right.
 If the index is on the left edge of the array, then the left sum is 0 because there are no elements to the left. This also applies to the right edge of the array.
 Return the leftmost pivot index. If no such index exists, return -1.
 */
public class E724FindPivotIndex {
    public static void main(String[] args) {
        int[] nums = {1, 7, 3, 6, 5, 6};
        System.out.println(pivotIndex(nums));
    }

//    public static int pivotIndex(int[] nums) {
//        int sum = 0;
//        int leftsum = 0;
//        for (int x: nums) {
//            sum += x;
//        }
//        for (int i = 0; i < nums.length; ++i) {
//            if (leftsum == sum - leftsum - nums[i]) {
//                return i;
//            }
//            leftsum = leftsum + nums[i];
//        }
//        return -1;
//    }

    public static int pivotIndex(int[]  nums){
        int leftSum = 0;
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum = sum + nums[i];
        }
        for (int i = 0; i< nums.length; i++){
            if(leftSum == sum - leftSum - nums[i]){
                return i;
            }
            leftSum = leftSum + nums[i];
        }
        return -1;
    }
}
