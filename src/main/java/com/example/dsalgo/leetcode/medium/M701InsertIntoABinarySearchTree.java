package com.example.dsalgo.leetcode.medium;

import com.example.dsalgo.leetcode.TreeNode;

/**
 * @author Hardeep Singh
 */
public class M701InsertIntoABinarySearchTree {
    public static void main(String[] args){
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(8);
        root.right = new TreeNode(11);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

//        PrintTreeLevelOrder.printTreeLevelOrder((root, 2));
    }
    public static TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            root.val = val;
            return root;
        }
        return insertNode(root, val);
    }

    private static TreeNode insertNode(TreeNode root, int val) {
        TreeNode temp = null;
        if(root.val >= val){
            if(root.left == null){
                root.left = new TreeNode(val);
                return root.left;
            } else {
                temp = root.left;
            }
        } else {
            if(root.right == null){
                root.right = new TreeNode(val);
                return root.right;
            } else {
                temp = root.right;
            }
        }
        return insertNode(temp, val);
    }
}
