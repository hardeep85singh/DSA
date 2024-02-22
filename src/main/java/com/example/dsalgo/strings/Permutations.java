package com.example.dsalgo.strings;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
//        permutation("", "abc");
        System.out.println(permutationArray("", "abc"));
//        System.out.println(permutationCount("", "abcdef"));
    }

    public static void permutation(String ans, String str){
        if(str.length() == 0){
            System.out.println(ans);
            return;
        }
        char ch  = str.charAt(0);
        for (int i = 0; i<= ans.length(); i++){
            String f = ans.substring(0, i);
            String s = ans.substring(i, ans.length());
            permutation(f + ch + s, str.substring(1));
        }
    }

    public static ArrayList<String> permutationArray(String ans, String str){
        if(str.length() == 0){
            ArrayList<String> list = new ArrayList<>();
            list.add(ans);
            return list;
        }
        char ch  = str.charAt(0);
        ArrayList<String> outer = new ArrayList<>();
        for (int i = 0; i<= ans.length(); i++){
            String f = ans.substring(0, i);
            String s = ans.substring(i);
            ArrayList<String> list = permutationArray(f + ch + s, str.substring(1));
            outer.addAll(list);
        }
        return outer;
    }

    public static int permutationCount(String ans, String str){
        if(str.length() == 0){
//            int count = 1;
            return 1;
        }
        char ch  = str.charAt(0);
        int count = 0;
        for (int i = 0; i<= ans.length(); i++){
            String f = ans.substring(0, i);
            String s = ans.substring(i);
            int c = permutationCount(f + ch + s, str.substring(1));
            count = count + c;
        }
        return count;
    }

}
