package com.example.dsalgo.leetcode.medium;

import com.example.dsalgo.leetcode.PrintTreeLevelOrder;
import com.example.dsalgo.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class M1110DeleteNodesAndReturnForest {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        int[] to_delete = {3,5};

        for (TreeNode node : delNodes(root, to_delete)){
            PrintTreeLevelOrder.printTreeLevelOrder(node);
        }
    }

    public static List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> ans = new ArrayList<>();
        Set<Integer> toDeleteSet = Arrays.stream(to_delete).boxed().collect(Collectors.toSet());
        dfs(root, toDeleteSet, true, ans);
        return ans;
    }

    private static TreeNode dfs(TreeNode root, Set<Integer> toDeleteSet, boolean isRoot, List<TreeNode> ans) {
        if(root == null){
            return null;
        }
        boolean deleted = toDeleteSet.contains(root.val);
        if(isRoot && !deleted){
            ans.add(root);
        }
        // If root is deleted, both children have the possibility to be a new root
        root.left = dfs(root.left, toDeleteSet, deleted, ans);
        root.right = dfs(root.right, toDeleteSet, deleted, ans);
        return deleted ? null : root;
    }
}
