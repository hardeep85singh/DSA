package com.example.dsalgo.leetcode.medium;

import com.example.dsalgo.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hardeep Singh
 */
public class M285InorderSuccessorInBST {
    public static void main(String[] args){
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(1);
        root.right = new TreeNode(6);
        System.out.println(inorderSuccessor(root, new TreeNode(3)).val);
    }
    private static TreeNode previous;
    private static TreeNode inorderSuccessorNode;
    public static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // Case 1: We simply need to find the leftmost node in the subtree rooted at p.right.
        if (p.right != null) {
            TreeNode leftmost = p.right;
            while (leftmost.left != null) {
                leftmost = leftmost.left;
            }
            inorderSuccessorNode = leftmost;
        } else {
            // Case 2: We need to perform the standard inorder traversal and keep track of the previous node.
            inorderCase2(root, p);
        }
        return inorderSuccessorNode;
    }
    private static void inorderCase2(TreeNode node, TreeNode p) {
        if (node == null) {
            return;
        }
        // Recurse on the left side
        inorderCase2(node.left, p);
        // Check if previous is the inorder predecessor of node
        if (previous == p && inorderSuccessorNode == null) {
            inorderSuccessorNode = node;
            return;
        }
        // Keeping previous up-to-date for further recursions
        previous = node;
        // Recurse on the right side
        inorderCase2(node.right, p);
    }

    // Inorder traversal way
    public static TreeNode inorderSuccessorByInOrderTraversal(TreeNode root, TreeNode p) {
        if(root == null){
            return null;
        }
        List<TreeNode> list = new ArrayList<>();
        inOrderTraversal(root, list);
        for(int i = 0; i < list.size()-1; i++){
            if(p.val == list.get(i).val){
                return list.get(i+1);
            }
        }
        return null;
    }

    private static void inOrderTraversal(TreeNode root, List<TreeNode> list) {
        if(root == null){
            return;
        }
        inOrderTraversal(root.left, list);
        list.add(root);
        inOrderTraversal(root.right, list);
    }
}
