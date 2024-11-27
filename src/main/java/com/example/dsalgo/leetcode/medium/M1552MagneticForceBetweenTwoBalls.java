package com.example.dsalgo.leetcode.medium;

import java.util.Arrays;

public class M1552MagneticForceBetweenTwoBalls {
    public static void main(String[] args) {
        int[] position = {1,2,3,4,7};
        int m = 3;
        System.out.println(maxDistance(position, m));
    }
    public static int maxDistance(int[] position, int m) {
        Arrays.sort(position);

        int l = 1;
        int r = position[position.length - 1] - position[0];

        while (l < r) {
            int mid = r - (r - l) / 2;
            if (numBalls(position, mid) >= m) {// There're too many balls.
                l = mid;
            }
            else { // There're too few balls.
                r = mid - 1;
            }
        }

        return l;
    }

    private static int numBalls(int[] position, int force) {
        int balls = 0;
        int prevPosition = -force;
        for (int pos : position)
            if (pos - prevPosition >= force) {
                balls++;
                prevPosition = pos;
            }
        return balls;
    }
}
