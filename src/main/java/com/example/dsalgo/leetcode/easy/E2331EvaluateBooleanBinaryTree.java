package com.example.dsalgo.leetcode.easy;

import com.example.dsalgo.leetcode.TreeNode;

public class E2331EvaluateBooleanBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);

        System.out.println(evaluateTree(root));
    }

    public static boolean evaluateTree(TreeNode root) {
        if(root == null){
            return false;
        }
        boolean l = evaluateTree(root.left);
        boolean r = evaluateTree(root.right);

        if(root.left == null && root.right == null && root.val == 0){
            return false;
        } else if(root.left == null && root.right == null && root.val == 1){
            return true;
        } else if(root.left != null && root.right != null && root.val == 2){
            return l || r;
        } else {
            return l && r;
        }
    }
}
