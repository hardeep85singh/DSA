package com.example.dsalgo.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hardeep Singh
 */
public class M763PartitionLabels {
    public static void main (String[] args){
        String s = "aebbedaddc";
        System.out.println(partitionLabelsSecond(s));
    }
    public static List<Integer> partitionLabels(String S) {
        int[] last = new int[26];
        for (int i = 0; i < S.length(); ++i)
            last[S.charAt(i) - 'a'] = i;

        int j = 0, anchor = 0;
        List<Integer> ans = new ArrayList();
        for (int i = 0; i < S.length(); ++i) {
            j = Math.max(j, last[S.charAt(i) - 'a']);
            if (i == j) {
                ans.add(i - anchor + 1);
                anchor = i + 1;
            }
        }
        return ans;
    }

    public static List<Integer> partitionLabelsSecond(String S){
        List<Integer> ans = new ArrayList<>();
        int anchor = 0;
        int i = 0;
        int j = S.length()-1;

        while (anchor < S.length()){
            int length = 1;
            while (i < j){
                if(S.charAt(i) != S.charAt(j)){
                    j--;
                } else {
                  length = Math.max(length, j- anchor +1);
                  i++;
                  j = S.length()-1;
                }
            }
            ans.add(length);
            anchor = anchor + length;
            i = anchor;
            j = S.length()-1;
        }
        return ans;
    }
}
