package com.example.dsalgo.leetcode.easy;

/**
 * @author Hardeep Singh
 */
public class E876MiddleOfLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
        System.out.println(middleNodeTwoPointers(head).val);

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

    public static ListNode middleNodeBrute(ListNode head) {
        int length = 0;
        if(head == null){
            return null;
        }
        ListNode curr = head;
        while (curr != null){
            length++;
            curr = curr.next;
        }
        curr = head;
        int count = 0;
        while (count < length /2){
            count++;
            curr = curr.next;
        }
        return curr;
    }

    public static ListNode middleNodeTwoPointers(ListNode head){
        if(head == null){
            return null;
        }
        ListNode slowPtr = head;
        ListNode fastPtr = head;

        while(fastPtr != null && fastPtr.next != null){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        return slowPtr;
    }
}
