package com.example.dsalgo.leetcode;

import org.springframework.beans.factory.annotation.Qualifier;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Hardeep Singh
 */
public class PrintTreeLevelOrder {

    public static void printTreeLevelOrder(TreeNode root){
        if(root == null){
            System.out.println("Tree is empty");
        }
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode curr = root;
        queue.add(curr);

        while(!queue.isEmpty()){
            curr = queue.poll();
            list.add(curr.val);

            if(curr.left != null){
                queue.add(curr.left);
            }
            if(curr.right != null){
                queue.add(curr.right);
            }
        }

        for(Integer val : list){
            System.out.print(val + "->");
        }
        System.out.println();
    }
}
