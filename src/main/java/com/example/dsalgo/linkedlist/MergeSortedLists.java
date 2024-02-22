package com.example.dsalgo.linkedlist;

public class MergeSortedLists {

    public ListNode merge(ListNode first, ListNode second){
        if(first == null){
            return second;
        }
        if(second == null){
            return first;
        }
        ListNode head = new ListNode();
        ListNode curr = head;
        while (first != null && second != null){
            if(first.val < second.val){
                curr.next = first;
                first = first.next;
            } else {
                curr.next = second;
                second = second.next;
            }
            curr = curr.next;
        }
        return head.next;
    }
}
