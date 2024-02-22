package com.example.dsalgo.leetcode.medium;

import com.example.dsalgo.leetcode.ListNode;

/**
 * @author Hardeep Singh
 */
public class M2095DeleteTheMiddleNodeOfALinkedList {
    public  static void main(String [] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(2);

    }

    public static ListNode deleteMiddle(ListNode head) {
        if(head.next == null){
            return null;
        }
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        prev.next = slow.next;
        return head;

    }
}
