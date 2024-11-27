package com.example.dsalgo.patterns.twopointers;

import com.example.dsalgo.leetcode.ListNode;

public class RemoveNthLastNode {

    private ListNode removeNthLastNode(ListNode head, int n){
        ListNode left = head;
        ListNode right = head;
        int i = 0;
        while (i < n){
            i++;
            right = right.next;
        }
        if(right == null){
            return head.next;
        }
        while (right.next != null){
            right = right.next;
            left = left.next;
        }
        left.next = left.next.next;
        return head;
    }
}
