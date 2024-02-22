package com.example.dsalgo.leetcode.medium;

import com.example.dsalgo.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Hardeep Singh
 */
public class M230KthSmallestElementInABST {
    public static void main(String[] args){
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(1);
        root.right = new TreeNode(6);
        System.out.println(kthSmallest(root, 3));
    }
    public static int kthSmallest(TreeNode root, int k) {
        if(root ==  null){
            return 0;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        int count = 0;
        while(curr != null || !stack.isEmpty()){
            while(curr != null){
                stack.add(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            int val = curr.val;
            count++;
            if(count == k){
                return val;
            }
            curr = curr.right;
        }
        return 0;
    }
}
