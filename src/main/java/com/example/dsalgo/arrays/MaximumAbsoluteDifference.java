package com.example.dsalgo.arrays;

import java.util.ArrayList;

public class MaximumAbsoluteDifference {
    public static void main(String[] args) {
        int[] arr = {1, 3, -1};
        ArrayList<Integer> list = ArrayToArrayList.arrayToArrayList(arr);
        System.out.println(maxArr(list));
    }
    // |A[i] - A[j]| + |i - j|
    /*
    Given A = [1, 3, -1],
    f(1, 1) = f(2, 2) = f(3, 3) = 0
    f(1, 2) = f(2, 1) = |1 - 3| + |1 - 2| = 3
    f(1, 3) = f(3, 1) = |1 - (-1)| + |1 - 3| = 4
    f(2, 3) = f(3, 2) = |3 - (-1)| + |2 - 3| = 5
    */
    public static int maxArr(ArrayList<Integer> A) {
        int n = A.size();

        int maxPlus = Integer.MIN_VALUE;
        int minPlus = Integer.MAX_VALUE;
        int maxMinus = Integer.MIN_VALUE;
        int minMinus = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            // Compute the values for maxPlus and minPlus
            maxPlus = Math.max(maxPlus, A.get(i) + i + 1);
            minPlus = Math.min(minPlus, A.get(i) + i + 1);

            // Compute the values for maxMinus and minMinus
            maxMinus = Math.max(maxMinus, A.get(i) - i - 1);
            minMinus = Math.min(minMinus, A.get(i) - i - 1);
        }

        // Calculate the maximum value of f(i, j)
        int option1 = maxPlus - minPlus;
        int option2 = maxMinus - minMinus;

        return Math.max(option1, option2);
    }
}
