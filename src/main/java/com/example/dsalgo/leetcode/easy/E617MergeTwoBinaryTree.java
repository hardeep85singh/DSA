package com.example.dsalgo.leetcode.easy;

import com.example.dsalgo.leetcode.PrintTreeLevelOrder;
import com.example.dsalgo.leetcode.TreeNode;

/**
 * @author Hardeep Singh
 */
public class E617MergeTwoBinaryTree {
    public static void main(String[] args){
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.left.left = new TreeNode(4);
        root2.right = new TreeNode(3);
        root2.right.right = new TreeNode(5);

        TreeNode node = mergeTrees(root1, root2);
        PrintTreeLevelOrder.printTreeLevelOrder(node);
    }

    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null){
            return root2;
        }
        if (root2 == null){
            return root1;
        }
        TreeNode node = new TreeNode(root1.val + root2.val);
        node.left = mergeTrees(root1.left, root2.left);
        node.right = mergeTrees(root1.right, root2.right);

        return node;
    }
}
