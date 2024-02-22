package com.example.dsalgo.bitmanipulation;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hardeep Singh
 */
public class ShowBits {

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
