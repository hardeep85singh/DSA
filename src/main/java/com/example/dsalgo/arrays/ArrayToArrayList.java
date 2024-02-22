package com.example.dsalgo.arrays;

import java.util.ArrayList;

public class ArrayToArrayList {
    public static ArrayList<Integer> arrayToArrayList(int[] arr) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int value : arr) {
            arrayList.add(value);
        }
        return arrayList;
    }
}
