package com.example.dsalgo.trees;

public class PrintTree {

    public static void display(TreeNode root){
        display(root, 0);
    }
    private static void display(TreeNode node, int level){
        if(node == null){
            return;
        }
//        System.out.println(indent + node.val);
//        display(node.left, indent + "\t");
//        display(node.right, indent + "\t");
        display(node.right, level+1);
        if(level != 0){
            for (int i = 0; i < level -1 ; i++){
                System.out.print("|\t");
            }
            System.out.println("|--->" + node.val);
        } else {
            System.out.println(node.val);
        }
        display(node.left, level+1);
    }
}
