package com.example.dsalgo.leetcode.medium;

import com.example.dsalgo.leetcode.PrintTreeLevelOrder;
import com.example.dsalgo.leetcode.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class M2196CreateBinaryTreeFromDescriptions {
    public static void main(String[] args) {
        int[][] descriptions = {{20,15,1},{20,17,0},{50,20,1},{50,80,0},{80,19,1}};
        TreeNode root = createBinaryTree(descriptions);
        PrintTreeLevelOrder.printTreeLevelOrder(root);
    }

    public static TreeNode createBinaryTree(int[][] descriptions) {
        Map<TreeNode, TreeNode> childToParent = new HashMap<>();
        Map<Integer, TreeNode> valToNode = new HashMap<>();

        for (int[] d : descriptions){
            int p = d[0];
            int c = d[1];
            int isLeft = d[2];
            TreeNode parent = valToNode.getOrDefault(p, new TreeNode(p));
            TreeNode child = valToNode.getOrDefault(c, new TreeNode(c));
            valToNode.put(p, parent);
            valToNode.put(c, child);
            childToParent.put(child, parent);
            if(isLeft == 1){
                parent.left = child;
            } else {
                parent.right = child;
            }
        }

        TreeNode root = childToParent.keySet().iterator().next();
        while (childToParent.containsKey(root)){
            root = childToParent.get(root);
        }
        return root;
    }
}
