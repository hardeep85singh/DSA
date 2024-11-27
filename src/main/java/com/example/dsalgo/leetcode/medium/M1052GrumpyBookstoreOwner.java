package com.example.dsalgo.leetcode.medium;

public class M1052GrumpyBookstoreOwner {
    public static void main(String[] args) {
        int[] customers = {1,0,1,2,1,1,7,5};
        int[] grumpy =    {0,1,0,1,0,1,0,1};
        int minutes = 3;
        System.out.println(maxSatisfied(customers, grumpy, minutes));
    }
    public static int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int satisfied = 0;
        int madeSatisfied = 0;
        int windowSatisfied = 0;

        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0) {
                satisfied = satisfied + customers[i];
            } else {
                windowSatisfied = windowSatisfied + customers[i];
            }
            if (i >= minutes && grumpy[i - minutes] == 1) {
                windowSatisfied = windowSatisfied - customers[i - minutes];
            }
            madeSatisfied = Math.max(madeSatisfied, windowSatisfied);
        }

        return satisfied + madeSatisfied;
    }
}
