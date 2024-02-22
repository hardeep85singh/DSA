package com.example.dsalgo.leetcode.easy;

import com.example.dsalgo.leetcode.TreeNode;

/**
 * @author Hardeep Singh
 */
public class E653TwoSumIVInputIsABST {
    public static void main(String[] args){
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        System.out.println(findNode(root, 7));
    }

    public static boolean findTarget(TreeNode root, int k) {
        if(root.val == k){
            return false;
        }
        int sum = k - root.val;
        if(sum <= root.val){
            // traverse left
            if(findNode(root.left, sum) == true){
                return true;
            } else {
                return findTarget2Trees(root.left, root.right, k);
            }
        } else {
            // traverse right;
            if(findNode(root.right, sum) == true){
                return true;
            } else {
                return findTarget2Trees(root.left, root.right, k);
            }
        }
    }

    private static boolean findTarget2Trees(TreeNode left, TreeNode right, int k) {
        if(left == null || right == null){
            return false;
        }
        if(left.val + right.val == k){
            return true;
        }
        return findTarget2Trees(left.left, right, k) || findTarget2Trees(left, right.right, k)
                || findTarget2Trees(left.left, right.left, k) || findTarget2Trees(left.right, right.right, k);
    }

    public static boolean findNode(TreeNode root, int val){
        if(root == null){
            return false;
        }
        if(root.val == val){
            return true;
        }
        if(val <= root.val){
            return findNode(root.left, val);
        } else {
            return findNode(root.right, val);
        }
    }
}
