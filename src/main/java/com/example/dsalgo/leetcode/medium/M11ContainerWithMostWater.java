package com.example.dsalgo.leetcode.medium;

/**
 * @author Hardeep Singh
 */
public class M11ContainerWithMostWater {
    public static void main(String[] args) {
        int[] height = {1,2,1};
        System.out.println(maxAreaMaxNum(height));
    }

    public static int maxAreaBrute(int[] height) {
        int max = 0;
        int currArea = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                if (height[j] >= height[i]) {
                    currArea = height[i] * (j - i);
                } else {
                    currArea = height[j] * (j - i);
                }
                max = Math.max(max, currArea);
            }
        }
        return max;
    }

    public static int maxAreaMaxNum(int[] height) {
        int maxarea = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int width = right - left;
            maxarea = Math.max(maxarea, Math.min(height[left], height[right]) * width);
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxarea;
    }
}
