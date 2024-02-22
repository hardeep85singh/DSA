package com.example.dsalgo.leetcode.medium;

/**
 * @author Hardeep Singh
 */
public class M19RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        printList(removeNthFromEnd(head, 3));
    }
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null){
            return null;
        }
        ListNode current = head;
        for(int i = 0; i< n; i++){
            current = current.next;
        }
        if(current == null){
            return head.next;
        }
        ListNode nodeBeforeRemoval = head;
        while (current.next != null){
            current = current.next;
            nodeBeforeRemoval = nodeBeforeRemoval.next;
        }
        nodeBeforeRemoval.next = nodeBeforeRemoval.next.next;
        return head;
    }
    public static void printList(ListNode node){
        if (node == null){
            return;
        }
        while (node != null){
            System.out.print(node.val + "->");
            node = node.next;
        }
    }
}
