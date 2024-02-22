package com.example.dsalgo.leetcode.medium;

import com.example.dsalgo.leetcode.TreeNode;

import java.util.*;

/**
 * @author Hardeep Singh
 */
public class M102BinaryTreeLevelOrderTraversal {
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        List<List<Integer>> list = levelOrderIterative(root);
        for(List<Integer> entry: list){
            System.out.println(Arrays.toString(entry.toArray()));
        }
    }
    public static List<List<Integer>> levelOrderIterative(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> currList = new ArrayList<>();
        TreeNode curr = root;
        queue.add(curr);
        queue.add(null);
        while(!queue.isEmpty()){
            curr = queue.poll();
            if(curr == null){
                if(queue.isEmpty()){
                    result.add(currList);
                    break;
                } else {
                    queue.add(null);
                    result.add(currList);
                    currList = new ArrayList<>();
                }
            } else {
                currList.add(curr.val);
                if(curr.left != null){
                    queue.add(curr.left);
                }
                if(curr.right != null){
                    queue.add(curr.right);
                }
            }
        }
        return result;
    }

    public static List<List<Integer>> levels = new ArrayList<>();
    public static List<List<Integer>> levelOrderRecursive(TreeNode root){
        if(root == null){
            return levels;
        }
        helper(root, 0);
        return levels;
    }

    public static void helper(TreeNode node, int level){
        // start current level
        if(levels.size() == level){
            levels.add(new ArrayList<>());
        }
        // fill the current level
        levels.get(level).add(node.val);

        // process child nodes for next level
        if(node.left != null){
            helper(node.left, level+1);
        }
        if(node.right != null){
            helper(node.right, level + 1);
        }
    }
}
