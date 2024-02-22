package com.example.dsalgo.trees;

public class KDistanceAway {
    public static void kDistanceAway(TreeNode root, int target, int k){
        findTarget(root, target, k);
    }

    private static int findTarget(TreeNode node, int target, int k){
        if(node == null){
            return -1;
        }
        if(node.val == target){
            printKLevelDown(node, k,null);
            return 1;
        }

        int leftVal = findTarget(node.left, target, k);
        if(leftVal != -1){
            printKLevelDown(node, k-leftVal, node.left);
            return leftVal + 1;
        }
        int rightVal = findTarget(node.right, target, k);
        if(rightVal != -1){
            printKLevelDown(node, k-rightVal, node.right);
            return rightVal + 1;
        }

        return -1;
    }

    private static void printKLevelDown(TreeNode node, int k, TreeNode blocker){
        if(node == null || node == blocker){
            return;
        }
        if(k == 0){
            System.out.print(node.val + " ");
        }
        printKLevelDown(node.left, k-1, blocker);
        printKLevelDown(node.right, k-1, blocker);
    }
}
