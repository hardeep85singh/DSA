package com.example.dsalgo.leetcode.medium;

import com.example.dsalgo.leetcode.ListNode;
import com.example.dsalgo.leetcode.PrintLinkedList;

/**
 * @author Hardeep Singh
 */
public class M142LinkedListCycleII {
    public  static void main(String [] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(2);
        PrintLinkedList.printLinkedList(detectCycle(head));
    }
    public static ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == null || fast.next == null){
                return null;
            }
            if(fast == slow){
                slow = head;
                break;
            }
        }
        while (slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
