package com.example.dsalgo.leetcode.medium;

import com.example.dsalgo.leetcode.TreeNode;

import java.util.List;
import java.util.Stack;

/**
 * @author Hardeep Singh
 */
public class M173BinarySearchTreeIterator {
    public static void main(String [] args){
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);
//        root.right = new TreeNode(6);
        M173BinarySearchTreeIterator iterator = new M173BinarySearchTreeIterator(root);
        System.out.print(next() + " ");
        System.out.print(next() + " ");
        System.out.print(hasNext() + " ");
        System.out.print(next() + " ");
        System.out.print(hasNext() + " ");
        System.out.print(next() + " ");
        System.out.print(hasNext() + " ");
        System.out.print(next() + " ");
        System.out.print(hasNext() + " ");
    }
    static List<Integer> list;
    static int index;

//    public M173BinarySearchTreeIterator(TreeNode root) {
//        if (root == null){
//            list = new ArrayList<>();
//        }
//        Stack<TreeNode> stack = new Stack<>();
//        TreeNode curr = root;
//        list = new ArrayList<>();
//        while(curr != null || !stack.isEmpty()){
//            while(curr != null){
//                stack.push(curr);
//                curr = curr.left;
//            }
//            curr = stack.pop();
//            list.add(curr.val);
//            curr = curr.right;
//        }
//        index = 0;
//    }
//
//    public static int next() {
//        int ans = list.get(index);
//        index ++;
//        return ans;
//    }
//
//    public static boolean hasNext() {
//        if(index != list.size()){
//            return true;
//        }
//        return false;
//    }

    static Stack<TreeNode> stack;

    public M173BinarySearchTreeIterator(TreeNode root) {
        // Stack for the recursion simulation
        stack = new Stack<TreeNode>();
        // Remember that the algorithm starts with a call to the helper function
        // with the root node as the input
        leftmostInorder(root);
    }

    private static void leftmostInorder(TreeNode root) {
        // For a given node, add all the elements in the leftmost branch of the tree
        // under it to the stack.
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    /**
     * @return the next smallest number
     */
    public static int next() {
        // Node at the top of the stack is the next smallest element
        TreeNode topmostNode = stack.pop();

        // Need to maintain the invariant. If the node has a right child, call the
        // helper function for the right child
        if (topmostNode.right != null) {
            leftmostInorder(topmostNode.right);
        }
        return topmostNode.val;
    }

    /**
     * @return whether we have a next smallest number
     */
    public static boolean hasNext() {
        return stack.size() > 0;
    }
}
