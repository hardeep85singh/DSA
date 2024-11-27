package com.example.dsalgo.leetcode.medium;

import com.example.dsalgo.leetcode.TreeNode;

public class M979DistributeCoinsInBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(0);
        root.right = new TreeNode(0);
        distributeCoins(root);
        System.out.println(steps);
    }

    private static int steps = 0;

    public static int distributeCoins(TreeNode root) {
        if(root == null){
            return 0;
        }

        int left = distributeCoins(root.left);
        int right = distributeCoins(root.right);
        steps = steps + Math.abs(left) + Math.abs(right);
        return (left + right + root.val -1);
    }
}
