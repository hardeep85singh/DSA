package com.example.dsalgo.leetcode.easy;

import com.example.dsalgo.leetcode.ListNode;
import com.example.dsalgo.leetcode.PrintLinkedList;

/**
 * @author Hardeep Singh
 */
public class E21MergeTwoSortedList {
    public static void main(String[] args){
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(3);
        list1.next.next = new ListNode(6);
        ListNode list2 = new ListNode(2);
        list2.next = new ListNode(4);
        list2.next.next = new ListNode(5);
//        PrintLinkedList.printLinkedList(mergeTwoLists(list1, list2));
        PrintLinkedList.printLinkedList(mergeTwoListsRecursive(list1, list2));
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        ListNode head ;
        ListNode curr = new ListNode(0);
        head = curr;
        while (list1 != null && list2 != null){
            if(list1.val <= list2.val){
                curr.next = list1;
                curr = curr.next;
                list1 = list1.next;
            } else {
                curr.next = list2;
                curr = curr.next;
                list2 = list2.next;
            }
        }
        while (list1 != null){
            curr.next = list1;
            curr = curr.next;
            list1 = list1.next;
        }
        while (list2 != null){
            curr.next = list2;
            curr = curr.next;
            list2 = list2.next;
        }
        return head.next;
    }
    public static ListNode mergeTwoListsRecursive(ListNode list1, ListNode list2){
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }

        if(list1.val <= list2.val){
            list1.next = mergeTwoListsRecursive(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoListsRecursive(list1, list2.next);
            return list2;
        }
    }
}
