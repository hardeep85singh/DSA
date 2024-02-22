package com.example.dsalgo.leetcode.easy;

import com.example.dsalgo.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Hardeep Singh
 */
public class E101SymmetricTree {
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

    }

    public static boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    public static boolean isMirror(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null){
            return true;
        }
        if(root1 == null || root2 == null){
            return false;
        }
        return root1.val == root2.val && isMirror(root1.left, root2.right) && isMirror(root1.right, root2.left);
    }

    public static boolean isSymmetricIterative(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode root1 = queue.poll();
            TreeNode root2 = queue.poll();
            if(root1 == null && root2 == null){
                continue;
            }
            if(root1 == null || root2 == null){
                return false;
            }
            if(root1.val != root2.val){
                return false;
            }
            queue.add(root1.left);
            queue.add(root2.right);
            queue.add(root1.right);
            queue.add(root2.left);
        }
        return true;
    }
}
