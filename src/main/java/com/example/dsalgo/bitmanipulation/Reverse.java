package com.example.dsalgo.bitmanipulation;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hardeep Singh
 */
public class Reverse {
    public static void main(String[] args) {
        long num = 3;
        showBits(num); // just to show full bit sequence
        long ret = reverse(num);
        System.out.println("\nreverse of number " + num + " is=" + ret);
        showBits(ret);
        System.out.println("\n");
    }

    public static long reverse(long num){
        long ans = 0;
        for(int i = 0; i < 32; i++) {
            ans = ans << 1;
//            ans = ans | (num & 1);
            if((num & 1) > 0) {
                ans = ans ^ 1;
            }
            num = num >> 1;
        }
        return ans;
    }

    public static void showBits(long n) {
        List<Integer> l = new ArrayList<>();
        for(int i = 0; i< Integer.SIZE; i++) {

            if((n & 1) > 0) {
                l.add(1);
            } else {
                l.add(0);
            }
            n = n >> 1;
        }
        for(int i = l.size()-1; i >= 0; i--) {
            System.out.print(l.get(i) + ",");
        }
    }
}
