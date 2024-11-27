package com.example.dsalgo.leetcode.hard;

import java.util.*;

public class H2751RobotCollisions {
    public static void main(String[] args) {
        int[] positions = {3,5,2,6};
        int[] healths = {10,10,15,12};
        String directions = "RLRL";
        System.out.println(survivedRobotsHealths(positions, healths, directions));
    }

    public static List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        List<Integer> ans = new ArrayList<>();
        Integer[] ids = new Integer[positions.length];
        for (int i = 0; i < ids.length; i++){
            ids[i] = i;
        }
        Arrays.sort(ids, Comparator.comparingInt(i -> positions[i]));
        Stack<Integer> stack = new Stack<>();
        for (int id : ids) {
            if(directions.charAt(id) == 'R'){
                stack.push(id);
            } else {
                while (!stack.isEmpty() && healths[id] > 0){
                    if(healths[id] > healths[stack.peek()]){
                        healths[id]--;
                        healths[stack.pop()] = 0;
//                        stack.pop();
                    } else if (healths[id] < healths[stack.peek()]){
                        healths[id] = 0;
                        healths[stack.peek()]--;
                    } else {
                        healths[id] = 0;
                        healths[stack.pop()] = 0;
//                        stack.pop();
                    }
                }
            }
        }
        for (int i = 0; i < healths.length; i++) {
            if(healths[i] > 0){
                ans.add(healths[i]);
            }
        }
        return ans;
    }
}
