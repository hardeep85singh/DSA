package com.example.dsalgo.leetcode.easy;

import com.example.dsalgo.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Hardeep Singh
 */
public class E144BinaryTreePreorderTraversal {
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right = new TreeNode(4);
        for(Integer val : preorderTraversalIterative(root)){
            System.out.print(val + "->");
        }
        System.out.println();
    }
    public static List<Integer> integerList = new ArrayList<>();
    public static List<Integer> preorderTraversal(TreeNode root) {
        if(root == null){
            return integerList;
        }
        integerList.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return integerList;
    }

    public static List<Integer> preorderTraversalIterative(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode curr = root;
        while(!stack.isEmpty()){
            curr = stack.pop();
            list.add(curr.val);
            if(curr.right != null){
                stack.push(curr.right);
            }
            if(curr.left != null){
                stack.push(curr.left);
            }
        }
        return list;
    }
}
