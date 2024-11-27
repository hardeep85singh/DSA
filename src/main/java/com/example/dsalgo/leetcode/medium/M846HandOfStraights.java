package com.example.dsalgo.leetcode.medium;

import java.util.TreeMap;

public class M846HandOfStraights {
    public static void main(String[] args) {
        int[] hand = {1,1,2,3,2,3};
        int groupSize = 3;
        System.out.println(isNStraightHand(hand, groupSize));
    }

    public static boolean isNStraightHand(int[] hand, int groupSize) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < hand.length; i++) {
            treeMap.merge(hand[i], 1, Integer::sum);
        }

        for (int start : treeMap.keySet()) {
            int value = treeMap.getOrDefault(start, 0);
            if(value > 0){
                for (int i = start; i < start + groupSize; i++) {
//                    if(treeMap.containsKey(i)){
//                        treeMap.put(i, treeMap.get(i) - 1);
//                    } else {
//                        return false;
//                    }
                    if(treeMap.merge(i, -value, Integer::sum) < 0){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
