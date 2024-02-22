package com.example.dsalgo.leetcode.medium;

import com.example.dsalgo.leetcode.PrintTreeLevelOrder;
import com.example.dsalgo.leetcode.TreeNode;

/**
 * @author Hardeep Singh
 */
public class M105ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        PrintTreeLevelOrder.printTreeLevelOrder(buildTree(preorder, inorder));
    }
    static int preIndex = 0;
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildHelper(preorder, inorder, 0, preorder.length-1);
    }
    public static TreeNode buildHelper(int[] preorder, int[] inorder, int start, int end){
        if (start > end) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[preIndex]);
        preIndex++;
        if (start == end) {
            return node;
        }
        int searchIndex = findRootInOrder(inorder, node.val, start, end);

        node.left = buildHelper(preorder, inorder, start, searchIndex - 1);
        node.right = buildHelper(preorder, inorder, searchIndex + 1, end);
        return node;
    }

    private static int findRootInOrder(int[] inorder, int rootValue, int left, int right) {
        for(int i = left; i<= right; i++){
            if(rootValue == inorder[i]){
                return i;
            }
        }
        return -1;
    }
}
