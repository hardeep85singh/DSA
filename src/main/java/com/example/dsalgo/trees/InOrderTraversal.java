package com.example.dsalgo.trees;

import java.util.Stack;

public class InOrderTraversal {
    public static void inOrderTraversalRecursive(TreeNode root){
        if (root == null){
            return;
        }
        inOrderTraversalRecursive(root.left);
        System.out.print(root.val + "->");
        inOrderTraversalRecursive(root.right);
    }

    public static void inOrderTraversal(TreeNode root){
        if(root == null){
            System.out.println("Tree is empty");
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()){
            while (current != null){
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            System.out.print(current.val + "->");
            current = current.right;
        }
    }
}
