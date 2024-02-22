package com.example.dsalgo.leetcode.easy;

import com.example.dsalgo.leetcode.PrintTreeLevelOrder;
import com.example.dsalgo.leetcode.TreeNode;

import java.util.Stack;

/**
 * @author Hardeep Singh
 */
public class E112PathSum {
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        PrintTreeLevelOrder.printTreeLevelOrder(root);
        System.out.println(hasPathSum(root, 7));
    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }
        int sum = 0;
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> sumStack = new Stack<>();
        TreeNode curr = root;
        stack.add(curr);
        sumStack.add(targetSum - root.val);
        while (!stack.isEmpty()){
            curr = stack.pop();
            sum = sumStack.pop();
            if(curr.left == null && curr.right == null && sum == 0){
                return true;
            }
            if(curr.right != null){
                stack.add(curr.right);
                sumStack.add(sum - curr.right.val);
            }
            if(curr.left != null){
                stack.add(curr.left);
                sumStack.add(sum - curr.left.val);
            }
        }
        return false;
    }

    public static boolean hasPathSumRecursive(TreeNode root, int targetSum){
        if (root == null){
            return false;
        }
        targetSum = targetSum - root.val;
        if ((root.left == null) && (root.right == null)){
            return (targetSum == 0);
        }
        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
    }
}
