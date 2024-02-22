package com.example.dsalgo.heap;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Hardeep Singh
 */
public class MaxHeap {
    public static void main(String[] args) {
        int[] maxHeapArr = {0, 50, 30, 40, 10, 5, 20, 30, 0};
        int n = 7;
        int value = 45;
        insert(maxHeapArr, n, value);
        System.out.println(Arrays.toString(maxHeapArr));
    }

    /**
     *
     * @param arr - array
     * @param n - size of array
     * @param value - value to insert in heap
     */
    public static void insert(int[] arr, int n, int value){
        n = n + 1;
        arr[n] = value;
        int i = n;
        while (i > 1){
            int parent = i / 2;
            if(arr[parent] < value){
                swap(arr, parent, i);
                i = parent;
            } else {
                return;
            }
        }
    }

    private static void swap(int[] arr, int parent, int i) {
        int temp = arr[parent];
        arr[parent] = arr[i];
        arr[i] = temp;
    }

    public static void deleteRootNode(int[] arr, int n){
        arr[1] = arr[n];
        n = n -1;
        int i = 1;
        while (i < n){
            int left = arr[2 * i];
            int right = arr [2* i + 1];
            int larger = left > right ? 2 * i : 2 * i +1;
            if(arr[i] < arr[larger]){
                swap(arr, larger, i);
                i = larger;
            } else {
                return;
            }
        }

    }
}
