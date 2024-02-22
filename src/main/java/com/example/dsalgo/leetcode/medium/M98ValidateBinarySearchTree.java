package com.example.dsalgo.leetcode.medium;

import com.example.dsalgo.leetcode.TreeNode;

/**
 * @author Hardeep Singh
 */
public class M98ValidateBinarySearchTree {
    public static void main(String[] args){
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(7);
        System.out.println(isValidBST(root));
    }
    public static boolean isValidBST(TreeNode root) {
        return false;
    }

}
