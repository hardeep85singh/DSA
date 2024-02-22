package com.example.dsalgo.leetcode.medium;

/**
 * @author Hardeep Singh
 */
public class M02AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
//        l2.next.next.next = new ListNode(9);
        ListNode node = addTwoNumbers(l1, l2);
        printList(node);
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode newHead;
        ListNode curr = new ListNode(-1);
        newHead = curr;
        ListNode temp;
        while(l1 != null && l2 != null){
            int num1 = l1.val;
            int num2 = l2.val;
            int sum = num1 + num2 + carry;
            if(sum >= 10){
                carry = 1;
                sum = sum % 10;
            } else {
                carry = 0;
            }
            temp = new ListNode(sum);
            curr.next = temp;
            curr = curr.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1 != null){
            int sum = l1.val + carry;
            if(sum >= 10){
                carry = 1;
                sum = sum % 10;
            } else {
                carry = 0;
            }
            temp = new ListNode(sum);
            curr.next = temp;
            curr = curr.next;
            l1 = l1.next;
        }
        while(l2 != null){
            int sum = l2.val + carry;
            if(sum >= 10){
                carry = 1;
                sum = sum % 10;
            } else {
                carry = 0;
            }
            temp = new ListNode(sum);
            curr.next = temp;
            curr = curr.next;
            l2 = l2.next;
        }

        if(carry == 1){
            temp = new ListNode(1);
            curr.next = temp;
        }
        return newHead.next;
    }

    public static void printList(ListNode node){
        if (node == null){
            return;
        }
        while (node != null){
            System.out.print(node.val + "->");
            node = node.next;
        }
    }
}
