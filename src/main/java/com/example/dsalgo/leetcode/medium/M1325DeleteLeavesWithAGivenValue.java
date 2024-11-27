package com.example.dsalgo.leetcode.medium;

import com.example.dsalgo.leetcode.TreeNode;

public class M1325DeleteLeavesWithAGivenValue {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(2);
        TreeNode treeNode = removeLeafNodes(root, 2);
        System.out.println(treeNode.val);
        preOrder(treeNode);
    }

    public static TreeNode removeLeafNodes(TreeNode root, int target) {

        if(root == null){
            return null;
        }
        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);
        if (root.left == null && root.right == null && root.val == target){
            return null;
        } else {
            return root;
        }
    }

    private static void preOrder(TreeNode node){
        if(node == null){
            return;
        }
        preOrder(node.left);
        preOrder(node.right);
        System.out.println(node.val);
    }
}
