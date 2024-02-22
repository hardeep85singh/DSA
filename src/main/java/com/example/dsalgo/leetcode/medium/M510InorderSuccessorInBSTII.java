package com.example.dsalgo.leetcode.medium;

/**
 * @author Hardeep Singh
 */
public class M510InorderSuccessorInBSTII {
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
        Node (int val){
            this.val = val;
        }
    };
    public static void main(String[] args){
        Node root = new Node(5);
        root.left = new Node(3);
        root.left.right = new Node(4);
        root.left.left = new Node(2);
        root.left.left.left = new Node(1);
        root.right = new Node(6);
        Node node = new Node(3);
        System.out.println(inorderSuccessor(node).val);
    }

    public static Node inorderSuccessor(Node x) {
        // the successor is somewhere lower in the right subtree
        if (x.right != null) {
            x = x.right;
            while (x.left != null) {
                x = x.left;
            }
            return x;
        }

        // the successor is somewhere upper in the tree
        while (x.parent != null && x == x.parent.right){
            x = x.parent;
        }
        return x.parent;
    }

}
