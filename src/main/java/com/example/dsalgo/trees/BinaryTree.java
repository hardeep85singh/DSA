package com.example.dsalgo.trees;

import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author Hardeep Singh
 */
@Service
public class BinaryTree {
    private static int size;

    public static class Node {
        public int data;
        public Node left;
        public Node right;
        public int hd;

        public Node() {
        }

        public Node(int data) {
            this.data = data;
        }

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    Node root;

    public void preOrderTraversalRecursive(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + "->");
        preOrderTraversalRecursive(root.left);
        preOrderTraversalRecursive(root.right);

    }

    public void inOrderTraversalRecursive(Node root) {
        if (root == null) {
            return;
        }
        inOrderTraversalRecursive(root.left);
        System.out.print(root.data + "->");
        inOrderTraversalRecursive(root.right);

    }

    public void postOrderTraversalRecursive(Node root) {
        if (root == null) {
            return;
        }
        postOrderTraversalRecursive(root.left);
        postOrderTraversalRecursive(root.right);
        System.out.print(root.data + "->");
    }

    public void preOrderTraversalNonRecursive(Node root) {
        List<Integer> nodeList = new ArrayList<>();
        if (root == null) {
            System.out.println("Tree is empty");
        }

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node currentNode = stack.pop();
            nodeList.add(currentNode.data);

            if (currentNode.right != null) {
                stack.push(currentNode.right);
            }

            if (currentNode.left != null) {
                stack.push(currentNode.left);
            }
        }
        for (int data : nodeList) {
            System.out.print(data + "->");
        }
    }

    public void inOrderTraversalNonRecursive(Node root) {
        if (root == null) {
            System.out.println("Tree is empty");
        }
        List<Integer> nodeList = new ArrayList<>();

        Stack<Node> stack = new Stack<>();
        Node currentNode = root;
        while (currentNode != null || !stack.isEmpty()) {
            while (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            }
            currentNode = stack.pop();
            nodeList.add(currentNode.data);
            currentNode = currentNode.right;
        }

//        boolean done = false;
//        while(!done){
//            if(currentNode != null){
//                stack.push(currentNode);
//                currentNode = currentNode.left;
//            } else{
//                if(stack.isEmpty()){
//                    done = true;
//                } else{
//                    currentNode = stack.pop();
//                    nodeList.add(currentNode.data);
//                    currentNode = currentNode.right;
//                }
//            }
//        }
        for (int data : nodeList) {
            System.out.print(data + "->");
        }
    }

    public void postOrderTraversalNonRecursive(Node root) {
        if (root == null) {
            System.out.print("Empty tree");
        }
        List<Integer> nodeList = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        Node previous = null;
        while (!stack.isEmpty()) {
            Node current = stack.peek();
            if (previous == null || previous.left == current || previous.right == current) {
                if (current.left != null) {
                    stack.push(current.left);
                } else if (current.right != null) {
                    stack.push(current.right);
                }
            } else if (current.left == previous) {
                if (current.right != null) {
                    stack.push(current.right);
                }
            } else {
                nodeList.add(current.data);
                stack.pop();
            }
            previous = current;
        }

//        Node current = root;
//        while(!stack.isEmpty() || current != null){
//            if(current != null){
//                stack.push(current);
//                current = current.left;
//            } else {
//                Node temp = stack.peek().right;
//                if(temp == null){
//                    temp = stack.pop();
//                    nodeList.add(temp.data);
//                    while(!stack.isEmpty() && temp == stack.peek().right){
//                        temp = stack.pop();
//                        nodeList.add(temp.data);
//                    }
//                } else {
//                    current = temp;
//                }
//            }
//        }


        for (int data : nodeList) {
            System.out.print(data + "->");
        }
    }

    public void levelOrderTraversal(Node root) {
        if (root == null) {
            System.out.print("Tree empty");
        }
        List<Integer> nodes = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            nodes.add(current.data);

            if (current.left != null) {
                queue.add(current.left);
            }

            if (current.right != null) {
                queue.add(current.right);
            }
        }
        for (int data : nodes) {
            System.out.print(data + "->");
        }
    }

    public int findMaximumRecursive(Node root) {
        int rootValue, left, right, max = Integer.MIN_VALUE;
        if (root != null) {
            rootValue = root.data;
            left = findMaximumRecursive(root.left);
            right = findMaximumRecursive(root.right);
            if (left > right) {
                max = left;
            } else {
                max = right;
            }

            if (rootValue > max) {
                max = rootValue;
            }
        }
        return max;
    }

    public int findMaxNonRecursive(Node root) {
        if (root == null) {
            throw new IllegalArgumentException("No element present in Tree");
        }
        int max = Integer.MIN_VALUE;
        List<Integer> nodeList = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current.data > max) {
                max = current.data;
            }
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
        return max;
    }

    public boolean findElementRecursive(Node root, int value) {
        if (root == null) {
            return false;
        }
        if (root.data == value) {
            return true;
        }
        return findElementRecursive(root.left, value) || findElementRecursive(root.right, value);
    }

    public boolean findElementLevelOrderNonRecursive(Node root, int value) {
        if (root == null) {
            return false;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current.data == value) {
                return true;
            }
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
        return false;
    }

    public int heightOfTreeRecursive(Node root) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = heightOfTreeRecursive(root.left);
            int rightHeight = heightOfTreeRecursive(root.right);
            if (leftHeight > rightHeight) {
                return leftHeight + 1;
            } else {
                return rightHeight + 1;
            }
        }
    }

    public int heightOfTreeUsingStack(Node root) {
        if (root == null) {
            return 0;
        }
        int depth = 0;
        List<Integer> list = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        Node previous = null;
        while (!stack.isEmpty()) {
            Node current = stack.peek();
            if (previous == null || previous.left == current || previous.right == current) {
                if (current.left != null) {
                    stack.push(current.left);
                } else if (current.right != null) {
                    stack.push(current.right);
                }
            } else if (current.left == previous) {
                if (current.right != null) {
                    stack.push(current.right);
                }
            } else {
                stack.pop();
                list.add(current.data);
            }
            previous = current;
            if (stack.size() > depth) {
                depth = stack.size();
            }
        }

//        Node current = root;
//        while(!stack.isEmpty() || current != null){
//            if(current != null){
//                stack.push(current);
//                current = current.left;
//                if(stack.size() > depth){
//                    depth = stack.size();
//                }
//            } else {
//                Node temp = stack.peek().right;
//                if(temp == null){
//                    temp = stack.pop();
//                    while(!stack.isEmpty() && temp == stack.peek().right){
//                        temp = stack.pop();
//                    }
//                } else {
//                    current = temp;
//                }
//            }
//        }
        System.out.println(depth);
        return depth;
    }

    public int heightOfTreeUsingLevelOrder(Node root) {
        if (root == null) {
            return 0;
        }
        int depth = 1;
        Queue<Node> queue = new LinkedList<>();
        Node current = root;
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()) {
            current = queue.poll();
            if (current == null) {
                if (queue.isEmpty()) {
                    break;
                } else {
                    depth++;
                    queue.add(null);
                }

            } else {
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
        }
        System.out.print(depth);
        return depth;
    }

    public void printLevelOrderNodesRecursive(Node root, int level) {
        if (level == 0) {
            return;
        }
        if (level == 1) {
            System.out.print(root.data + "->");
        } else if (level > 1) {
            printLevelOrderNodesRecursive(root.left, level - 1);
            printLevelOrderNodesRecursive(root.right, level - 1);
        }
    }

    public void insertElementLevelOrder(Node root, Node insertNode) {
        if (root == null) {
            root = insertNode;
            root.right = null;
            root.left = null;
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.left != null) {
                queue.add(current.left);
            } else {
                current.left = insertNode;
                return;
            }
            if (current.right != null) {
                queue.add(current.right);
            } else {
                current.right = insertNode;
                return;
            }
        }
    }

    public void insertNodeLevelOrderRecursive(Node root, Node newNode) {
        if (root == null) {
            root = newNode;
        } else {
            if (root.left == null) {
                root.left = newNode;
            } else {
                insertNodeLevelOrderRecursive(root.left, newNode);
            }
            if (root.right == null) {
                root.right = newNode;
            } else {
                insertNodeLevelOrderRecursive(root.right, newNode);
            }
        }
    }

    public int sizeOfTreeRecursive(Node root) {
        if (root == null) {
            return 0;
        } else {
            return sizeOfTreeRecursive(root.left) + 1 + sizeOfTreeRecursive(root.right);
        }
    }

    public int sizeOfTreeNonRecursive(Node root) {
        int count = 0;
        if (root == null) {
            return count;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            count++;
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
        return count;
    }

    public void printReverseLevelOrder(Node root) {
        if (root == null) {
            throw new IllegalArgumentException("Tree is empty");
        }
        Stack<Node> stack = new Stack<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            stack.push(current);
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop().data + "->");
        }
    }

    public void deleteTreePostOrderRecursive(Node root) {
        if (root == null) {
            return;
        }
        deleteTreePostOrderRecursive(root.left);
        deleteTreePostOrderRecursive(root.right);
        root = null;
    }

    public void deepestNode(Node root) {
        if (root == null) {
            System.out.println("Deepest node is null");
        }
        Node current = new Node();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            current = queue.poll();

            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
        System.out.println(current.data);
    }

    public void numberOfLeavesLevelOrder(Node root) {
        if (root == null) {
            System.out.println("No leaves present");
        }
        List<Integer> leavesList = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
            if (current.left == null && current.right == null) {
                leavesList.add(current.data);
            }
        }
        System.out.println(leavesList.size());
        for (int data : leavesList) {
            System.out.print(data + "->");
        }
    }

    public void numberOfFullNodesLevelOrder(Node root) {
        if (root == null) {
            System.out.println("No node present");
        }

        List<Integer> fullNodeList = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
            if (current.left != null && current.right != null) {
                fullNodeList.add(current.data);
            }
        }
        System.out.println(fullNodeList.size());
        for (int data : fullNodeList) {
            System.out.print(data + "->");
        }
    }

    public void numberOfHalfNodesLevelOrder(Node root) {
        if (root == null) {
            System.out.println("No node present");
        }

        List<Integer> halfNodeList = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
            if (current.left != null && current.right == null || current.right != null && current.left == null) {
                halfNodeList.add(current.data);
            }
        }
        System.out.println(halfNodeList.size());
        for (int data : halfNodeList) {
            System.out.print(data + "->");
        }
    }

    public boolean areStructurallySameTrees(Node root1, Node root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }

        return root1.data == root2.data && areStructurallySameTrees(root1.left, root2.left)
                && areStructurallySameTrees(root1.right, root2.right);

    }

    public void deleteNode(Node root, Node deleteNode) {
        if (root == null) {
            System.out.print("No node to delete");
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Node current = new Node();
        Node findNode = new Node();
        while (!queue.isEmpty()) {
            current = queue.poll();
            if (current.data == deleteNode.data) {
                findNode = current;
            }
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
        findNode.data = current.data;
        current = null;
    }

    public void mirrorTree(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        queue.add(root);
        Node current;
        while (!queue.isEmpty()) {
            current = queue.poll();
            list.add(current.data);
            Node temp = current.left;
            current.left = current.right;
            current.right = temp;

            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
        for (int data : list) {
            System.out.print(data + "->");
        }
    }

    public Node mirrorTreeRecursive(Node root) {
        if (root == null) {
            return null;
        }
        Node left = mirrorTreeRecursive(root.left);
        Node right = mirrorTreeRecursive(root.right);

        root.left = right;
        root.right = left;
        return root;
    }

    private static int preIndex = 0;

    public Node constructTreeWithInAndPreOrder(int[] inOrder, int[] preOrder, int start, int end) {

        if (start > end) {
            return null;
        }
        Node node = new Node(preOrder[preIndex]);
        preIndex++;

        if (start == end) {
            return node;
        }

        int searchIndex = search(inOrder, start, end, node.data);

        node.left = constructTreeWithInAndPreOrder(inOrder, preOrder, start, searchIndex - 1);
        node.right = constructTreeWithInAndPreOrder(inOrder, preOrder, searchIndex + 1, end);
        return node;
    }

    private int search(int[] inOrder, int start, int end, int rootData) {

        for (int i = start; i <= end; i++) {
            if (rootData == inOrder[i]) {
                return i;
            }
        }
        return -1;
    }

    //    private static int leftHeight = 0;
//    private static int rightHeight = 0;
    public static class Height {
        int height = 0;
    }

    public boolean isBalanced(Node root, Height height) {
        if (root == null) {
            height.height = 0;
            return true;
        }
        Height leftHeight = new Height();
        Height rightHeight = new Height();
        boolean left = isBalanced(root.left, leftHeight);
        boolean right = isBalanced(root.right, rightHeight);

        int lh = leftHeight.height;
        int rh = rightHeight.height;

        if (lh > rh) {
            height.height = lh + 1;
        } else {
            height.height = rh + 1;
        }
        if (Math.abs(lh - rh) >= 2) {
            return false;
        } else {
            return left && right;
        }

    }

    public boolean checkForChildrenSumParent(Node root) {
        int leftChild = 0;
        int rightChild = 0;
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        } else {
            if (root.left != null) {
                leftChild = root.left.data;
            }
            if (root.right != null) {
                rightChild = root.right.data;
            }
            if ((root.data == leftChild + rightChild) && checkForChildrenSumParent(root.left) == true
                    && checkForChildrenSumParent(root.right) == true) {
                return true;
            } else {
                return false;
            }
        }
    }

    public int diameterTree(Node root) {
        if (root == null) {
            return 0;
        }
        int leftDia = diameterTree(root.left);
        int rightDia = diameterTree(root.right);
        int rootThroughDia = heightOfTreeRecursive(root.left) + heightOfTreeRecursive(root.right) + 1;

        // maximum of left, right, root through dia
        int maxLeftRight = Math.max(leftDia, rightDia);
        int dia = Math.max(rootThroughDia, maxLeftRight);
        return dia;
    }

    public int diaOfTree(Node root) {
        if (root == null) {
            return 0;
        }
        int leftDia = diaOfTree(root.left);
        int rightDia = diaOfTree(root.right);
        int diaThruRoot = 1 + heightOfTreeUsingLevelOrder(root.left) + heightOfTreeUsingLevelOrder(root.right);

        return Math.max(diaThruRoot, Math.max(leftDia, rightDia));
    }

    class TreeInfo {
        int height;
        int dia;

        public TreeInfo(int height, int dia) {
            this.height = height;
            this.dia = dia;
        }
    }

    public TreeInfo diameterTreeEfficient(Node root) {
        if (root == null) {
            return new TreeInfo(0, 0);
        }
        TreeInfo left = diameterTreeEfficient(root.left);
        TreeInfo right = diameterTreeEfficient(root.right);

        int diameter = Math.max(left.dia, Math.max(right.dia, (left.height + right.height + 1)));
        int height = Math.max(left.height, right.height) + 1;
        TreeInfo treeInfo = new TreeInfo(height, diameter);
        return treeInfo;
    }

    public TreeInfo diaOfTreeSingleScan(Node root) {
        if (root == null) {
            return new TreeInfo(0, 0);
        }
        TreeInfo leftTreeInfo = diaOfTreeSingleScan(root.left);
        TreeInfo rightTreeInfo = diaOfTreeSingleScan(root.right);
        int height = Math.max(leftTreeInfo.height, rightTreeInfo.height) + 1;
        int leftDia = leftTreeInfo.dia;
        int rightDia = rightTreeInfo.dia;
        int dia = Math.max((leftTreeInfo.height + rightTreeInfo.height + 1), Math.max(leftDia, rightDia));
        TreeInfo treeInfo = new TreeInfo(height, dia);
        return treeInfo;
    }

    public boolean isSubTree(Node root, Node subRoot) {
        if (subRoot == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        if (root.data == subRoot.data) {
            if (isIdentical(root, subRoot)) {
                return true;
            }
        }

        return isSubTree(root.left, subRoot) || isSubTree(root.right, subRoot);
    }

    public boolean isIdentical(Node root, Node subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }
        if (root == null || subRoot == null) {
            return false;
        }
        if (root.data == subRoot.data) {
            return isIdentical(root.left, subRoot.left) && isIdentical(root.right, subRoot.right);
        }

        return false;
    }

    public static class Max_Level {
        int max_level;
    }

    static int max_level = 0;

    public void rightView(Node root, int level) {
        // base case
        if (root == null) {
            return;
        }
        // if this is the last node of the level
        if (max_level < level) {
            System.out.println(root.data + " ");
            max_level = level;
        }

        // recur for right subtree first then left
        rightView(root.right, level + 1);
        rightView(root.left, level + 1);
    }

    public void rightView1(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        Stack<Integer> stack = new Stack<>();
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current != null) {
                stack.add(current.data);
            }
            if (current == null) {
                if (queue.isEmpty()) {
                    System.out.print(stack.peek() + ": ");
                    break;
                } else {
                    queue.add(null);
                    System.out.print(stack.peek() + ": ");
                    stack.clear();
                }
            } else {
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
        }
    }

    public void leftView(Node root, int level) {
        if (root == null) {
            return;
        }

        if (max_level < level) {
            System.out.println(root.data + " ");
            max_level = level;
        }

        leftView(root.left, level + 1);
        leftView(root.right, level + 1);
    }

    public void leftView1(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        Queue<Integer> queue1 = new LinkedList<>();
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current != null) {
                queue1.add(current.data);
            }
            if (current == null) {
                if (queue.isEmpty()) {
                    System.out.print(queue1.peek() + ": ");
                    break;
                } else {
                    queue.add(null);
                    System.out.print(queue1.peek() + ": ");
                    queue1.clear();
                }
            } else {
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
        }
    }

    public void topView(Node root) {
        class QueueObj {
            Node node;
            int hd;

            public QueueObj(Node node, int hd) {
                this.node = node;
                this.hd = hd;
            }
        }
        Queue<QueueObj> queue = new LinkedList<>();
        TreeMap<Integer, Node> treeMap = new TreeMap<>();
        if (root == null) {
            return;
        }
        queue.add(new QueueObj(root, 0));

        while (!queue.isEmpty()) {
            QueueObj obj = queue.poll();
            if (!treeMap.containsKey(obj.hd)) {
                treeMap.put(obj.hd, obj.node);
            }
            if (obj.node.left != null) {
                queue.add(new QueueObj(obj.node.left, obj.hd - 1));
            }
            if (obj.node.right != null) {
                queue.add(new QueueObj(obj.node.right, obj.hd + 1));
            }
        }
    }

    public List<Integer> zigZagLevelOrder(Node root) {
        if (root == null) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        Stack<Node> stack = new Stack<>();
        boolean leftToRight = true;
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node current = queue.poll();
                arrayList.add(current.data);
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
            if (!leftToRight) {
                Collections.reverse(arrayList);
            }
            for (int i = 0; i < arrayList.size(); i++) {
                list.add(arrayList.get(i));
            }
            leftToRight = !leftToRight;
        }

        return list;
    }

    public boolean leafAtSameLevel(Node root) {
        if (root == null) {
            return true;
        }
        Queue<Node> queue = new LinkedList<>();
        Queue<Node> queueLeafs = new LinkedList<>();
        Queue<Node> levelNodes = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            levelNodes.add(current);
            if (current == null) {
                if (queue.isEmpty()) {
                    break;
                } else {
                    levelNodes.clear();
                    queue.add(null);
                }

            } else {
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
                if (current.left == null && current.right == null) {
                    queueLeafs.add(current);
                }
            }
        }
        boolean result = true;
        while (!levelNodes.isEmpty() || !queueLeafs.isEmpty()) {
            if (levelNodes.poll().data != queueLeafs.poll().data) {
                result = false;
            }
        }
        if (!queueLeafs.isEmpty()) {
            result = false;
        }
        return result;
    }

    public boolean leafAtSameLevelPreOrderIterative(Node root) {
        if (root == null) {
            return false;
        }
        boolean result = false;
        Stack<Node> stack = new Stack<>();
        int level = 0;
        int leafLevel = 0;
        stack.push(root);
        while (!stack.isEmpty()) {
            Node current = stack.pop();
            int size = stack.size();
            if (size > level) {
                level = size;
            }
            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }
            if (current.left == null && current.right == null) {
                leafLevel = level;
            }
        }
        return false;
    }

    public static int level = 0;

    public boolean leafAtSameLevelRecursive(Node root, int currentLevel) {
        if (root == null) {
            return true;
        } else {
            if (root.left == null && root.right == null) {
                // when a leaf node is found first time
                if (level == 0) {
                    // set first found leaf node level
                    level = currentLevel;
                    return true;
                } else {
                    // if not first leaf node then compare its level with first leaf node
                    return level == currentLevel;
                }
            }
        }
        return leafAtSameLevelRecursive(root.left, currentLevel + 1) &&
                leafAtSameLevelRecursive(root.right, currentLevel + 1);

    }

    public boolean isBalanced1(Node root) {
        if (root == null) {
            return true;
        }
        int leftTreeHeight = heightOfTreeRecursive(root.left);
        int rightTreeHeight = heightOfTreeRecursive(root.right);
        if (Math.abs(leftTreeHeight - rightTreeHeight) >= 2) {
            return false;
        }
        return true;
    }

    public int toSumTree(Node root) {
        if (root == null) {
            return 0;
        }
        int old_val = root.data;
        int left = toSumTree(root.left);
        int right = toSumTree(root.right);
        root.data = left + right;

        return root.data + old_val;
    }

    public boolean isIsomorphic(Node root1, Node root2) {
        if (root1 == null && root2 == null) {
            return true;
        }

        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.data != root2.data) {
            return false;
        }
        return (isIsomorphic(root1.left, root2.left) && isIsomorphic(root1.right, root2.right)) ||
                (isIsomorphic(root1.left, root2.right) && isIsomorphic(root1.right, root2.left));
    }

    public boolean sameTree(Node root1, Node root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.data != root2.data) {
            return false;
        }
        return sameTree(root1.left, root2.left) && sameTree(root1.right, root2.right);
    }

    // initialize treemap and hd=0
    public void verticalOrderTreeRecursive(Node root, int hd, TreeMap<Integer, List<Integer>> treeMap) {
        if (root == null) {
            return;
        }

        List<Integer> list = treeMap.get(hd);
        // store current node in treemap
        if (list == null) {
            list = new ArrayList<>();
            list.add(root.data);
        } else {
            list.add(root.data);
        }
        // put horizontal distance and list into treemap
        treeMap.put(hd, list);
        verticalOrderTreeRecursive(root.left, hd - 1, treeMap);
        verticalOrderTreeRecursive(root.right, hd + 1, treeMap);
    }

    class TreeInfoTopView{
        int level;
        int data;

        public TreeInfoTopView(int level, int data) {
            this.level = level;
            this.data = data;
        }
    }
    public void topViewTreeInfo(Node root) {
        if (root == null) {
            return;
        }
        TreeMap<Integer, TreeInfoTopView> treeMap = new TreeMap<>();
        int hd = 0;
        int level = 0;
        fillMap(root, hd, level, treeMap);
        for (Map.Entry<Integer, TreeInfoTopView> entry : treeMap.entrySet()) {
            System.out.print(entry.getValue().data + ":");
        }
    }

    public void fillMap(Node root, int hd, int level, TreeMap<Integer, TreeInfoTopView> treeMap) {
        if (root == null) {
            return;
        }
        if (treeMap.get(hd) == null) {
            treeMap.put(hd, new TreeInfoTopView(level, root.data));
        } else if (treeMap.get(hd).level > level) {
            treeMap.put(hd, new TreeInfoTopView(level, root.data));
        }
        fillMap(root.left, hd - 1, level + 1, treeMap);
        fillMap(root.right, hd + 1, level + 1, treeMap);
    }

    public void bottomViewHashmap(Node root){
        if(root == null){
            return;
        }
        TreeMap<Integer, TreeInfoTopView> treeMap = new TreeMap<>();
        int hd = 0;
        int level = 0;
        fillMapBottomView(root, hd, level, treeMap);
        for(Map.Entry<Integer, TreeInfoTopView> entry: treeMap.entrySet()){
            System.out.print(entry.getValue().data + ": ");
        }
    }

    private void fillMapBottomView(Node root, int hd, int level, TreeMap<Integer, TreeInfoTopView> treeMap) {
        if(root == null){
            return;
        }
        if(!treeMap.containsKey(hd)){
            treeMap.put(hd, new TreeInfoTopView(level, root.data));
        } else {
            if(treeMap.get(hd).level <= level){
                treeMap.put(hd, new TreeInfoTopView(level, root.data));
            };
        }
        fillMapBottomView(root.left, hd-1, level+1, treeMap);
        fillMapBottomView(root.right, hd+1, level+1, treeMap);
    }

    public void bottomViewQueue(Node root){
        if(root == null){
            return;
        }
        int hd = 0;
        Queue<Node> queue = new LinkedList<>();
        TreeMap<Integer, Node> treeMap = new TreeMap<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node current = queue.poll();
            hd = current.hd;
            treeMap.put(hd, current);

            if(current.left != null){
                current.left.hd = hd -1;
                queue.add(current.left);
            }
            if(current.right != null){
                current.right.hd = hd + 1;
                queue.add(current.right);
            }
        }

        for(Map.Entry<Integer, Node> entry : treeMap.entrySet()){
            System.out.print(entry.getValue().data + ": ");
        }
    }
}
