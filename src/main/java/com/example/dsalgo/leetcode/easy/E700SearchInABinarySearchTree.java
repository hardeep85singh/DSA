package com.example.dsalgo.leetcode.easy;

import com.example.dsalgo.leetcode.PrintTreeLevelOrder;
import com.example.dsalgo.leetcode.TreeNode;

import java.util.Stack;

/**
 * @author Hardeep Singh
 */
public class E700SearchInABinarySearchTree {
    public static void main(String[] args){
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(8);
        root.right = new TreeNode(11);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
//        PrintTreeLevelOrder.printTreeLevelOrder(root);

        PrintTreeLevelOrder.printTreeLevelOrder(searchBST(root, 8));
    }

    public static TreeNode searchBST(TreeNode root, int val) {
        if(root == null || root.val == val){
            return root;
        }
        if(val < root.val){
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
//        return val < root.val ? searchBST(root.left, val) : searchBST(root.right, val);
    }

    public static TreeNode searchBSTRecur(TreeNode root, int val){
        if(root == null || root.val == val){
            return root;
        }
        return null;
    }


    public static TreeNode searchBSTIterative(TreeNode root, int val){
        if(root == null){
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode curr;
        while(!stack.isEmpty()){
            curr = stack.pop();
            if(curr.val == val){
                return curr;
            }
            if(curr.right != null){
                stack.add(curr.right);
            }
            if(curr.left != null){
                stack.add(curr.left);
            }
        }
        return null;
    }
}
