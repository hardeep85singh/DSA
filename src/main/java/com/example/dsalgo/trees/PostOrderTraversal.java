package com.example.dsalgo.trees;

import java.util.Stack;

public class PostOrderTraversal {
    public static void postOrderTraversalRecursive(TreeNode root){
        if (root == null){
            return;
        }
        postOrderTraversalRecursive(root.left);
        postOrderTraversalRecursive(root.right);
        System.out.print(root.val + "->");
    }

    public static void postOrderTraversal(TreeNode root){
        if(root == null){
            System.out.println("Tree is empty");
            return;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty()){
            TreeNode current = stack1.pop();
            stack2.push(current);
            if(current.left != null){
                stack1.push(current.left);
            }
            if(current.right != null){
                stack1.push(current.right);
            }
        }
        while(!stack2.isEmpty()){
            System.out.print(stack2.pop().val + "->");
        }
    }
}
