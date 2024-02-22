package com.example.dsalgo.linkedlist;

import java.util.*;

/**
 * @author Hardeep Singh
 */
//@Service
public class LinkedList {
    static int size;
    public static Node head;

    public static class Node{
        public int data;
        public Node next;
        Node right;
        Node down;
        int flag;

        public Node() {
        }

        public Node(int data) {
            this.data = data;
        }
    }

    public LinkedList(){}
    public LinkedList(Node node) {
        this.head = node;
    }

    public void insert(int data){
        Node node = new Node();
        node.data = data;
        node.next = head;
        head = node;
    }

    public void insertNode(Node node){
        node.next = head;
        head = node;
    }

    public void printMiddleOfLinkedListBrute(){
        if(head == null){
            System.out.println("List is empty");
        }
        int length = 0;
        Node currentNode = head;
        while (currentNode != null){
            length++;
            currentNode = currentNode.next;
        }
        int middle = (length + 1) /2;
        Node temp = head;
        for (int i = 0; i< middle; i++){
            temp = temp.next;
        }
        System.out.println("Middle of list" + temp.data);
    }

    public void printMiddleOfLinkedListTwoPointers(){
        if(head == null){
            System.out.println("List is empty");
        }
        Node slowPtr = head;
        Node fastPtr = head;

        while(fastPtr != null && fastPtr.next != null){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        System.out.println("Middle of list: " + slowPtr.data);
    }

    public Node merge(Node a, Node b){
        if(a == null){
            return b;
        }
        if(b == null){
            return a;
        }
        if(a.data > b.data){
            return a.next = merge(a.next, b);
        } else{
            return b.next = merge(a, b.next);
        }
    }

    public Node flatten(Node root){
        if(root == null || root.right == null){
            return root;
        }
        root.right = flatten(root.right);
        root = merge(root, root.right);
        return root;
    }

    public Node deleteMiddle1(Node head){
        if(head == null){
            return null;
        }
        if(head.next == null){
            return null;
        }
        Node slow = head;
        Node fast = head;
        Node previous = null;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            previous = slow;
            slow = slow.next;
        }
        previous.next = slow.next;
        return slow;
    }

    public void removeDuplicatesFromSortedList(){
        Node current = head;
        Node link = head;
        while(current.data == current.next.data && current != null){
            current = current.next;
            if(current.data != link.data){
                link.next = current;
                link = current;

            }
        }
        link.next = null;

    }
    public void removeDuplicatesFromSortedList1(Node head){
        if(head == null){
            return;
        }
        Node current = head;
        while(current.next != null){
            if(current.data == current.next.data){
                Node nextNext = current.next.next;
                current.next = nextNext;
            } else{
                current = current.next;
            }
        }

    }
    public void removeDuplicatesFromSortedList2(Node head){
        if(head == null){
            return;
        }
        Node current = head;
        Node previous = head;
        while(current.next != null){
            previous = current;
            while(current.data == current.next.data){
                current = current.next;
            }
            current = current.next;
            previous.next = current;
        }
    }

