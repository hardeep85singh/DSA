package com.example.dsalgo.bitmanipulation;

import com.example.dsalgo.ch2array.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Hardeep Singh
 */
public class MinXor {
    public static void main(String[] args) {
        List<Integer> arrayList = Arrays.asList(5, 4, 7, 9);
        System.out.println(findMinXor(arrayList));
    }

    // Sorting, t -> o(nlogn), s -> o(1)
    public static int findMinXor(List<Integer> A){
        Collections.sort(A);
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < A.size()-1; i++){
            ans = Math.min(ans, A.get(i) ^ A.get(i+1));
        }
        return ans;
    }

    // brute force, t -> o(n2), s -> o(1)
    public static int findMinXorBrute(List<Integer> A) {
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < A.size() - 1; i++){
            for (int j = i + 1; j < A.size(); j++){
                int xor = A.get(i) ^ A.get(j);
                ans = Math.min(ans, xor);
            }
        }
        return ans;
    }
}
