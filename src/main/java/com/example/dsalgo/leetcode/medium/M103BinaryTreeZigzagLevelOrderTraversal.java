package com.example.dsalgo.leetcode.medium;

import com.example.dsalgo.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Hardeep Singh
 */
public class M103BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args){
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(1);
        root.right = new TreeNode(6);
        System.out.println(zigzagLevelOrder(root));
    }
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null){
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        int height = 1;
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()){
            TreeNode curr = queue.poll();
            if(curr == null){
                height++;
                if(height % 2 == 1){
                    List<Integer> evenHeightList = new ArrayList<>();
                    for(int i = list.size()-1; i>= 0; i--){
                        evenHeightList.add(list.get(i));
                    }
                    ans.add(new ArrayList<>(evenHeightList));
                } else {
                    ans.add(new ArrayList<>(list));
                }
                if(!queue.isEmpty()){
                    list.clear();
                    queue.add(null);
                } else {
                    break;
                }
            } else {
                list.add(curr.val);
                if(curr.left != null){
                    queue.add(curr.left);
                }
                if(curr.right != null){
                    queue.add(curr.right);
                }
            }
        }
        return ans;
    }
}
