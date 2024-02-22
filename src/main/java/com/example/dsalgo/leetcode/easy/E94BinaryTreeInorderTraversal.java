package com.example.dsalgo.leetcode.easy;

import com.example.dsalgo.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Hardeep Singh
 */
public class E94BinaryTreeInorderTraversal {
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right = new TreeNode(4);
        for(Integer val : inorderTraversalIterative(root)){
            System.out.print(val + "->");
        }
        System.out.println();
    }
    public static List<Integer> integerList = new ArrayList<>();
    public static List<Integer> inorderTraversal(TreeNode root) {
        if(root == null){
            return integerList;
        }
        inorderTraversal(root.left);
        integerList.add(root.val);
        inorderTraversal(root.right);
        return integerList;
    }

    public static List<Integer> inorderTraversalIterative(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while(curr != null || !stack.isEmpty()){
            while(curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            list.add(curr.val);
            curr = curr.right;
        }
        return list;
    }
}
