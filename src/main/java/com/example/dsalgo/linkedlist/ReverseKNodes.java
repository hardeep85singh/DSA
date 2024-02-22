package com.example.dsalgo.linkedlist;

public class ReverseKNodes {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        PrintLinkedList.printLinkedList(reverseKNode(node, 2));
    }

    public static ListNode reverseKNode(ListNode head, int k){
        if (head == null || head.next == null){
            return head;
        }

        ListNode sentinel = new ListNode(-1);
        sentinel.next = head;
        ListNode pointer = sentinel;
        while (pointer != null){

            // check if there are k nodes available
            ListNode node = pointer;
            for (int i = 0; i< k && node != null; i++){
                node = node.next;
            }
            if(node == null){
                break;
            }

            ListNode previous = null;
            ListNode current = pointer.next;
            for (int i = 0; i < k; i++){
                ListNode next = current.next;
                current.next = previous;
                previous = current;
                current = next;
            }

            ListNode tail = pointer.next;
            pointer.next = previous;
            tail.next = current;
            pointer = tail;
        }
        return sentinel.next;
    }
}
