package com.example.dsalgo.linkedlist;

public class MiddleOfLinkedList {
    public static void main(String[] args) {
//        ListNode node = GenerateLinkedList.generateList();
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(3);
        node1.next.next = new ListNode(4);
//        PrintLinkedList.printLinkedList(middle(node1));
        System.out.println(middle(node1));
    }

    public static int middle(ListNode head){
        if(head == null){
            return -1;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow.val;
    }
}
