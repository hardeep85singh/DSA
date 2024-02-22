package com.example.dsalgo.leetcode.easy;

import com.example.dsalgo.leetcode.ListNode;
import com.example.dsalgo.leetcode.PrintLinkedList;

/**
 * @author Hardeep Singh
 */
public class E203RemoveLinkedListElements {
    public  static void main(String [] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(2);
        PrintLinkedList.printLinkedList(removeElements(head, 1));
    }

    public static ListNode removeElements(ListNode head, int val) {

        ListNode sentinel = new ListNode(0);
        ListNode prev = sentinel;
        sentinel.next = head;
        ListNode curr = head;

        while (curr != null){
            if(curr.val == val){
                prev.next = curr.next;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }
        return sentinel.next;
    }
}