    public Node reverseList(Node head){
        Node previous = null;
        Node current = head;
        Node next = null;

        while(current != null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head = previous;
        return head;
    }

    public Node addOne(Node head){
        head = reverseList(head);
        head = addOneUtil(head);
        return reverseList(head);
    }

    // 9999 00001
    private Node addOneUtil(Node head) {
        Node result = head;
        Node temp = null;
        int carry = 1;
        int sum;
        while (head != null){
            sum = carry + head.data;
            if(sum >= 10){
                carry = 1;
            } else {
                carry = 0;
            }
            sum = sum % 10;
            head.data = sum;
            temp = head;
            head = head.next;
        }

        if(carry > 0){
            temp.next = new Node(carry);
            head = temp.next;
        }
        return result;
    }

    public Node reverseList1(Node head){
        Node previous = null;
        Node next = null;
        Node current = head;

        while(current != null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head = previous;
        return head;
    }
    public Node addOneUtil1(Node head){
        int carry = 1;
        Node temp = null;
        Node current = head;
        int sum = 0;
        while(current != null){
            sum = sum + current.data;
            if(sum >= 10){
                carry = 1;
            } else {
                carry = 0;
            }
            sum = sum % 10;
            current.data = sum;
            temp = current;
            current = current.next;
        }
        if(carry > 0){
            temp.next = new Node(carry);
            current = temp.next;
        }
        head = current;
        return head;
    }

    public Node reverseInKGroups(Node head, int k){
        if(head == null){
            return null;
        }
        Node next = null;
        Node previous = null;
        Node current = head;

        int count = 0;
        while(count < k && current != null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
            count ++;
        }
        // to check
        head = previous;

        if(next != null){
            head.next = reverseInKGroups(next, k);
        }

        return previous;
    }

    public Node reverseInKGroupsStack(Node head, int k){
        Stack<Node> stack = new Stack<>();
        Node current = head;
        Node previous = null;

        while(current != null){
            int count = 0;
            while(current != null && count < k){
                stack.push(current);
                current = current.next;
                count++;
            }

            while(!stack.isEmpty()){
                if(previous == null){
                    previous = stack.peek();
                    head = previous;
                    stack.pop();
                } else {
                    previous.next = stack.peek();
                    previous = previous.next;
                    stack.pop();
                }
            }
        }
        previous.next = null;
        return head;
    }

    public boolean detectLoopFloydCycle(Node head){
        if (head == null){
            return false;
        }
        Node slow = head;
        Node fast = head;

        while(slow != null && fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                return true;
            }
        }
        return false;
    }

    public boolean detectLoopFloydCycle1(Node head){
        if(head == null){
            return false;
        }
        if(head.next == null){
            return false;
        }
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }

    public boolean detectLoopHashTable(Node head){
        HashSet<Node> hashSet = new HashSet<>();
        Node current = head;
        while(current != null){
            if(hashSet.contains(current)){
                return true;
            }
            hashSet.add(current);
            current = current.next;
        }
        return false;
    }

    public boolean detectLoopHashTable1(Node head){
        if( head == null){
            return false;
        }
        Hashtable<Integer, Node> hashtable = new Hashtable<>();
        Node current = head;
        while (current != null){
            if(hashtable.contains(current.data)){
                return true;
            } else{
                hashtable.put(current.data, current);
                current = current.next;
            }
        }
        return false;
    }

    public boolean detectLoopByFlag(Node head){
        Node current = head;

        while(current != null){
           if(current.flag == 1){
               return true;
           }
           current.flag = 1;
           current = current.next;
        }
        return false;
    }

    public void removeLoopByFlag(Node head){
        Node current = head;
        Node previous = null;

        while(current != null){

            if(current.flag == 1){
                previous.next = null;
                break;
            }
            previous = current;
            current.flag = 1;
            current = current.next;

        }
    }

    public void removeLoopFloydCycle(Node head){
        Node slowPtr = head;
        Node fastPtr = head;

        while(slowPtr != null && fastPtr != null && fastPtr.next != null){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;

            if(slowPtr == fastPtr){
                removeLoop(slowPtr, head);

            }
        }
    }

    public void removeLoopFloydCycle1(Node head){
        if(head == null){
            return;
        }
        Node slow = head;
        Node fast = head;

        while(slow != null && fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                fast = head;
                break;
            }
        }
        Node previous;
        while(slow != fast){
            previous = slow;
            slow = slow.next;
            fast = fast.next;
            if(slow == fast){
                previous.next = null;
            }
        }
    }

    private void removeLoop(Node slowPtr, Node head) {

        Node ptr1 = slowPtr;
        Node ptr2 = slowPtr;

        // Count the number of nodes in loop
        int k = 1, i;
        while (ptr1.next != ptr2) {
            ptr1 = ptr1.next;
            k++;
        }

        // Fix one pointer to head
        ptr1 = head;

        // And the other pointer to k nodes after head
        ptr2 = head;
        for (i = 0; i < k; i++) {
            ptr2 = ptr2.next;
        }

        /*  Move both pointers at the same pace,
         they will meet at loop starting node */
        while (ptr2 != ptr1) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        // Get pointer to the last node
        while (ptr2.next != ptr1) {
            ptr2 = ptr2.next;
        }

        /* Set the next node of the loop ending node
         to fix the loop */
        ptr2.next = null;
    }

