package com.example.dsalgo.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Hardeep Singh
 */
//@Service
public class BinarySearchTree {

    public static class Node{
        int data;
        Node left;
        Node right;

        public Node() {
        }

        public Node(int data) {
            this.data = data;
        }
    }

    Node root;

    public void insert(int data){
        if(root == null){
            root.data = data;
            return;
        }
        insertNode(root, data);
    }
    public Node insertNode(int data){
        Node temp = null;
        if(root == null){
            root.data = data;
            return root;
        }
        if(root.data >= data){
            if(root.left == null){
                root.left = new Node(data);
                return root.left;
            } else {
                root = root.left;
            }
        } else{
            if(root.right == null){
                root.right = new Node(data);
                return root.right;
            } else {
                root = root.right;
            }
        }
        return insertNode(data);
    }

    private Node insertNode(Node root, int data) {
        Node temp = null;

        if(root.data >= data){
            if(root.left == null){
                root.left = new Node(data);
                return root.left;
            } else {
                temp = root.left;
            }
        } else {
            if(root.right == null){
                root.right = new Node(data);
                return root.right;
            } else{
                temp = root.right;
            }
        }
        return insertNode(temp, data);
    }

    public Node delete(int data){
        if(root == null){
            return root;
        }
        return deleteNode(root, data);
    }

    private Node deleteNode(Node root, int data) {
        if(data < root.data){
           root.left = deleteNode(root.left, data);
        } else if(data > root.data){
           root.right = deleteNode(root.right, data);
        } else{
            if(root.left == null && root.right == null){
                return null;
            } else if(root.left == null){
                return root.right;
            } else if(root.right == null){
                return root.left;
            } else {
                int minValue = root.right.data;
                root.data = minValue;
                root.right = deleteNode(root.right, minValue);
            }
        }
        return root;
    }

    public Node delete1(Node root, int data){
        if(root == null){
            return null;
        } else if(data < root.data){
            root.left = delete1(root.left, data);
        } else if (data > root.data){
            root.right = delete1(root.right, data);
        } else {
            // Case 1: If there is no child
            if(root.left == null && root.right == null){
                return null;
            }
            // Case 2 : With one child
            else if(root.left == null){
                return root.right;
            } else if(root.right == null){
                return root.left;
            }
            // Case 3: with two children
            else {
                int minValue = root.right.data;
                root.data = minValue;
                root.right = delete1(root.right, minValue);
                // OR
//                int maxValue = root.left.data;
//                root.data = maxValue;
//                root.left = delete1(root.left, maxValue);
            }
        }
        return root;
    }

    boolean isBST()  {
        return isBSTUtil(root, Integer.MIN_VALUE,
                         Integer.MAX_VALUE);
    }

    private boolean isBSTUtil(Node root, int min, int max) {
        if(root == null){
            return true;
        }
        if(root.data < min || root.data > max){
            return false;
        }
        return (isBSTUtil(root.left, min, root.data-1) &&
                isBSTUtil(root.right, root.data+1, max));
    }

    public boolean isBSTWithNodes(Node root, Node left, Node right){
        if(root == null){
            return true;
        }

        if(left != null && left.data >= root.data){
            return false;
        }
        if(right != null && right.data <= root.data){
            return false;
        }

        return (isBSTWithNodes(root.left, left, root) &&
                isBSTWithNodes(root.right, root, right));
    }

    public boolean isBSTInOrderTraversal(Node root){
        if(root == null){
            return true;
        }
        Stack<Node> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        Node current = root;
        while(current != null || !stack.isEmpty()){
            while(current != null){
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            list.add(current.data);
            current = current.right;
        }
        int min = Integer.MIN_VALUE;
        boolean isBST = true;
        for(int data : list){
            if(data > min){
                min = data;
            } else {
                isBST = false;
            }
        }
        return isBST;
    }

    public Node sortedArrayToBST(int[] arr, int left, int right){
//        if(arr.length == 0){
//            return null;
//        }
//        Node root = new Node();
//        if(left == right){
//            root.data = arr[left];
//            return root;
//        }
//        while(left < right){
//            int mid = (right + left) /2 ;
//            root.data = arr[mid];
//            root.left = sortedArrayToBST(arr, left, mid-1);
//            root.right = sortedArrayToBST(arr, mid+1, right);
//        }
        if(left > right){
            return null;
        }
        int mid = (right + left) / 2;
        Node root = new Node(arr[mid]);
        root.left = sortedArrayToBST(arr, left, mid-1);
        root.right = sortedArrayToBST(arr, mid+1, right);
        return root;
    }

    public class LNode{
        int listData;
        LNode next;
        LNode previous;
        public LNode(){};
        public LNode(int listData){
            this.listData = listData;
            next = previous = null;
        }
    }
    public LNode head;
    // n is number of nodes in doubly linked list
    public Node sortedListToBST(int n){
        //base case
        if(n <= 0){
            return null;
        }
        Node left = sortedListToBST(n /2);
        Node root = new Node(head.listData);
        root.left = left;
        head = head.next;
        Node right = sortedListToBST(n - n/2 -1);
        return root;
    }
}
