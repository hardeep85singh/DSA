package com.example.dsalgo.leetcode.medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class M1190ReverseSubstringsBetweenEachPairOfParentheses {
    public static void main(String[] args) {
        String s = "(u(love)i)";
        System.out.println(reverseParentheses(s));
    }

    public static String reverseParentheses(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '('){
                count++;
            }
        }
        boolean toReverse = count % 2 == 1;

        String frontStr = "";
        String endStr = "";
        int i = 1;
        int j = s.length() - 2;
        while (i <= j){
            char front = s.charAt(i);
            char end = s.charAt(j);
            String fStr = "";
            String eStr = "";
            while (front != '(' && i <= j){
                fStr = fStr + front;
                i++;
                front = s.charAt(i);
            }
            i++;
            while (end != ')' && i <= j){
                eStr = eStr + end;
                j--;
                end = s.charAt(j);
            }
            j--;
            if(toReverse){
                fStr = reverse(fStr);
//                eStr = reverse(eStr);
                toReverse = false;
                frontStr = frontStr + eStr;
                endStr = fStr + endStr;
            } else {
                toReverse = true;
                frontStr = frontStr + fStr;
                endStr = eStr + endStr ;
            }

        }

        return frontStr + endStr;
    }

    private static String reverse(String s){
        String reversed = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            reversed += s.charAt(i);
        }
        return reversed;
    }

    public String reverseParenthesesStack(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (final char c : s.toCharArray())
            if (c == '(') {
                stack.push(sb.length());
            } else if (c == ')') {
                // Reverse the corresponding substring between ().
                StringBuilder reversed = new StringBuilder();
                for (int sz = sb.length() - stack.pop(); sz > 0; --sz) {
                    reversed.append(sb.charAt(sb.length() - 1));
                    sb.deleteCharAt(sb.length() - 1);
                }
                sb.append(reversed);
            } else {
                sb.append(c);
            }

        return sb.toString();
    }
}
