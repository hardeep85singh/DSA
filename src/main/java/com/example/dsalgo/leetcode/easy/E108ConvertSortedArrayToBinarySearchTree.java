package com.example.dsalgo.leetcode.easy;

import com.example.dsalgo.leetcode.PrintTreeLevelOrder;
import com.example.dsalgo.leetcode.TreeNode;

/**
 * @author Hardeep Singh
 */
public class E108ConvertSortedArrayToBinarySearchTree {

    public static void main(String[] args) {
        int [] nums = {1,2,3,4,5};
        PrintTreeLevelOrder.printTreeLevelOrder(sortedArrayToBST(nums));
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        return helper(0, nums.length-1, nums);
    }

    public static TreeNode helper(int left, int right, int[] nums){
        if(right < left){
            return null;
        }
        int mid = (left + right)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(left, mid-1, nums);
        root.right = helper(mid+1, right, nums);
        return root;
    }
}
