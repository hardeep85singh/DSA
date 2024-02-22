package com.example.dsalgo.arrays;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;

public class NobleInteger {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(-4);
        A.add(-2);
        A.add(0);
        A.add(-1);
        A.add(-6);
        System.out.println(solve(A));
    }
    public static int solve(ArrayList<Integer> A) {
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

        int count = 0;
        int p = 0;
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) == A.size() - i - 1 && (i == A.size() - 1 || A.get(i) != A.get(i + 1))) {
                return 1;
            }
        }
        return -1;
    }
}
