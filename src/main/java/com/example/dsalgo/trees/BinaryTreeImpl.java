package com.example.dsalgo.trees;

import java.util.Scanner;

public class BinaryTreeImpl {
    private TreeNode treeNode;
    private TreeNode root;

    public TreeNode populate(Scanner scanner){
        System.out.print("Enter the root node: ");
        int value = scanner.nextInt();
        root = new TreeNode(value);
        populate(scanner, root);
        return root;
    }

    private void populate(Scanner scanner, TreeNode node){
        System.out.print("Do you want to enter left of " + node.val + " (y/n): ");
        String yes = scanner.next();
        System.out.println();
        if(yes.equalsIgnoreCase("y")){
            System.out.print("Enter the value of the left of " + node.val+ " (y/n): ");
            int value = scanner.nextInt();
            node.left = new TreeNode(value);
            populate(scanner, node.left);
        }

        System.out.print("Do you want to enter right of " + node.val+ " (y/n): ");
        yes = scanner.next();
        System.out.println();
        if(yes.equalsIgnoreCase("y")){
            System.out.print("Enter the value of the right of " + node.val+ " (y/n): ");
            int value = scanner.nextInt();
            node.right = new TreeNode(value);
            populate(scanner, node.right);
        }
    }


}
