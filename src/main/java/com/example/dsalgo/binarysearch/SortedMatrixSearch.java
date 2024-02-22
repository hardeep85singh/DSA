package com.example.dsalgo.binarysearch;

public class SortedMatrixSearch {

    public static int findRow(int[][] a, int n, int m, int target) {
        int left = 0, right = n - 1, mid;
        while (left <= right) {
            mid = (left + right) / 2;

            // we'll check the left and  right most elements
            // of the row here itself  for efficiency
            // checking leftmost element
            if (target == a[mid][0]) {
                return 1;
            }

            // checking rightmost element
            if (target == a[mid][m - 1]) {
                int t = m - 1;
                return 1;
            }

            // this means the element must be within this row
            if (target > a[mid][0] && target < a[mid][m - 1]) {
                return binarySearch(a, n, m, target, mid); // we'll apply binary search on this row
            }

            if (target < a[mid][0]) {
                right = mid - 1;
            }
            if (target > a[mid][m - 1]) {
                left = mid + 1;
            }
        }
        return 0;
    }

    // x is the row number
    public static int binarySearch(int[][] a, int n, int m, int k, int x){
        int l = 0, r = m - 1, mid;
        while (l <= r) {
            mid = (l + r) / 2;
            if (a[x][mid] > k) {
                r = mid - 1;
            } else if (a[x][mid] < k) {
                l = mid + 1;
            } else {
                return 1;
            }
        }
        return 0;
    }

    // Driver Code
    public static void main(String args[]) {
        int n = 4; // no. of rows
        int m = 5; // no. of columns

        int a[][] = {{0, 6, 8, 9, 11},
                {20, 22, 28, 29, 31},
                {36, 38, 50, 61, 63},
                {64, 66, 100, 122, 128}};
        int r = a.length;
        int c = a[0].length;
        int k = 31; // element to search

        findRow(a, n, m, k);
    }

}
