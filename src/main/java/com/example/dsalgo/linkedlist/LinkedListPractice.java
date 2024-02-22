package com.example.dsalgo.linkedlist;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author Hardeep Singh
 */
@Service
public class LinkedListPractice {

//    public LinkedListPractice(Node node) {
//        this.head = node;
//    }

    @Service
    public static class Node {
        public int data;
        public Node next;

        public Node() {
        }

        public Node(int data) {
            this.data = data;
        }
    }

    public static Node head;

    public static class NodeWithChildRight{
        public int data;
        public NodeWithChildRight right;
        public NodeWithChildRight child;

        public NodeWithChildRight() {
        }

        public NodeWithChildRight(int data) {
            this.data = data;
        }
    }
    public static NodeWithChildRight root;

    public static class DLLNode{
        public int data;
        public DLLNode next;
        public DLLNode previous;

        public DLLNode(){}

        public DLLNode(int data){
            this.data = data;
            next = null;
            previous = null;
        }
    }
    public static DLLNode headDll;
    public static DLLNode tailDll;


    public LinkedListPractice(Node node) {
        this.head = node;
    }

    public void insert(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public Node returnHead() {
        return head;
    }

    public Node reverseList(Node head) {
        if (head == null) {
            return null;
        }
//        Node previous = null;
//        Node current = head;
//        Node next = null;
//
//        while(current != null){
//            next = current.next;
//            current.next = previous;
//            previous = current;
//            current = next;
//        }
//        head = previous;
//        return head;
        Node previous = null;
        Node current = null;

        while (head != null) {
            current = head.next;
            head.next = previous;
            previous = head;
            head = current;
        }
        head = previous;
        return head;
    }

    public boolean isListCycle(Node head) {
        if (head == null || head.next == null) {
            return false;
        }
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public boolean isListCycleHashMap(Node head) {
        if (head == null || head.next == null) {
            return false;
        }
        Node current = head;
        Map<Node, Integer> map = new HashMap<>();
        while (current != null) {
            if (map.containsKey(current)) {
                return true;
            } else {
                map.put(current, current.data);
            }
            current = current.next;
        }
        return false;
    }

    public Node mergeTwoSortedList(Node head1, Node head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        Node leftHead = head1;
        Node rightHead = head2;
        Node merged = new Node();
        Node previous = merged;

        while (leftHead != null && rightHead != null) {
            if (leftHead.data < rightHead.data) {
                previous.next = leftHead;
                previous = leftHead;
                leftHead = leftHead.next;
            } else {
                previous.next = rightHead;
                previous = rightHead;
                rightHead = rightHead.next;
            }
        }
        while (leftHead != null) {
            previous.next = leftHead;
            previous = leftHead;
            leftHead = leftHead.next;
        }

        while (rightHead != null) {
            previous.next = rightHead;
            previous = rightHead;
            rightHead = rightHead.next;
        }
        return merged.next;
    }

    public Node mergeTwoSortedListRecursive(Node leftHead, Node rightHead) {
        if (leftHead == null) {
            return rightHead;
        }
        if (rightHead == null) {
            return leftHead;
        }
        Node result;
        if (leftHead.data < rightHead.data) {
            result = leftHead;
            leftHead.next = mergeTwoSortedListRecursive(leftHead.next, rightHead);
        } else {
            result = rightHead;
            rightHead.next = mergeTwoSortedListRecursive(leftHead, rightHead.next);
        }
        return result;
    }

    public Node deleteWithoutHeadNode(int data) {
        Node temp = head, prev = null;

        // If head node itself holds the key to be deleted
        if (temp != null && temp.data == data) {
            head = temp.next; // Changed head
            return temp;
        }

        // Search for the key to be deleted, keep track of
        // the previous node as we need to change temp.next
        while (temp != null && temp.data != data) {
            prev = temp;
            temp = temp.next;
        }
        // If key was not present in linked list
        if (temp == null) {
            return null;
        }
        // Unlink the node from linked list
        prev.next = temp.next;
        return temp;
//        if(node == null){
//            return null;
//        }
//        Node current = node;
//        Node previous = new Node();
////        if(current.next == null){
////            node = null;
////            return current;
////        }
//        Node result = new Node();
//        while(current != null){
//            if(current.data == node.data && current.next != null){
//                result = current;
//                current.data = current.next.data;
//                current.next = current.next.next;
//            }
//            if(current.data == node.data && current.next == null){
//                result = current;
//                return null;
////                break;
//            }
//            current = current.next;
//        }
//        return result;

    }

    public void removeDuplicatesFromUnsortedListHashmap(Node head) {
        if (head == null) {
            System.out.println("No elements present");
        }
        Map<Integer, Node> map = new HashMap<>();
        Node current = head;
        while (current != null) {
            if (!map.containsKey(current.data)) {
                map.put(current.data, current);
            } else {
                current.data = current.next.data;
                current.next = current.next.next;
            }
            current = current.next;
        }

    }

    public void removeDuplicatesFromUnsortedList(Node head) {
        // sort the list
//        sort(head);
        Node current = head;
        Node next = head;
        while (next != null) {
            if (next.data != current.data) {
                next.next = current;
                next = current;
            }
            next = next.next;
        }
    }

    public Node sortListOf012sAdditionalLists(Node head) {
        if (head == null) {
            return null;
        }
        Node zeroHead = null;
        Node oneHead = null;
        Node twoHead = null;
        // can be also done by counting number of 0, 1 , 2
        while (head != null) {
            Node current = new Node();
            if (head.data == 0) {
                current.data = head.data;
                current.next = zeroHead;
                zeroHead = current;
            } else if (head.data == 1) {
                current.data = head.data;
                current.next = oneHead;
                oneHead = current;
            } else if (head.data == 2) {
                current.data = head.data;
                current.next = twoHead;
                twoHead = current;
            } else {
                return null;
            }
            head = head.next;
        }
        Node temp = zeroHead;
        while (temp != null) {
            if (temp.next == null) {
                temp.next = oneHead;
//                temp = oneHead;
                break;
            }
            temp = temp.next;
        }
        while (temp != null) {
            if (temp.next == null) {
                temp.next = twoHead;
                break;
            }
            temp = temp.next;
        }
        return zeroHead;
    }

    public Node sortListOf012s(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node current = head;
        Node zeroL = new Node(0);
        Node oneL = new Node(0);
        Node twoL = new Node(0);
        Node zero = zeroL;
        Node one = oneL;
        Node two = twoL;
        while (current != null) {
            if (current.data == 0) {
                zero.next = current;
                zero = zero.next;
                current = current.next;
            } else if (current.data == 1) {
                one.next = current;
                one = one.next;
                current = current.next;
            } else {
                two.next = current;
                two = two.next;
                current = current.next;
            }
        }
        if (oneL.next != null) {
            zero.next = oneL.next;
        } else {
            zero.next = twoL.next;
        }
        one.next = twoL.next;
        two.next = null;
        return zeroL.next;
    }

    public int removeNthNodeFromEnd(Node head, int n) {
        if (head == null) {
            return -1;
        }
        int result = -1;
        Node first = head;
        Node second = head;
        for (int i = 0; i < n; i++) {
            if (second.next == null) {
                if (i == n - 1) {
                    result = head.data;
                    head = head.next;
                }
                return result;
            }
            second = second.next;
        }
        while (second.next != null) {
            second = second.next;
            first = first.next;
        }
        Node temp = first;
        result = temp.next.data;
        first.next = first.next.next;
        temp.next = null;
        return result;
    }

    // 1-2-3-4-5 to 1-5-2-4-3
    public Node reorderListSimple(Node head){
        if(head == null){
            return null;
        }
        Node current = head;
        Node next = head;
        while(current != null){
            current = current.next;
            if(current.next == null){
                Node temp = new Node(current.data);
                temp.next = next.next;
                next.next = temp;
                current = temp.next;
                next = next.next.next;
            }
        }
        return head;
    }

    public Node reOrderListEfficient(Node head){
        if (head == null){
            return null;
        }
        if(head.next == null){
            return head;
        }
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        Node leftHead = head;
        Node rightHead = slow.next;
        slow.next = null;
        Node newRightHead = reverseList(rightHead);
        return mergeList(leftHead, newRightHead);
    }

    private Node mergeList(Node leftHead, Node rightHead) {
        if(leftHead == null && rightHead == null){
            return null;
        }
        if(leftHead != null && rightHead == null){
            return leftHead;
        }
        if(leftHead == null && rightHead != null){
            return rightHead;
        }
        Node newHead = leftHead;
        Node next = leftHead;

        while(leftHead != null && rightHead != null){
            leftHead = leftHead.next;
            next.next = rightHead;
            next = next.next;
            rightHead = rightHead.next;
            next.next = leftHead;
            next = next.next;
        }
        return newHead;
    }

    public Node intersectionOfTwoList(Node firstHead, Node secondHead){
        if(firstHead == null || secondHead == null){
            return null;
        }
        int firstListLength = 0;
        int secondListLength = 0;
        Node firstCurrent = firstHead;
        Node secondCurrent = secondHead;
        while(firstCurrent != null){
            firstCurrent = firstCurrent.next;
            firstListLength++;
        }
        while(secondCurrent != null){
            secondCurrent = secondCurrent.next;
            secondListLength++;
        }
        int diff = Math.abs(firstListLength-secondListLength);
        if(firstListLength > secondListLength){
            for(int i = 0; i< diff; i++){
                firstHead = firstHead.next;
            }
        } else {
            for(int i = 0; i< diff; i++){
                secondHead = secondHead.next;
            }
        }
        while(firstHead != null){
            if(firstHead == secondHead){
                return firstHead;
            }
            firstHead = firstHead.next;
            secondHead = secondHead.next;
        }
        return null;
    }

    public Node intersectionOfTwoListTwoPointers(Node firstHead, Node secondHead){
        if(firstHead == null || secondHead == null){
            return null;
        }
        Node firstCurr = firstHead;
        Node secondCurr = secondHead;

        while(firstCurr.next != null){
            firstCurr =  firstCurr.next;
        }
        while(secondCurr.next != null){
            secondCurr = secondCurr.next;
        }
        firstCurr.next = secondHead;
        secondCurr.next = firstHead;
        while(firstCurr.data != secondCurr.data){
            firstCurr = firstCurr.next;
            secondCurr = secondCurr.next;
        }
        return firstCurr;
    }

    // reversing both list won't work. If reverse first list will change the second list reverse.
    // to work we have to store the first and second list and then reverse.
    public Node intersectionOfTwoListByHashMap(Node firstHead, Node secondHead){
        if(firstHead == null || secondHead == null){
            return null;
        }
        HashSet<Node> hashSet = new HashSet<>();
        while (firstHead != null){
            hashSet.add(firstHead);
            firstHead = firstHead.next;
        }
        while (secondHead != null){
            if(hashSet.contains(secondHead)){
                return secondHead;
            } else {
                secondHead = secondHead.next;
            }
        }
        return null;
    }


    public NodeWithChildRight flattenMultiLevelList(NodeWithChildRight root){
        if(root == null){
            return null;
        }
        NodeWithChildRight next = root;
        NodeWithChildRight curr = root;
        while(curr.right != null){
            curr = curr.right;
        }
        next = curr;
        curr = root;
        while (curr != null){
            if(curr.child != null){
                next.right = curr.child;
                curr.child = null;
                while(next.right != null){
                    next = next.right;
                }
            }
            curr = curr.right;
        }
        return root;
    }

    public Node zigZagList(Node head){
        if (head == null){
            return null;
        }
        Node previous = new Node(Integer.MAX_VALUE);
        Node current = head;
        Node next = current.next;
        previous.next = current;
        int count = 1;
        while (next != null){
            if(count % 2 == 1){
                if(!(current.data < previous.data && current.data < next.data)){
                    int temp = next.data;
                    next.data = current.data;
                    current.data = temp;
                }
            } else {
                if(!(current.data > previous.data && current.data > next.data)){
                    int temp = next.data;
                    next.data = current.data;
                    current.data = temp;
                }
            }
            previous = current;
            current = next;
            next = next.next;
            count++;
        }
        return head;
    }

    public DLLNode reverseDoublyLinkedList(DLLNode headDll){
        if(headDll == null){
            return null;
        }
        DLLNode curr = headDll;
        DLLNode previous = null;
        while (curr.next != null){
            previous = curr;
            curr = curr.next;
            curr.previous = previous;
        }
        tailDll = curr;
        DLLNode temp = headDll;
        headDll = tailDll;
        tailDll = temp;
        return headDll;
    }

    public Node segregateEvenOdd(Node head){
        if (head == null){
            return null;
        }
        Node curr = head;
        Node previous = null;
        // if list starts from even
        while (curr != null){
            if(curr.data % 2 == 0){
                previous = curr;
                curr = curr.next;
            } else {
                // delete curr
                Node temp = curr;
                previous.next = curr.next;
                curr = curr.next;
                temp.next = null;
                // insert into list
                temp.next = head;
                head = temp;
            }
        }
        return head;
    }

    public void quickSortUtil(Node head){
        if(head == null){
            return;
        }
        Node end = head;
        Node curr = head;
        while (curr.next != null ){
            curr = curr.next;
        }
        end = curr;
        quickSort(head, end);

    }
    public void quickSort(Node start, Node end){
        if(start == null || start == end || start.next == end){
            return;
        }
        Node pivot_prev = partition(start, end);
        quickSort(start, pivot_prev);

        if(pivot_prev != null && pivot_prev == start){
            quickSort(pivot_prev.next, end);
        } else if(pivot_prev != null && pivot_prev.next != null){
            quickSort(pivot_prev.next.next, end);
        }

    }
    private Node partition(Node start, Node end) {
        if (start == null || start == end || end == null){
            return start;
        }
        Node pivot_prev = start;
        Node curr = start;
        int pivot = end.data;
        while (start != end){
            if(start.data < pivot){
                pivot_prev = curr;
                int temp = curr.data;
                curr.data = start.data;
                start.data = temp;
            }
            start = start.next;
        }
        int temp = curr.data;
        curr.data = pivot;
        end.data = temp;
        return pivot_prev;
    }

    public Node mergeSort(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node middle = middleOfList(head);
        Node middleNext = middle.next;
        Node left = mergeSort(head);
        Node right = mergeSort(middleNext);
        Node sortedHead = merge(left, right);
        return sortedHead;
    }

    private Node merge(Node left, Node right) {
        if(left == null){
            return right;
        }
        if(right == null){
            return left;
        }
        Node result = null;
        if(left.data <= right.data){
            result = left;
            result.next = merge(left.next, right);
        } else {
            result = right;
            result.next = merge(left, right.next);
        }
        return result;
    }

    public Node middleOfList(Node head) {
        if(head == null || head.next == null){
            return head;
        }
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public Node reverseKNodesList(Node head, int k){
        if(head == null){
            return null;
        }
        Node previous = null;
        Node current = head;
        Node next = null;
        int count = 0;

//        reverse first k nodes
        while(current != null && count < k){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
            count++;
        }
        // head now points to kth node, change head next to k+1 node
        if(head != null){
            head.next = current;
        }
        // recursive call from starting of current (head.next will point to new head i.e. previous node)
        if(current != null){
            head.next = reverseKNodesList(current, k);
        }
        return previous;
    }

    public void printDoublyLinkedList(DLLNode headDll){
        if(headDll == null){
            return;
        }
        while (headDll != null){
            System.out.print(headDll.data + "->");
            headDll = headDll.next;
        }
    }
    public void printMultiLevelList(NodeWithChildRight root){
        if(root == null){
            return;
        }
        while (root != null){
            System.out.print(root.data + "->");
            root = root.right;
        }
    }
    public void printList(Node head) {
        if (head == null) {
            System.out.println("List is empty: ");
        }
        Node current = head;
        while (current != null) {
            System.out.print(current.data + ": ");
            current = current.next;
        }
        System.out.println();
    }

}
