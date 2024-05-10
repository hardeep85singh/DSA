package com.example.dsalgo.leetcode.medium;

import com.example.dsalgo.leetcode.ListNode;
import com.example.dsalgo.leetcode.PrintLinkedList;

public class M2487RemoveNodesFromLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        head.next = new ListNode(2);
        head.next.next = new ListNode(13);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(8);
        PrintLinkedList.printLinkedList(head);
    }

    public static ListNode removeNodes(ListNode head) {
        ListNode curr = head;
        while (curr != null){
            if(curr.next.val < curr.val){
                curr = curr.next;
            } else {

            }
        }
        return head;
    }
}
