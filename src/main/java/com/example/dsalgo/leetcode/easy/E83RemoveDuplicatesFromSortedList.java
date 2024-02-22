package com.example.dsalgo.leetcode.easy;

import com.example.dsalgo.leetcode.ListNode;
import com.example.dsalgo.leetcode.PrintLinkedList;

/**
 * @author Hardeep Singh
 */
public class E83RemoveDuplicatesFromSortedList {
    public static void main(String [] args){
        ListNode head = new ListNode(1);;
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);
        PrintLinkedList.printLinkedList(removeDuplicatesFromSortedList(head));
    }
    public static ListNode deleteDuplicates(ListNode head){
        ListNode curr = head;
        while(curr != null && curr.next != null){
            if(curr.val == curr.next.val){
                curr.next = curr.next.next;
            } else{
                curr = curr.next;
            }
        }
        return head;
    }

    public static ListNode removeDuplicatesFromSortedList(ListNode head){
        ListNode current = head;
        ListNode link = head;
        while(current.next != null){
            current = current.next;
            if(current.val != link.val){
                link.next = current;
                link = current;
            }
        }
        link.next = null;
        return head;
    }
}
