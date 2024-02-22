package com.example.dsalgo.trees;

public class PathSum {

    static int maxSum;
    public static int maxSumFromRootToLeaf(TreeNode root, int sum){
        if(root == null){
            return 0;
        }
        sum = sum + root.val;
        if(root.left == null && root.right == null){
            maxSum = Math.max(maxSum, sum);
            return maxSum;
        }
        int left = maxSumFromRootToLeaf(root.left, sum);
        int right = maxSumFromRootToLeaf(root.right, sum);
        return Math.max(left, right);
    }

    public static boolean targetSumPresentFromRootToLeaf(TreeNode root, int targetSum){
        if(root == null){
            return false;
        }
        targetSum = targetSum - root.val;
        if(targetSum == 0 && root.left == null && root.right == null){
            return true;
        }
        return targetSumPresentFromRootToLeaf(root.left, targetSum) ||
                targetSumPresentFromRootToLeaf(root.right, targetSum);
    }

    private static int maximumPathSum = Integer.MIN_VALUE;
    public static int maximumPathSum(TreeNode root){
        helperMaximumPathSum(root);
        return maximumPathSum;
    }

    private static int helperMaximumPathSum(TreeNode node) {
        if(node == null){
            return 0;
        }

        int left = helperMaximumPathSum(node.left);
        int right = helperMaximumPathSum(node.right);
        int currSum = node.val + left + right;
        maximumPathSum = Math.max(currSum, maximumPathSum);
        return Math.max(left, right) + node.val;
    }

}
