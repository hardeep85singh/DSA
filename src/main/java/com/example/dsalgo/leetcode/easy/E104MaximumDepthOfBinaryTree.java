package com.example.dsalgo.leetcode.easy;

import com.example.dsalgo.leetcode.TreeNode;

import java.util.Arrays;
import java.util.List;

/**
 * @author Hardeep Singh
 */
public class E104MaximumDepthOfBinaryTree {
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(maxDepthRecursive(root));
    }

    public static int maxDepthRecursive(TreeNode root) {
        if(root == null){
            return 0;
        }
        int leftDepth = maxDepthRecursive(root.left);
        int rightDepth = maxDepthRecursive(root.right);

        return Math.max(leftDepth, rightDepth) + 1;
    }
}
