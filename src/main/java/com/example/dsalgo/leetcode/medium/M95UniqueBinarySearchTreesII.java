package com.example.dsalgo.leetcode.medium;

import com.example.dsalgo.leetcode.PrintTreeLevelOrder;
import com.example.dsalgo.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hardeep Singh
 */
public class M95UniqueBinarySearchTreesII {
    public static void main(String[] args) {
        System.out.println(generateTrees(4));
        PrintTreeLevelOrder.printTreeLevelOrder(generateTrees(4).get(0));
    }

    public static List<TreeNode> generateTrees(int n) {
        int[] nums = new int[n];
        List<TreeNode> list = new ArrayList<>();
            
        return list;
    }

    private static int[] rotateArrayByOne(int[] nums) {
        int temp = nums[0];
        for(int i = 1; i< nums.length; i++){
            nums[i-1] = nums[i];
        }
        nums[nums.length-1] = temp;
        return nums;
    }

    private static void generateBST(TreeNode root, int num) {
        if (root == null) {
            root.val = num;
            return;
        }
        if (num <= root.val) {
            if (root.left == null) {
                root.left = new TreeNode(num);
                return;
            } else {
                root = root.left;
            }
        } else {
            if (root.right == null) {
                root.right = new TreeNode(num);
                return;
            } else {
                root = root.right;
            }
        }
        generateBST(root, num);
    }
}
