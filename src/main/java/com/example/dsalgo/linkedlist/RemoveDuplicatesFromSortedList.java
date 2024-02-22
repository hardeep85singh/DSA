package com.example.dsalgo.linkedlist;


public class RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {
        ListNode node = new ListNode(2);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
//        node.next.next.next.next = new ListNode(4);
        PrintLinkedList.printLinkedList(node);
        removeDuplicatedFromSortedList(node);
        PrintLinkedList.printLinkedList(node);
    }

    private static ListNode removeDuplicatedFromSortedList(ListNode head) {
        ListNode current = head;
        while (current.next != null){
            if(current.val == current.next.val){
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }
}
