package com.example.dsalgo.linkedlist;

public class LLMain {
    public static void main(String[] args) {
        LL linkedList = new LL();
        linkedList.insertFirst(1);
        linkedList.insertLast(4);
        linkedList.insertLast(5);
        linkedList.insertFirst(2);
        linkedList.insert(9, 2);
        linkedList.insert(12, 5);
        linkedList.print();
        linkedList.deleteFirst();
        linkedList.print();
        linkedList.deleteLast();
        linkedList.print();
        linkedList.delete(2);
        linkedList.print();
    }
}
