package com.example.dsalgo.leetcode.medium;

import com.example.dsalgo.leetcode.ListNode;
import com.example.dsalgo.leetcode.PrintLinkedList;

/**
 * @author Hardeep Singh
 */
public class M24SwapNodesInPairs {
    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        PrintLinkedList.printLinkedList(swapPairs(head));
    }

    public static ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode curr = head;
        ListNode prev = null;
        ListNode newHead = null;
        ListNode tail = null;
        while(curr != null && curr.next != null){
            prev = curr;
            curr = curr.next;
            prev.next = curr.next;
            curr.next = prev;
            if(newHead == null){
                newHead = curr;
            }
            if(tail != null){
                tail.next = curr;
            }
            tail = prev;
            curr = prev.next;
        }
        return newHead;
    }
}
