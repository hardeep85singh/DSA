package com.example.dsalgo.strings;

import com.example.dsalgo.leetcode.TreeNode;

import java.util.*;

/**
 * @author Hardeep Singh
 */
public class TreeProblem {
    public static void main(String[] args) {


    }
    static String error1 = "E1";
    static String error2 = "E2";
    static String error3 = "E3";
    static String error4 = "E4";
    static String error5 = "E5";
    static TreeNode root;
    public String checkErrors(String str){

        Map<Character, List<Character>> map = new HashMap<>();

        char[] chars = str.toCharArray();
        if(chars.length % 5 != 0){
            return error1;
        }
        for(int i = 0; i < chars.length; i = i+5){
            if(chars[i+0] != '('){
                return error1;
            } else if(chars[i+4] != ')'){
                return error1;
            } else if(chars[i+2] != ','){
                return error1;
            } else {
                List<Character> list = new ArrayList<>();
                list.add(chars[i+3]);
                if(map.containsKey(chars[i+1])){
                    list.add(chars[i+3]);
                }
                map.put(chars[i+1], list);
            }
        }

        for(Map.Entry<Character, List<Character>> entry: map.entrySet() ){
            if(entry.getValue().size() > 2){
                return error3;
            } else {

                // build a binary tree & check for E4 and E5 errors
                insertNode(entry.getKey(), entry.getValue());
            }
        }

        return null;
    }

    private void insertNode(Character key, List<Character> list) {
        root = new TreeNode(key);
        if(list.size() == 2){
            root.left = new TreeNode(list.get(0));
            root.right = new TreeNode(list.get(1));
        } else if (list.size() == 1){
            root.left = new TreeNode(list.get(0));
        }
    }
}
