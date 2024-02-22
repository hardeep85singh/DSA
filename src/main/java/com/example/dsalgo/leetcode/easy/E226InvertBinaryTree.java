package com.example.dsalgo.leetcode.easy;

import com.example.dsalgo.leetcode.PrintTreeLevelOrder;
import com.example.dsalgo.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Hardeep Singh
 */
public class E226InvertBinaryTree {
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        PrintTreeLevelOrder.printTreeLevelOrder(root);
        PrintTreeLevelOrder.printTreeLevelOrder(invertTreeIterative(root));
    }

    public static TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    public static TreeNode invertTreeIterative(TreeNode root){
        if(root == null){
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode curr = root;
        queue.add(curr);
        while (!queue.isEmpty()){
            curr = queue.poll();
            TreeNode temp = curr.left;
            curr.left = curr.right;
            curr.right = temp;
            if(curr.left != null){
                queue.add(curr.left);
            }
            if(curr.right != null){
                queue.add(curr.right);
            }
        }
        return root;
    }
}
