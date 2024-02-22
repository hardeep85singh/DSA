package com.example.dsalgo.linkedlist;

import java.util.Scanner;

public class GenerateLinkedList {

    public static ListNode generateList() {
        Scanner scanner = new Scanner(System.in);
        ListNode node = new ListNode();
        System.out.print("Input length of list: ");
        int length = scanner.nextInt();
        System.out.print("Insert values: ");
        while (length > 0){
            int val = scanner.nextInt();
            node.insert(val);
            length--;
        }
        scanner.close();
        return node;
    }
}
