package com.example.dsalgo.leetcode.medium;

import com.example.dsalgo.leetcode.ListNode;

import java.util.List;

/**
 * @author Hardeep Singh
 */
public class M82RemoveDuplicatesFromSortedListII {
    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(2);
        System.out.println(deleteDuplicates(head).val);
    }
    public static ListNode deleteDuplicates(ListNode head) {

        ListNode sentinel = new ListNode(-1);
        sentinel.next = head;
        ListNode prev = sentinel;
        ListNode curr = head;
        while (curr != null){
            if (curr.next != null && curr.val == curr.next.val) {
                // move till the end of duplicates sublist
                while (curr.next != null && curr.val == curr.next.val) {
                    curr = curr.next;
                }
                // skip all duplicates
                prev.next = curr.next;
                // otherwise, move predecessor
            } else {
                prev = prev.next;
            }
            // move forward
            curr = curr.next;
        }
        return sentinel.next;
    }
}
