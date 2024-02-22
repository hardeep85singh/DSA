package com.example.dsalgo.leetcode.medium;

import com.example.dsalgo.leetcode.TreeNode;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.management.Query;
import java.util.*;

/**
 * @author Hardeep Singh
 */
public class M199BinaryTreeRightSideView {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(1);
        root.right = new TreeNode(6);
        System.out.println(rightSideView(root));
    }

    public static List<Integer> rightSideView(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        Stack<Integer> stack = new Stack<>();
        while (!queue.isEmpty()){
            TreeNode curr = queue.poll();
            if(curr == null){
                list.add(stack.pop());
                stack.clear();
                if (!queue.isEmpty()){
                    queue.add(null);
                } else {
                    break;
                }
            } else{
                stack.add(curr.val);
                if(curr.left != null){
                    queue.add(curr.left);
                }
                if(curr.right != null){
                    queue.add(curr.right);
                }
            }

        }
        return list;
    }
    List<Integer> rightside = new ArrayList();

    public void helper(TreeNode node, int level) {
        if (level == rightside.size())
            rightside.add(node.val);

        if (node.right != null)
            helper(node.right, level + 1);
        if (node.left != null)
            helper(node.left, level + 1);
    }

    public List<Integer> rightSideViewDFS(TreeNode root) {
        if (root == null) return rightside;

        helper(root, 0);
        return rightside;
    }
}
