package com.example.dsalgo.trees;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode next;
    public int height;

    public TreeNode(int val){
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public int height(TreeNode node){
        if (node == null){
            return -1;
        }
        return this.height;
    }

    public boolean isBalanced(TreeNode node){
        if(node == null){
            return true;
        }

        return Math.abs(height(node.left) - height(node.right)) >= 1
                && isBalanced(node.left)
                && isBalanced(node.right);
    }

}
