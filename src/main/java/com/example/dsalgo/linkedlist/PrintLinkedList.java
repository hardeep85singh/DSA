package com.example.dsalgo.linkedlist;

public class PrintLinkedList {
    public static void printLinkedList(ListNode node){
        if(node == null){
            System.out.println("List is empty");
        }
        while (node != null){
            System.out.print(node.val + "->");
            node = node.next;
            if(node == null){
                System.out.println("null");
            }
        }
        System.out.println();
    }
}
