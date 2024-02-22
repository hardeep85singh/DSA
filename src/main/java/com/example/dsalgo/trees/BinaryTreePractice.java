package com.example.dsalgo.trees;

import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author Hardeep Singh
 */
@Service
public class BinaryTreePractice {

    public static class Node{
        public int data;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int data) {
            this.data = data;
        }
    }

    Node root;

    public void binaryTreePractice(Node root){
        if(root == null){
            return;
        }
        List<Integer> list = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        int height = 1;
        while(!queue.isEmpty()){
            Node current = queue.poll();
            list.add(current.data);
            if(current == null){
                if(queue.isEmpty()){
                    break;
                } else {
                    height++;
                    queue.add(null);
                }
            } else {
                if(current.left != null){
                    queue.add(current.left);
                }
                if(current.right != null){
                    queue.add(current.right);
                }
            }

        }
    }
    public void preOrderTraversalRecursive(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data + "->");
        preOrderTraversalRecursive(root.left);
        preOrderTraversalRecursive(root.right);

    }

    public void inOrderTraversalRecursive(Node root){
        if(root == null){
            return;
        }
        inOrderTraversalRecursive(root.left);
        System.out.print(root.data + "->");
        inOrderTraversalRecursive(root.right);
    }

    public void postOrderTraversalRecursive(Node root){
        if(root == null){
            return;
        }
        postOrderTraversalRecursive(root.left);
        postOrderTraversalRecursive(root.right);
        System.out.print(root.data +  "->");
    }

    public void preOrderTraversalIterative(Node root){
        if (root == null){
            return;
        }
        List<Integer> list = new ArrayList<>();
        int height = 0;
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){
            Node current = stack.pop();
            list.add(current.data);
            if(current.right != null){
                stack.push(current.right);
            }
            if(current.left != null){
                stack.push(current.left);
            }
            if(stack.size() > height){
                height = stack.size();
            }
        }
        System.out.print("Preorder Tree traversal: ");
        for(int data : list){
            System.out.print(data + "->");
        }
        System.out.println();
        System.out.println("Height of tree: " + height);
    }

    public void inOrderTraversalIterative(Node root){
        if(root == null){
            return;
        }
        List<Integer> list = new ArrayList<>();
        int height = 0;
        Stack<Node> stack = new Stack<>();
//        stack.push(root);
        Node current = root;
        while(current != null || !stack.isEmpty()){
            while (current != null){
                stack.push(current);
                current = current.left;
            }
            if(stack.size() > height){
                height = stack.size();
            }
            current = stack.pop();
            list.add(current.data);
            current = current.right;
        }
        System.out.print("In Order Tree traversal: ");
        for(int data : list){
            System.out.print(data + "->");
        }
        System.out.println();
        System.out.println("Height of tree: " + height);
    }

    public void postOrderTraversalTwoStacksIterative(Node root){
        if (root == null){
            return;
        }
        int height = 0;
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        stack1.push(root);

        while(!stack1.isEmpty()){
            Node current = stack1.pop();
            stack2.push(current);

            if(current.left != null){
                stack1.push(current.left);
            }
            if(current.right != null){
                stack1.push(current.right);
            }
            if(stack1.size() > height){
                height = stack1.size();
            }
        }
        System.out.print("Post Order Traversal Tree: ");
        while(!stack2.isEmpty()){
            System.out.print(stack2.pop().data + "->");
        }
        System.out.println();
        System.out.println("Height of tree: " + height);
    }

    public void levelOrderTraversalIterative(Node root){
        if(root == null){
            return;
        }
        int height = 1;
        List<Integer> list = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while(!queue.isEmpty()){
            Node current = queue.poll();
            if(current == null){
                if(queue.isEmpty()){
                    break;
                } else{
                    height++;
                    queue.add(null);
                }
            } else {
                list.add(current.data);
                if(current.left != null){
                    queue.add(current.left);
                }
                if(current.right != null){
                    queue.add(current.right);
                }
            }


        }

        System.out.print("Level Order Tree traversal: ");
        for(int data : list){
            System.out.print(data + "->");
        }
        System.out.println();
        System.out.println("Height of tree: " + height);
    }

    public int heightOfTreeRecursive(Node root){
        if(root == null){
            return 0;
        } else {
            int heightLeft = heightOfTreeRecursive(root.left);
            int heightRight =  heightOfTreeRecursive(root.right);
            if(heightLeft > heightRight){
                return heightLeft + 1;
            } else {
                return heightRight + 1;
            }
        }
    }

    public int findMaxRecursive(Node root){
        if(root == null){
            return -1;
        }
        int leftMax = findMaxRecursive(root.left);
        int rightMax = findMaxRecursive(root.right);

        return Math.max(root.data, Math.max(leftMax, rightMax));
    }

    public boolean findElementRecursive(Node root, int data){
        if(root == null){
            return false;
        }
        if(root.data == data){
            return true;
        }
        return findElementRecursive(root.left, data) || findElementRecursive(root.right, data);
    }

    public int deepestNode(Node root){
        if(root == null){
            return -1;
        }
        // level, node
        Map<Integer, Node> map = new HashMap<>();

        int level = 1;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()){
            Node current = queue.poll();
            if(current == null){
                if(queue.isEmpty()){
                    break;
                } else {
                    level++;
                    queue.add(null);
                }
            } else {
                map.put(level, current);
                if(current.left != null){
                    queue.add(current.left);
                }
                if(current.right != null){
                    queue.add(current.right);
                }
            }
        }
        int maxLevel = 0;
        for(Map.Entry<Integer, Node> entry : map.entrySet()){{
            int value = entry.getKey();
            if (value > maxLevel){
                maxLevel = value;
            }
        }}
        return map.get(maxLevel).data;
    }

    public boolean areStructurallySame(Node root1, Node root2){
        if(root1 == null && root2 == null){
            return true;
        }
        if(root1 == null || root2 == null){
            return false;
        }
        return root1.data == root2.data &&
                areStructurallySame(root1.left, root2.left) &&
                areStructurallySame(root1.right, root2.right);
    }

    public void deleteNode(Node root, Node node){
        if(root == null){
            return;
        }
        Node temp = new Node();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Node current = null;
        while (!queue.isEmpty()){
            current = queue.poll();
            if(current.data == node.data){
                temp = current;
            }
            if(current.left!= null){
                queue.add(current.left);
            }
            if(current.right != null){
                queue.add(current.right);
            }
        }
        temp.data = current.data;
        current = null;
    }

    public Node mirrorTreeRecursive(Node root){
        if(root == null){
            return null;
        }
        Node left = mirrorTreeRecursive(root.left);
        Node right = mirrorTreeRecursive(root.right);

        root.left = right;
        root.right = left;
//        int temp = left.data;
//        left.data = right.data;
//        right.data = temp;
        return root;
    }

    public Node mirrorTree(Node root){
        if (root == null){
            return null;
        }
        List<Integer> list = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node current = queue.poll();
            list.add(current.data);
            Node temp = current.left;
            current.left = current.right;
            current.right = temp;

            if(current.left != null){
                queue.add(current.left);
            }
            if(current.right != null){
                queue.add(current.right);
            }

        }
        return root;
    }

    public static int preIndex = 0;
    public Node constructTreeWithInOrderPreOrder(int[] inOrder, int[] preOrder, int start, int end){
        // base cases
        if(start > end){
            return null;
        }
        Node node = new Node(preOrder[preIndex]);
        preIndex++;
        if(start == end){
            return node;
        }
        // first element of preOrder will be root of tree
        int rootData = preOrder[start];

        // find element in inOrder, left side will be left subtree, right side will be right subtree
        int index = searchRootIndex(inOrder, node.data, start, end);
        node.left = constructTreeWithInOrderPreOrder(inOrder, preOrder, start, index-1);
        node.right = constructTreeWithInOrderPreOrder(inOrder, preOrder, index+1, end);
        return node;
    }

    public int searchRootIndex(int[] inOrder, int rootData, int start, int end) {
        int result = -1;
        for (int i = start; i<= end; i++){
            if(inOrder[i] == rootData){
                result = i;
            }
        }
        return result;
    }

    public static int leftHeight = 0;
    public static int rightHeight = 0;
    public boolean isBalanced(Node root){
        if(root == null){
            return true;
        }
        boolean left = isBalanced(root.left);
        boolean right = isBalanced(root.right);
        leftHeight = heightOfTreeRecursive(root.left);
        rightHeight = heightOfTreeRecursive(root.right);
        if(Math.abs(leftHeight - rightHeight) >= 2){
            return false;
        } else {
            return left && right;
        }

    }

    public boolean checkForParentChildrenSum(Node root){
        int left = 0;
        int right = 0;
        if(root ==null || root.left == null && root.right == null){
            return true;
        } else {
            if(root.left != null){
                left = root.left.data;
            }
            if(root.right != null){
                right = root.right.data;
            }
            if((root.data == left + right)
                    && checkForParentChildrenSum(root.left) == true
                    && checkForParentChildrenSum(root.right) == true){
                return true;
            } else {
                return false;
            }
        }

    }

    // calculate height separately
    public int diameterTree(Node root){
        if(root == null){
            return 0;
        }
        int leftHeight = heightOfTreeRecursive(root.left);
        int rightHeight = heightOfTreeRecursive(root.right);
        int diaViaRoot = leftHeight + rightHeight + 1;

        int leftMaxDia = diameterTree(root.left);
        int rightMaxDia = diameterTree(root.right);
        return Math.max(diaViaRoot, Math.max(leftMaxDia, rightMaxDia));
    }

    class TreeDiaInfo{
        int dia;
        int height;

        public TreeDiaInfo() {
        }

        public TreeDiaInfo(int dia, int height) {
            this.dia = dia;
            this.height = height;
        }
    }
    // calculate height in single traversal
    public TreeDiaInfo diameterTreeSingleTraversal(Node root){
        if(root == null){
            return new TreeDiaInfo(0, 0);
        }
        TreeDiaInfo left = diameterTreeSingleTraversal(root.left);
        TreeDiaInfo right = diameterTreeSingleTraversal(root.right);
        int height = Math.max(left.height, right.height) + 1;
        int dia = Math.max((left.height + right.height + 1) ,Math.max(left.dia, right.dia));
        return new TreeDiaInfo(dia, height);
    }

    public boolean isSubTree(Node root, Node subRoot){
        if(subRoot == null){
            return true;
        }
        if(root == null){
            return false;
        }

        if(root.data == subRoot.data){
            if(areStructurallySame(root, subRoot)){
                return true;
            }
        }
        return isSubTree(root.left, subRoot) || isSubTree(root.right, subRoot);
    }

    private boolean isIdentical(Node root, Node subRoot) {
        if(root == null && subRoot == null){
            return true;
        }
        if(root == null || subRoot == null){
            return false;
        }
        if(root.data == subRoot.data){
            return isIdentical(root.left, subRoot.left) && isIdentical(root.right, subRoot.right);
        }
        return false;
    }

}
