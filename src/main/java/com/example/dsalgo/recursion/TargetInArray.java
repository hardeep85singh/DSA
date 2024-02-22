package com.example.dsalgo.recursion;

import java.util.ArrayList;

/**
 * @author Hardeep Singh
 * @since 18-09-2023
 */
public class TargetInArray {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,4,8,9};
        System.out.println(findAllIndex(nums, 4, 0, new ArrayList<>()));
    }

    public static ArrayList<Integer> findAllIndex (int[] nums, int target, int index, ArrayList<Integer> list){
        if(index == nums.length){
            return list;
        }
        if(target == nums[index]){
            list.add(index);
        }
        return findAllIndex(nums, target, index+1, list);
    }
}
