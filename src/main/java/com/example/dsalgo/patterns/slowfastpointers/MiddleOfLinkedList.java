package com.example.dsalgo.patterns.slowfastpointers;

import com.example.dsalgo.leetcode.ListNode;

public class MiddleOfLinkedList {

    public static ListNode middleNode(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
