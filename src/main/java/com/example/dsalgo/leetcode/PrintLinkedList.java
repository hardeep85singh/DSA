package com.example.dsalgo.leetcode;

/**
 * @author Hardeep Singh
 */
public class PrintLinkedList {
    public static void printLinkedList(ListNode head){
        if(head == null){
            System.out.println("List is empty");
        }
        while (head != null){
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println();
    }
}
