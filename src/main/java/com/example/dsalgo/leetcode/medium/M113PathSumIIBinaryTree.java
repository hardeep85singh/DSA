package com.example.dsalgo.leetcode.medium;

import com.example.dsalgo.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hardeep Singh
 */
public class M113PathSumIIBinaryTree {
    public static void main(String[] args){
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(1);
        root.right = new TreeNode(6);
        System.out.println(pathSum(root, 11));
    }

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        preOrderTraversal(root, list, ans, targetSum);
        return ans;
    }

    private static void preOrderTraversal(TreeNode root,
                                                         List<Integer> list,
                                                         List<List<Integer>> res,
                                                         int target) {
        if(root == null){
            return ;
        }
        list.add(root.val);
        if(root.left == null && root.right == null){
            int sum = 0;
            for(Integer data: list){
                sum = sum + data;
            }
            if(sum == target){
                res.add(new ArrayList<>(list));
            }
        } else {
            preOrderTraversal(root.left, list, res, target);
            preOrderTraversal(root.right, list, res, target);

        }
        list.remove(list.size()-1);
    }
}
