package com.example.dsalgo.trees;


import org.springframework.cache.annotation.Cacheable;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        BinaryTreeImpl binaryTreeImpl = new BinaryTreeImpl();
//        Scanner scanner = new Scanner(System.in);
//        TreeNode root = binaryTreeImpl.populate(scanner);
//        PrintTree.display(root);
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);
        System.out.println(PathSum.maxSumFromRootToLeaf(root, 0));
        System.out.println(PathSum.targetSumPresentFromRootToLeaf(root, 7));
        System.out.println(PathSum.maximumPathSum(root));

//        PreOrderTraversal.preOrderTraversalRecursive(root);
//        System.out.println();
//        PreOrderTraversal.preOrderTraversal(root);
//        System.out.println();
//        InOrderTraversal.inOrderTraversalRecursive(root);
//        System.out.println();
//        InOrderTraversal.inOrderTraversal(root);
//        System.out.println();
//        PostOrderTraversal.postOrderTraversalRecursive(root);
//        System.out.println();
//        PostOrderTraversal.postOrderTraversal(root);
//        System.out.println();
//        LevelOrderTraversal.levelOrderTraversal(root);
//        System.out.println();
//        LevelOrderTraversal.printLevelOrderForEachLevel(root);
//        System.out.println();
//        KLevelDown.kLevelDown(root, 2, 1);
//        System.out.println();
//        KDistanceAway.kDistanceAway(root, 4, 2);
//        CamerasInBinaryTree.findCamerasInBinaryTree(root);
//        NodeDistanceK.nodeDistanceK(root, 4, 2);
    }
}
