package com.example.dsalgo.arrays;

import java.util.ArrayList;

public class AddOneToNumber {
    public static void main(String[] args) {
        int[] arr = {0, 0, 3, 7, 6, 4, 0, 5, 5, 5};
        System.out.println(plusOne(arrayToArrayList(arr)));
    }

    // 199
    // 002
    public static ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        ArrayList<Integer> ans = new ArrayList<>();
        int carry = 0;
        int sumDigit = A.get(A.size() - 1) + 1;
        if (A.size() == 1 && sumDigit < 10) {
            ans.add(sumDigit);
            return ans;
        }
        if (sumDigit > 9) {
            ans.add(0);
            carry = 1;
        } else {
            ans.add(sumDigit);
        }
        for (int i = A.size() - 2; i >= 0; i--) {
            if (carry >= 1) {
                sumDigit = A.get(i) + carry;
            } else {
                sumDigit = A.get(i);
            }
            if (sumDigit > 9) {
                ans.add(sumDigit % 10);
                carry = sumDigit % 9;
            } else {
                carry = 0;
                ans.add(sumDigit);
            }
        }
        if (carry == 1) {
            ans.add(1);
        }
        A.removeAll(A);
        int k = ans.size() - 1;
        while (ans.get(k) == 0) {
            ans.remove(k);
            k--;
        }
        for (int i = k; i >= 0; i--) {
            A.add(ans.get(i));
        }
        return A;
    }

    public ArrayList<Integer> plusOneProper(ArrayList<Integer> A) {

        int size;
        int carry = 1;
        int num;
        size = A.size();
        for (int i = size - 1; i >= 0; i--) {
            num = A.get(i);
            num += carry;
            carry = 0;
            if (num == 10) {
                num = 0;
                carry = 1;
            }
            A.set(i, num);
        }
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (carry == 1) {
            res.add(1);
        }
        for (int x : A) {
            if (x == 0 && res.size() == 0) {
                continue;
            }
            res.add(x);
        }
        return res;
    }


    public static ArrayList<Integer> arrayToArrayList(int[] arr) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int value : arr) {
            arrayList.add(value);
        }
        return arrayList;
    }
}
