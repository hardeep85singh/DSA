package com.example.dsalgo.leetcode.easy;

import java.util.*;

/**
 * @author Hardeep Singh
 */
public class E217ContainsDuplicate {
    public static void main(String [] args){
        int [] nums = {1,2,3,4,1};
        System.out.println(containsDuplicateBrute(nums));
        System.out.println(containsDuplicateSorting(nums));
        System.out.println(containsDuplicateHashMap(nums));
        System.out.println(containsDuplicateSet(nums));
    }

//    Brute force
     public static boolean containsDuplicateBrute(int[] nums) {
         for(int i = 0; i< nums.length; i++){
             for(int j = i+1; j< nums.length; j++){
                 if(nums[i] ==  nums[j]){
                     return true;
                 }
             }
         }
         return false;
     }

//     by Sorting
     public static boolean containsDuplicateSorting(int[] nums){
         Arrays.sort(nums);

         for(int i = 0; i < nums.length-1; i++){
             if(nums[i] == nums[i+1]){
                 return true;
             }
         }
         return false;
     }

//     storing in HashMap
     public static boolean containsDuplicateHashMap(int[] nums){
         Map<Integer, Integer> map = new HashMap<>();

         for(int i = 0; i< nums.length; i++){
             if(map.containsKey(nums[i])){
                 map.put(nums[i], map.get(nums[i]) + 1);
             } else{
                 map.put(nums[i], 1);
             }
         }
         for(Map.Entry<Integer, Integer> entry : map.entrySet()){
             if(entry.getValue() >= 2){
                 return true;
             }
         }
         return false;
     }

    // using Set
    public static boolean containsDuplicateSet(int[] nums){
        Set<Integer> set = new HashSet<>(nums.length);
        for(int x : nums){
            if(set.contains(x)){
                return true;
            } else{
                set.add(x);
            }
        }
        return false;
    }

}
