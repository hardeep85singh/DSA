package com.example.dsalgo.leetcode.easy;

import com.example.dsalgo.leetcode.TreeNode;

/**
 * @author Hardeep Singh
 */
public class E235LowestCommonAncestorOfABinarySearchTree {
    public static void main(String[] args){
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        System.out.println(lowestCommonAncestor(root, root.left.right, root.right).val);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val < root.val && q.val < root.val){
            return lowestCommonAncestor(root.left, p, q);
        } else if(p.val > root.val && q.val > root.val){
            return lowestCommonAncestor(root.right, p, q);
        } else{
            return root;
        }
    }

    public static TreeNode lowestCommonAncestorIterative(TreeNode root, TreeNode p, TreeNode q) {

        TreeNode node = root;
        while (node != null){
            if(p.val < node.val && q.val < node.val){
                node = node.left;
            } else if(p.val > node.val && q.val > node.val){
                node = node.right;
            } else{
                return node;
            }
        }
        return null;
    }
}
