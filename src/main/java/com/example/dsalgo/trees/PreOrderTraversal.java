package com.example.dsalgo.trees;

import java.util.Stack;

public class PreOrderTraversal {
    public static void preOrderTraversalRecursive(TreeNode root){
        if(root == null){
            return;
        }
        System.out.print(root.val + "->");
        preOrderTraversalRecursive(root.left);
        preOrderTraversalRecursive(root.right);
    }

    public static void preOrderTraversal(TreeNode root){
        if (root == null){
            System.out.println("Tree is empty");
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        stack.push(current);
        while (!stack.isEmpty()){
            current = stack.pop();
            System.out.print(current.val + "->");
            if(current.right != null){
                stack.push(current.right);
            }
            if(current.left != null){
                stack.push(current.left);
            }
        }
    }
}
