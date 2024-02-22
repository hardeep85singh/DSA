package com.example.dsalgo.leetcode.medium;

import com.example.dsalgo.leetcode.TreeNode;

/**
 * @author Hardeep Singh
 */
public class M236LowestCommonAncestorOfABinaryTree {
    public static void main(String[] args){
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(7);
        System.out.println(lowestCommonAncestor(root, root.left,root.left.left).val);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(isPresent(root.left, p.val) && isPresent(root.left, q.val)){
            return lowestCommonAncestor(root.left, p, q);
        } else if (isPresent(root.right, p.val) && isPresent(root.right, q.val)){
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }

    public static boolean isPresent(TreeNode root, int val){
        if(root == null){
            return false;
        }
        if(root.val == val){
            return true;
        }
        return isPresent(root.left, val) || isPresent(root.right, val);
    }
}
