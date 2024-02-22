package com.example.dsalgo.arrays;

import java.util.ArrayList;

public class CoverPoints {

    public static void main(String[] args) {
        int[] arrA = {0, 1, 1};
        int[] arrB = {0, 1, 2};
        System.out.println(coverPoints(arrayToArrayList(arrA), arrayToArrayList(arrB)));
    }

    public static int coverPoints(ArrayList<Integer> A, ArrayList<Integer> B) {
        int ans = 0;
        for (int i = 0; i < A.size() - 1; i++) {
            ans += Math.max(Math.abs(A.get(i + 1) - A.get(i)), Math.abs(B.get(i + 1) - B.get(i)));
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
