package com.example.dsalgo.leetcode.medium;

import com.example.dsalgo.leetcode.TreeNode;

/**
 * @author Hardeep Singh
 */
public class M450DeleteNodeInABST {
    public static void main(String[] args){
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(1);
        root.right = new TreeNode(6);
        System.out.println(deleteNode(root, 3));
    }

    public static TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return null;
        }
        // search for key
        if(key < root.val){
            root.left = deleteNode(root.left, key);
        } else if(key > root.val){
            root.right = deleteNode(root.right, key);
        } else {
            // case 1 - leaf node
            if(root.left == null && root.right == null){
                return null;
            }
            // case 2 - single child
            if(root.left == null){
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // case 3 - parent node
            TreeNode IS = inOrderSuccessor(root.right);
            root.val = IS.val;
            root.right = deleteNode(root.right, IS.val);
        }
        return root;
    }

    public static TreeNode inOrderSuccessor(TreeNode node){
        while(node.left != null){
            node = node.left;
        }
        return node;
    }
}
