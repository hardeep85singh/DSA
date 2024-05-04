package com.example.dsalgo.leetcode.easy;

import com.example.dsalgo.leetcode.TreeNode;

import java.util.*;

public class E111MinimumDepthOfBinaryTree {

    public static void main(String[] args) {

    }
    public static int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int height = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while(!queue.isEmpty()){
            TreeNode current = queue.poll();
            if(current == null){
                if(queue.isEmpty()){
                    break;
                } else{
                    height++;
                    queue.add(null);
                }
            } else {
                if(current.left != null){
                    queue.add(current.left);
                }
                if(current.right != null){
                    queue.add(current.right);
                }
                if(current.left == null && current.right == null){
                    return height;
                }
            }
        }
        return height;
    }
}
