package com.example.dsalgo.trees;

public class ConnectNextNodeTree {

    // with using queue
    public TreeNode connect(TreeNode root){
        if(root == null){
            return null;
        }
        TreeNode leftMost = root;

        while (leftMost != null){
            TreeNode current = leftMost;
            while (current != null){
                current.left.next = current.right;
                if(current.right != null){
                    current.right.next = current.right.left;
                }
                current = current.next;
            }
            leftMost = leftMost.left;
        }
        return root;
    }
}
