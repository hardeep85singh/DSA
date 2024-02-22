package com.example.dsalgo.leetcode;

/**
 * @author Hardeep Singh
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(){}
    public ListNode(int val) {
        this.val = val;
        next = null;
    }
    public ListNode(int val , ListNode next){
        this.next = next;
        this.val = val;
    }
}
