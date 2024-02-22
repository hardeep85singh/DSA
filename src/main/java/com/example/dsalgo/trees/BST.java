package com.example.dsalgo.trees;

public class BST {
    private TreeNode root;

    public void insert(TreeNode node){
        root = insert(node.val, root);
    };

    public TreeNode insert(int value, TreeNode node){
        if(node == null){
            TreeNode newNode = new TreeNode(value);
            return newNode;
        }
        if(value < node.val){
            node.left = insert(value, node.left);
        }

        if(value > node.val){
            node.right = insert(value, node.right);
        }
        node.height = Math.max(root.height(node.left), root.height(node.right)) + 1;
        return node;
    }

}
