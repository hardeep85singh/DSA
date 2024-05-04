package com.example.dsalgo.leetcode.medium;

public class M165CompareVersionNumbers {
    public static void main(String[] args) {
        System.out.println(compareVersion("1.0", "1.0.0"));
    }
    public static int compareVersion(String version1, String version2) {
        String[] ver1Arr = version1.split("\\.");
        String[] ver2Arr = version2.split("\\.");
        int[] arr1 = new int[500];
        int[] arr2 = new int[500];
        for (int i = 0; i < ver1Arr.length; i++) {
            arr1[i] = Integer.parseInt(ver1Arr[i]);
        }
        for (int i = 0; i < ver2Arr.length; i++) {
            arr2[i] = Integer.parseInt(ver2Arr[i]);
        }

        for (int i = 0; i < 500; i++) {
            if(arr1[i] < arr2[i]){
                return -1;
            } else if (arr1[i] > arr2[i]){
                return 1;
            }
        }
        return 0;
    }
}
