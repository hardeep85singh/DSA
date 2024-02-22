package com.example.dsalgo.leetcode.medium;

/**
 * @author Hardeep Singh
 */
public class M92ReverseLinkedListII {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
        ListNode node = reverseBetween(head, 1, 2);
        printList(node);
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

    public static ListNode reverseBetween(ListNode head, int left, int right) {

        if(left >= right){
            return head;
        }
        if(head.next == null){
            return head;
        }

        ListNode leftCurr = head;
        ListNode rightCurr = head;
        int count = 1;
        while(count < left-1){
            leftCurr = leftCurr.next;
            rightCurr = rightCurr.next;
            count++;
        }

        while(count < right){
            rightCurr = rightCurr.next;
            count++;
        }
        ListNode rearHead = rightCurr.next;
        rightCurr.next = null;
        ListNode newHead;
        if(left == 1){
            newHead = leftCurr;
            head = reverse(newHead);
            leftCurr = head;
        } else {
            newHead = leftCurr.next;
            leftCurr.next = null;
            newHead = reverse(newHead);
            leftCurr.next = newHead;
        }

        while(leftCurr.next != null){
            leftCurr  = leftCurr.next;
        }
        leftCurr.next = rearHead;

        return head;

    }

    public static ListNode reverse(ListNode head){
        ListNode previous = null;
        ListNode current = head;
        ListNode next = null;

        while(current != null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
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
