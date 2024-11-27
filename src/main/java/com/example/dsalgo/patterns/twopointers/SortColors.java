package com.example.dsalgo.patterns.twopointers;

import java.util.Arrays;

public class SortColors {

    public static void main(String[] args) {
        int[] colors = {2,0,1,0,0,2,1,1};
        System.out.println(Arrays.toString(sortColors(colors)));
    }

    public static int[] sortColors (int[] colors) {
        int start = 0;
        int current = 0;
        int end = colors.length - 1;
        while (current <= end){
            if(colors[current] == 0){
                swap(start, current, colors);
                start++;
                current++;
            } else if (colors[current] == 1) {
                current++;
            } else {
                swap(current, end, colors);
                end--;
            }
        }
        return colors;
    }

    private static int[] swap(int x, int y, int[] arr){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
        return arr;
    }
}
