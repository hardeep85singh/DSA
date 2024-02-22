package com.example.dsalgo.linkedlist;

/**
 * @author Hardeep Singh
 */
public class ListNode {
    public int val;
    public ListNode next;
    private ListNode head;
    private ListNode tail;
    private int size;

    public ListNode(){}
    public ListNode(int val) {
        this.val = val;
        next = null;
    }
    public ListNode(int val , ListNode next){
        this.next = next;
        this.val = val;
    }

    public void insert(int val) {
        ListNode node = new ListNode(val);
        node.next = head;
        head = node;
        size++;
    }
}
