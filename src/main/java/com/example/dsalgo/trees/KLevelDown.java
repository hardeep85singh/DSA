package com.example.dsalgo.trees;

public class KLevelDown {
    public static void kLevelDown(TreeNode root, int target, int k){
        if(root == null){
            return;
        }
        if(root.val == target){
            printKLevelDown(root, k);
            return;
        }
        kLevelDown(root.left, target, k);
        kLevelDown(root.right, target, k);
    }

    private static void printKLevelDown(TreeNode node, int k) {
        if(node == null){
            return;
        }
        if(k == 0){
            System.out.print(node.val + " ");
        }
        printKLevelDown(node.left, k-1);
        printKLevelDown(node.right, k-1);
    }
}
