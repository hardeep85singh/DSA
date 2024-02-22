package com.example.dsalgo.trees;

import java.util.*;

public class LevelOrderTraversal {

    public static void levelOrderTraversal(TreeNode root){
        if(root == null){
            System.out.println("Tree is empty");
        }

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode curr;
        queue.add(root);
        while (!queue.isEmpty()){
            curr = queue.poll();
            System.out.print(curr.val + "->");
            if(curr.left != null){
                queue.add(curr.left);
            }
            if(curr.right != null){
                queue.add(curr.right);
            }
        }
    }

    public static void printLevelOrderForEachLevel(TreeNode root){
        if(root == null){
            System.out.println("Tree is empty");
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                System.out.print(current.val + " ");
                if(current.left != null){
                    queue.add(current.left);
                }
                if(current.right != null){
                    queue.add(current.right);
                }
            }
            System.out.println();
        }
    }

    public static ArrayList<ArrayList<Integer>> levelOrderArrayList(TreeNode A) {
        if(A == null){
            return new ArrayList<>();
        }
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(A);
        while(!queue.isEmpty()){
            int size = queue.size();
            ArrayList<Integer> subList = new ArrayList<>();
            for(int i = 0; i< size; i++){
                TreeNode curr = queue.poll();
                subList.add(curr.val);
                if(curr.left != null){
                    queue.add(curr.left);
                }
                if(curr.right != null){
                    queue.add(curr.right);
                }
            }
            ans.add(subList);
        }
        return ans;
    }
}
