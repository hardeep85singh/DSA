package com.example.dsalgo.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Hardeep Singh
 */
public class M117PopulatingNextRightPointersInEachNodeII {

    public static void main(String[] args){
        Node root = new Node(1);
//        root.left = new Node(2);
        root.right = new Node(3);
//        root.left.left = new Node(4);
//        root.left.right = new Node(5);
//        root.right.left = new Node(6);
        root.right.right = new Node(7);
        connectByPointers(root);
    }
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
    public static Node connect(Node root) {
        if(root == null){
            return null;
        }
        List<Integer> list = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        Node current = root;
        queue.add(current);
        queue.add(null);
        while (!queue.isEmpty()){
            current = queue.poll();

            if(current == null){
                list.add(0);
                if(!queue.isEmpty()){
                    queue.add(null);
                } else {
                    break;
                }
            } else {
                current.next = queue.peek();
                list.add(current.val);
                if(current.left != null){
                    queue.add(current.left);
                }
                if(current.right != null){
                    queue.add(current.right);
                }
            }
        }

        for(Integer val : list){
            System.out.print(val + "->");
        }
        return root;
    }

    static Node prev, leftmost;

    public static void processChild(Node childNode) {
        if (childNode != null) {
            // If the "prev" pointer is already set i.e. if we
            // already found atleast one node on the next level,
            // setup its next pointer
            if (prev != null) {
                prev.next = childNode;
            } else {
                // Else it means this child node is the first node
                // we have encountered on the next level, so, we
                // set the leftmost pointer
                leftmost = childNode;
            }
            prev = childNode;
        }
    }
    public static Node connectByPointers(Node root){
        if (root == null) {
            return root;
        }
        // The root node is the only node on the first level
        // and hence its the leftmost node for that level
        leftmost = root;

        // Variable to keep track of leading node on the "current" level
        Node curr = leftmost;

        // We have no idea about the structure of the tree,
        // so, we keep going until we do find the last level.
        // the nodes on the last level won't have any children
        while (leftmost != null) {
            // "prev" tracks the latest node on the "next" level
            // while "curr" tracks the latest node on the current
            // level.
            prev = null;
            curr = leftmost;

            // We reset this so that we can re-assign it to the leftmost
            // node of the next level. Also, if there isn't one, this
            // would help break us out of the outermost loop.
            leftmost = null;

            // Iterate on the nodes in the current level using
            // the next pointers already established.
            while (curr != null) {
                // Process both the children and update the prev
                // and leftmost pointers as necessary.
                processChild(curr.left);
                processChild(curr.right);
                // Move onto the next node.
                curr = curr.next;
            }
        }

        return root ;
    }
}
