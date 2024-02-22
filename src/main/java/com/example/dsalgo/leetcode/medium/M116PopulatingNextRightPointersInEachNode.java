package com.example.dsalgo.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Hardeep Singh
 */
public class M116PopulatingNextRightPointersInEachNode {

    public static void main(String[] args){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
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

    public static Node connectByPointers(Node root){
        if(root == null){
            return null;
        }
        Node leftMost = root;

        while (leftMost.left != null){
            Node head = leftMost;

            while (head != null){
                // connection 1
                head.left.next = head.right;

                // connection 2
                if(head.next != null){
                    head.right.next = head.next.left;
                }
                head = head.next;
            }
            leftMost = leftMost.left;
        }
        return root;
    }
}
