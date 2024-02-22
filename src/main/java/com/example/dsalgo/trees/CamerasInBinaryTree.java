package com.example.dsalgo.trees;

public class CamerasInBinaryTree {
    // need of camera return -1 (leaf nodes)
    // already covered return 0
    // camera installed return 1

    // find minimum cameras to cover all nodes
    public static int findCamerasInBinaryTree(TreeNode root){
        if (minCameras(root) == -1){
            cameras++;
        }
        System.out.println(cameras);
        return cameras;
    }
    private static int cameras = 0;

    private static int minCameras(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftAns = minCameras(root.left);
        int rightAns = minCameras(root.right);

        // if left or right child requires a camera
        if(leftAns == -1 || rightAns == -1){
            cameras++;
            return 1;
        }
        // if left of right child is having a camera we are covered
        if(leftAns == 1 || rightAns == 1){
            return 0;
        }
        return -1;
    }
}
