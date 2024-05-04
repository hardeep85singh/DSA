package com.example.dsalgo.leetcode.medium;

import java.util.Arrays;

public class M881BoatsToSavePeople {
    public static void main(String[] args) {
        int[] people = {3,2,2,1};
        System.out.println(numRescueBoats(people, 3));
    }
    public static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int light = 0;
        int heavy = people.length -1;
        int boats = 0;
        while (light <= heavy){
            // can we adjust light & heavy person on same boat
            if(people[light] + people[heavy] <= limit){
                light++;
            }
            // adjust only heavy person
            heavy--;
            boats++;
        }
        return boats;
    }
}
