package com.example.dsalgo.binarysearch;

/**
 * @author Hardeep Singh
 * @since 05-09-2023
 */
public class InfiniteArray {
    public static void main(String[] args) {
        int[] nums = {-10, -5, 6, 8, 9, 13, 14, 15, 17, 19, 20, 22, 24, 25, 27};
        System.out.println(infiniteArray(nums, 27));
    }

    public static int infiniteArray(int[] nums, int target){
        int start = 0;
        int end = 1;
        int size = 2;
//        while (nums[end] < target){
//            start = end + 1;
//            size = 2 * size;
//            end = start + size;
//        }
//        return binarySearch(nums, target, start, end);
        // or
        int index = -1;
        while (index == -1){
            index = binarySearch(nums, target, start, end);
            if(index != -1){
                break;
            }
            start = end + 1;
            size = 2 * size;
            end = start + size;
        }
        return index;
    }
    public static int binarySearch(int[] nums, int target, int start, int end){
//        int start = 0;
//        int end = nums.length - 1;

        while (start <= end){
            int mid = start + (end - start) / 2; // due to integer overflow in java

            if(target < nums[mid]){
                end = mid - 1;
            } else if (target > nums[mid]){
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
