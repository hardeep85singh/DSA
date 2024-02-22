package com.example.dsalgo.leetcode.medium;

import com.example.dsalgo.leetcode.ListNode;
import com.example.dsalgo.leetcode.PrintLinkedList;

/**
 * @author Hardeep Singh
 */
public class M369PlusOneLinkedList {
    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(9);
        head.next.next = new ListNode(9);
        PrintLinkedList.printLinkedList(plusOneSentinel(head));
    }
    public static ListNode plusOneSentinel(ListNode head){
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode notNine = sentinel;
        while (head != null){
            if(head.val != 9){
                notNine = head;
            }
            head = head.next;
        }
        notNine.val++;
        notNine = notNine.next;
        while (notNine != null){
            notNine.val = 0;
            notNine = notNine.next;
        }
        if(sentinel.val != 0){
            return sentinel;
        } else {
            return sentinel.next;
        }
    }
    public static ListNode plusOneReverse(ListNode head) {
        head = reverse(head);
        int carry = 1;
        ListNode curr = head;
        ListNode temp = null;
        int sum;
        while(curr != null){
            sum = carry + curr.val;
            if(sum >= 10){
                carry = 1;
            } else {
                carry = 0;
            }
            sum = sum % 10;
            curr.val = sum;
            temp = curr;
            curr = curr.next;
        }

        if(carry == 1){
            temp.next = new ListNode(carry);
        }
        head = reverse(head);
        return head;
    }

    public static ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        ListNode next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
