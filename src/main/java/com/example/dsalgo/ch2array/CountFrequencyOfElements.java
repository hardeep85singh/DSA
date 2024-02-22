package com.example.dsalgo.ch2array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Hardeep Singh
 */
public class CountFrequencyOfElements {
    public static void main(String[] args){
        int[] nums = {1,1,1,1,4,4,5,5,3,3,3,3,13};
//        countFrequencyArray(nums);
//        countFrequencyHashmap(nums);
        countFrequencyNoAuxSpace(nums);
    }

    public static void countFrequencyArray(int[] nums){
        int n = nums.length;
        int[] aux = new int[n+1];

        for(int i = 0; i< n; i++){
            aux[(nums[i] % n)] = aux[(nums[i] % n)] + 1;
        }

        for(int i = 0; i < n; i++){
            System.out.println((i+1) +"->" +aux[i+1]);
        }
        System.out.println((n) +"->" +aux[0]);
    }

    public static void countFrequencyHashmap(int[] nums){
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i< n; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) +1);
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            System.out.println(entry.getKey() + "->" + entry.getValue());
        }
    }

    public static void countFrequencyNoAuxSpace(int[] nums){
        int n = nums.length;
        for(int i = 0; i< n; i++){
            nums[i] = nums[i] -1;
        }
        for(int i = 0; i< n; i++){
            nums[nums[i] % n] = nums[nums[i] % n] + n;
        }
        for(int i = 0; i< n; i++){
            System.out.println(i+1 + "->" +nums[i] / n);
        }
    }
}
