package com.example.dsalgo.linkedlist;

public class FirstNodeOfCycle {

    public static int firstNodeOfCycle(ListNode head){
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                break;
            }
        }
        if(fast != slow){
            return -1;
        }
        fast = head;
        while (slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow.val;
    }
}
