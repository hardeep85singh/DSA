package com.example.dsalgo.bitmanipulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author Hardeep Singh
 */
// Given an array of integers A, every element appears twice except for one. Find that single one.
public class SingleNumberInArray {
    public static void main(String[] args) {
        int[] arr = {23,43,45,2,55,55,23,43,45};
        List<Integer> list = Arrays.asList(23,43,45,2,55,55,23,43,45);
        System.out.println(singleNumber(list));
        System.out.println(singleNumberBrute(list));
        System.out.println(singleNumberHashset(list));
    }

    // Bit masking, t -> o(n), s -> o(1)
    public static int singleNumber(List<Integer> list) {
        int ans = list.get(0);
        for(int i = 1; i < list.size(); i++){
            ans = ans ^ list.get(i);
        }
        return ans;
    }

    // bruteforce, t -> o(n2), s -> o(1)
    public static int singleNumberBrute(List<Integer> list){
        int ans = 0;
        for (int i = 0; i < list.size(); i++){
            for (int j = i + 1; j < list.size(); j++){
                if(list.get(i) == list.get(j)){
                    list.set(i, 0);
                    list.set(j, 0);
                }
            }
        }
        for (int i = 0; i < list.size(); i++){
            if(list.get(i) != 0){
                ans = list.get(i);
            }
        }
        return ans;
    }

    // Hashset, t -> o(n), s -> o(n)
    public static int singleNumberHashset(List<Integer> list){

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < list.size(); i++){
            if(set.contains(list.get(i))){
                set.remove(list.get(i));
            } else {
                set.add(list.get(i));
            }
        }
        return set.iterator().next();
    }

}
