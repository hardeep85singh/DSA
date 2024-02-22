package com.example.dsalgo.arrays;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OccurenceOfEachNumber {
    public static void main(String[] args) {
        int[] arr = {56, 35, 25, 32, 41, 50, 7, 52, 34, 41, 72, 12, 93, 50, 19, 94, 13, 19};
        ArrayList<Integer> A = arrayToArrayList(arr);
        System.out.println(findOccurences(A));
    }

    public static ArrayList<Integer> findOccurences(ArrayList<Integer> A) {
        A.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1 < o2){
                    return -1;
                } else if (o1.equals(o2)){
                    return 0;
                } else {
                    return 1;
                }
            }
        });
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: A) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Map<Integer, Integer> sortedMap = new TreeMap<>(map);
//        ArrayList<Integer> ans = new ArrayList<>(map.keySet());
        ArrayList<Integer> ans = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : sortedMap.entrySet()) {
            ans.add(entry.getValue());
        }
        return ans;
    }

    public static ArrayList<Integer> arrayToArrayList(int[] arr) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int value : arr) {
            arrayList.add(value);
        }
        return arrayList;
    }
}
