package com.example.dsalgo.leetcode.hard;

import com.example.dsalgo.leetcode.ListNode;
import com.example.dsalgo.leetcode.PrintLinkedList;

/**
 * @author Hardeep Singh
 */
public class H25ReverseNodesInKGroup {
    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        PrintLinkedList.printLinkedList(reverseKGroupIterative(head, 2));
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;
        while (count < k && curr != null){
            curr = curr.next;
            count++;
        }
        if(count == k){
            ListNode reverseHead = reverse(head, k);
            head.next = reverseKGroup(curr, k);
            return reverseHead;
        }
        return head;
    }

    public static ListNode reverse(ListNode head, int k){
        ListNode prev = null;
        ListNode curr = head;
        ListNode next;
        while (k > 0){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            k--;
        }
        return prev;
    }

    public static ListNode reverseKGroupIterative(ListNode head, int k){
        ListNode curr = head;
        ListNode newHead = null;
        ListNode kTail = null;

        while (curr != null){
            int count = 0;
            curr = head;
            while(count < k && curr != null){
                curr = curr.next;
                count ++;
            }
            if(count == k){
                ListNode revHead = reverse(head, k);
                if( newHead == null){
                    newHead = revHead;
                }
                if(kTail != null){
                    kTail.next = revHead;
                }
                kTail = head;
                head = curr;
            }
        }
        if(head != null){
            kTail.next = head;
        }
        if(newHead == null){
            return head;
        } else  {
            return newHead;
        }
    }
}