    public boolean removeLoopHashset(Node head){
        HashSet<Node> hashSet = new HashSet<>();
        Node previous = null;
        Node current = head;

        while (current != null){

            if(hashSet.contains(current)){
                previous.next = null;
                return true;
            } else{
                hashSet.add(current);
                previous = current;
                current = current.next;
            }
        }
        return false;
    }

    public Node deleteElementsSumEqualK(Node head, int k){
        Node root = new Node(0);
        root.next = head;
        Map<Integer, Node> map = new HashMap<>();
        map.put(0, root);
        int sum = 0;
        while(head != null){
            sum = sum + head.data;
            if(map.containsKey(sum - k)){
                Node previous = map.get(sum - k);
                Node start = previous;
                int  aux = sum;
                sum = sum -k;
                while(previous != head){
                    previous = previous.next;
                    aux = aux + previous.data;
                    if(previous != head){
                        map.remove(aux);
                    }
                }
                start.next = head.next;
            } else if(!map.containsKey(sum)){
                map.put(sum, head);
            }
            head = head.next;
        }
        return root.next;
    }

    public Node mergeAlternateElementsList(Node head1, Node head2){
        if(head1 == null){
            return head2;
        }
        if(head2 == null){
            return head1;
        }
        Node current1 = head1;
        Node current2 = head2;
        Node next1;
        Node next2;

        while(current1 != null && current2 != null){
            next1 = current1.next;
            next2 = current2.next;

            current2.next = next1;
            current1.next = current2;

            current1 = next1;
            current2 = next2;
        }
        head2 = current2;
        return head1;
    }

    static int count = 0;
    public void findNthFromLastRecursive(Node head, int n){
        if(head == null){
            return;
        }
        findNthFromLastRecursive(head.next, n);
        count = count +1;
        if(count == n){
            System.out.println(head.data);
        }

    }

    public Node mergeSortLinkedList(Node head){
        if(head == null && head.next == null){
            return head;
        }
        Node middle = getMiddleNode(head);
        Node nextOfMiddle = middle.next;
        middle.next = null;
        Node left = mergeSortLinkedList(head);
        Node right = mergeSortLinkedList(nextOfMiddle);
        Node sortedList = mergeNodeRecursive(left, right);
        return sortedList;
    }

    private Node mergeNodeRecursive(Node left, Node right) {
        Node result = null;
        if(left == null){
            return right;
        }
        if(right == null){
            return left;
        }
        if(left.data <= right.data){
            result = left;
            result.next = mergeNodeRecursive(left.next, right);
        } else {
            result = right;
            result.next = mergeNodeRecursive(left, right.next);
        }
        return result;
    }

    public Node getMiddleNode(Node head) {
        if(head == null){
            return null;
        }
        if(head.next == null){
            return head;
        }
        Node slow = head;
        Node fast = head;
        while(fast!= null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public Node mergeSortLinkedList1(Node head){
        if(head == null){
            return null;
        }
        Node middle = getMiddleNode(head);
        Node nextToMiddle = middle.next;
        middle.next = null;
        Node leftHead = mergeSortLinkedList1(head);
        Node rightHead = mergeSortLinkedList1(nextToMiddle);
        Node sortedList = mergeViaHeadNodes(leftHead, rightHead);
        return sortedList;
    }

    private Node mergeViaHeadNodes(Node leftHead, Node rightHead) {
        Node merged = new Node(-1);
        Node temp = merged;
        while(leftHead != null && rightHead != null){
            if(leftHead.data < rightHead.data){
                temp.next = leftHead;
                temp = leftHead;
                leftHead = leftHead.next;
            } else {
                temp.next = rightHead;
                temp = rightHead;
                rightHead = rightHead.next;
            }
        }
        while(leftHead != null){
            temp.next = leftHead;
            temp = leftHead;
            leftHead = leftHead.next;
        }
        while (rightHead != null){
            temp.next = rightHead;
            temp = rightHead;
            rightHead = rightHead.next;
        }
        return merged.next;
    }

    public void printList(){
        Node node = head;
        while(node != null){
            System.out.print(node.data);
            node = node.next;
        }
    }
}
