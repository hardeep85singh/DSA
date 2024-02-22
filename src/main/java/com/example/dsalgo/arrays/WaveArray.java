package com.example.dsalgo.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class WaveArray {
    public static ArrayList<Integer> wave(ArrayList<Integer> A) {
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

        for (int i = 0; i < A.size() - 1; i += 2) {
            // Swap adjacent elements
            int temp = A.get(i+1);
            A.set(i+1, A.get(i));
            A.set(i, temp);
        }
        return A;
    }

    public static void main(String[] args) {
        // Example usage
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(5);
        A.add(-7);
        A.add(8);
        A.add(7);
        System.out.println("Wave-like array: " + wave(A));
    }
}

