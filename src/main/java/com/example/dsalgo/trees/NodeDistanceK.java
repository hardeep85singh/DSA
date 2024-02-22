package com.example.dsalgo.trees;

import java.util.ArrayList;
import java.util.Arrays;

public class NodeDistanceK {

    public static ArrayList<Integer> nodeDistanceK(TreeNode root, int target, int k) {
        findTargetNode(root, target, k);
        System.out.println(Arrays.toString(list.toArray()));
        return list;
    }

    private static ArrayList<Integer> list = new ArrayList<>();

    public static int findTargetNode(TreeNode node, int target, int k){
        if(node == null){
            return -1;
        }
        if(node.val == target){
            addNodeValueToList(node, k, null);
            return 1;
        }
        int leftAns = findTargetNode(node.left, target, k);
        if(leftAns != -1){
            addNodeValueToList(node, k-leftAns, node.left);
            return leftAns + 1;
        }
        int rightAns = findTargetNode(node.right, target, k);
        if(rightAns != -1){
            addNodeValueToList(node, k-rightAns, node.right);
            return rightAns + 1;
        }
        return -1;
    }

    private static void addNodeValueToList(TreeNode node, int k, TreeNode blocker){
        if(node == null || node == blocker){
            return;
        }
        if(k == 0){
            list.add(node.val);
        }
        addNodeValueToList(node.left, k-1, blocker);
        addNodeValueToList(node.right, k-1, blocker);
    }
}
