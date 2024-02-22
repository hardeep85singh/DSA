package com.example.dsalgo.leetcode.easy;

import com.example.dsalgo.leetcode.ListNode;
import com.example.dsalgo.leetcode.PrintLinkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Hardeep Singh
 */
public class E160IntersectionOfTwoLinkedLists {
    public static void main(String[] args){
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(3);
        list1.next.next = new ListNode(6);
        list1.next.next.next = new ListNode(9);
        ListNode list2 = new ListNode(2);
        list2.next = new ListNode(4);
        list2.next.next = new ListNode(5);
        list2.next.next.next = new ListNode(6);
        list2.next.next.next.next = new ListNode(9);
//        PrintLinkedList.printLinkedList(mergeTwoLists(list1, list2));
        PrintLinkedList.printLinkedList(getIntersectionNode(list1, list2));
    }
    public static ListNode getIntersectionNodeOneIteration(ListNode headA, ListNode headB){
        ListNode pA = headA;
        ListNode pB = headB;
        // pA will iterate on a length and then set to headB for b length
        // pB will iterate on b length and then set to headA for a length
        while (pA != pB) {
            if(pA == null){
                pA = headB;
            } else {
                pA = pA.next;
            }
            if(pB == null){
                pB = headA;
            } else {
                pB = pB.next;
            }
//            pA = pA == null ? headB : pA.next;
//            pB = pB == null ? headA : pB.next;
        }
        return pA;
        // Note: In the case lists do not intersect, the pointers for A and B
        // will still line up in the 2nd iteration, just that here won't be
        // a common node down the list and both will reach their respective ends
        // at the same time. So pA will be NULL in that case.
    }
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int aLength = 0;
        int bLength = 0;
        ListNode currA = headA;
        ListNode currB = headB;
        while (currA != null){
            aLength++;
            currA = currA.next;
        }
        while (currB != null){
            bLength++;
            currB = currB.next;
        }
        if(aLength > bLength){
            currA = headA;
            currB = headB;
        } else {
            currA = headB;
            currB = headA;
        }
        int n = Math.abs(aLength-bLength);
        int count = 0;
        while (count < n){
            currA = currA.next;
            count++;
        }
        while (currA != null && currB != null){
            if(currA == currB){
                return currA;
            }
            currA = currA.next;
            currB = currB.next;
        }
        return null;
    }
    public static ListNode getIntersectionNodeHashset(ListNode headA, ListNode headB) {
        Set<ListNode> nodesInB = new HashSet<ListNode>();

        while (headB != null) {
            nodesInB.add(headB);
            headB = headB.next;
        }

        while (headA != null) {
            // if we find the node pointed to by headA,
            // in our set containing nodes of B, then return the node
            if (nodesInB.contains(headA)) {
                return headA;
            }
            headA = headA.next;
        }

        return null;
    }
}
