package com.example.dsalgo.leetcode.medium;

import com.example.dsalgo.leetcode.ListNode;
import com.example.dsalgo.leetcode.PrintLinkedList;

public class M2816DoubleANumberRepresentedAsALinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(8);
        head.next = new ListNode(7);
        head.next.next = new ListNode(4);
        PrintLinkedList.printLinkedList(doubleIt(head));
    }
    public static ListNode doubleIt(ListNode head) {
        if (getCarry(head) == 1) {
            return new ListNode(1, head);
        }
        return head;
    }

    private static int getCarry(ListNode node) {
        int val = node.val * 2;
        if (node.next != null) {
            val = val + getCarry(node.next);
        }
        node.val = val % 10;
        return val / 10;
    }
//    public static ListNode doubleIt(ListNode head) {
//        int carry = 0;
//        ListNode curr = reverseList(head);
//        ListNode newHead = curr;
//        ListNode prev = null;
//        while (curr != null){
//            int mul = curr.val * 2 + carry;
//            if(mul / 10 == 1){
//                carry = 1;
//            } else {
//                carry = 0;
//            }
//            curr.val = mul % 10;
//            prev = curr;
//            curr = curr.next;
//        }
//
////        if(carry == 1){
////            prev.next = new ListNode(carry);
////        }
//        newHead = reverseList(newHead);
//        if(carry == 1){
//            ListNode node = new ListNode(carry);
//            node.next = newHead;
//            newHead = node;
//        }
//        return newHead;
//    }

    private static ListNode reverseList(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode next;
        ListNode previous = null;
        ListNode current = head;

        while (current != null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        return previous;
    }
}
