package com.example.dsalgo.strings;

import java.util.ArrayList;

public class SubsetsOfString {
    public static void main(String[] args) {
        String str = "abc";
//        subsets(str, "");
        System.out.println(subsetsReturnLocalArrayList(str, ""));
    }

    public static void subsets(String str, String ans){
        if(str.length() == 0){
            System.out.println(ans);
            return;
        }
        char ch = str.charAt(0);
        subsets(str.substring(1), ans + ch);
        subsets(str.substring(1), ans);
    }

    public static ArrayList<String> subsetsReturnLocalArrayList(String str, String ans){
        if(str.length() == 0){
            ArrayList<String> list = new ArrayList<>();
            list.add(ans);
            return list;
        }
        char ch = str.charAt(0);
        ArrayList<String> left = subsetsReturnLocalArrayList(str.substring(1), ans + ch);
        ArrayList<String> right = subsetsReturnLocalArrayList(str.substring(1), ans);

        left.addAll(right);
        return left;
    }
}
