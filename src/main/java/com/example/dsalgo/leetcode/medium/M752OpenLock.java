package com.example.dsalgo.leetcode.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class M752OpenLock {
    public static void main(String[] args) {
        String [] deadends = {"0201","0101","0102","1212","2002"};
        String target = "0202";
        System.out.println(openLock(deadends, target));
    }
    public static int openLock(String[] deadends, String target) {
        HashSet<String> dead_ends = new HashSet<>(Arrays.asList(deadends));
        HashSet<String> visited = new HashSet<>();
        visited.add("0000");
        int level = 0;
        Queue<String> queue = new LinkedList<>();
        queue.add("0000");

        while (!queue.isEmpty()){
            int size = queue.size();
            while (size > 0){
                String lockPos = queue.remove();
                if(lockPos.equals(target)){
                    return level;
                }
                if(dead_ends.contains(lockPos)){
                    size--;
                    continue;
                }
                for (int i = 0; i < 4; i++) {
                    char currPos = lockPos.charAt(i);
                    String s1 = lockPos.substring(0,i) + (currPos == '9' ? 0 : currPos - '0' + 1) + lockPos.substring(i+1);
                    String s2 = lockPos.substring(0,i) + (currPos == '0' ? 9 : currPos - '0' - 1) + lockPos.substring(i+1);

                    if(!visited.contains(s1)){
                        queue.add(s1);
                        visited.add(s1);
                    }
                    if(!visited.contains(s2)){
                        queue.add(s2);
                        visited.add(s2);
                    }
                }
                size--;
            }
            level++;
        }
        return -1;
    }
}
