package com.example.dsalgo.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hardeep Singh
 */
public class E119PascalsTriangleII {
    public static void main(String[] args) {

        System.out.print(String.valueOf(generate(3)));

    }

    public static List<Integer> generate(int numRows) {
        List<Integer> levelList = new ArrayList<>();
        levelList.add(1);
        for (int i = 1; i <= numRows; i++) {
            List<Integer> newLevelList = new ArrayList<>();
            for (int j = 0; j < levelList.size() + 1; j++) {
                if (j == 0) {
                    newLevelList.add(1);
                } else if (j < levelList.size()) {
                    int num = levelList.get(j - 1) + levelList.get(j);
                    newLevelList.add(num);
                } else if (j == levelList.size()) {
                    newLevelList.add(1);
                }
            }
            levelList = newLevelList;
        }
        return levelList;
    }
}
