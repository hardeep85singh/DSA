package com.example.dsalgo.leetcode.easy;

import com.example.dsalgo.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Hardeep Singh
 */
public class E145BinaryTreePostorderTraversal {
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right = new TreeNode(4);
        for(Integer val : postorderTraversalIterative(root)){
            System.out.print(val + "->");
        }
        System.out.println();
    }
    public static List<Integer> integerList = new ArrayList<>();
    public static List<Integer> postorderTraversal(TreeNode root) {
        if(root == null){
            return integerList;
        }
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        integerList.add(root.val);
        return integerList;
    }

    public static List<Integer> postorderTraversalIterative(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        TreeNode curr = root;
        while(!stack1.isEmpty()){
            curr = stack1.pop();
            stack2.push(curr);
            if(curr.left != null){
                stack1.push(curr.left);
            }
            if(curr.right != null){
                stack1.push(curr.right);
            }
        }
        while (!stack2.empty()){
            list.add(stack2.pop().val);
        }
        return list;
    }
}
