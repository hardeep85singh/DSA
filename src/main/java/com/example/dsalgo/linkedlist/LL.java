package com.example.dsalgo.linkedlist;

public class LL {

    private Node head;
    private Node tail;
    private int size;

    public LL (){
        this.size = 0;
    }

    public void insertFirst(int val){
        Node node = new Node(val);
        node.next = head;
        head = node;
        if(tail == null){
            tail = head;
        }
        size++;
    }

    public void insertLast(int val){
        Node node = new Node(val);
        tail.next = node;
        tail = node;
        if(head == null){
            head = tail;
        }
        size++;
    }

    public void insert(int val, int index){
        if(index == 0){
            insertFirst(val);
            return;
        }
        if(index == size){
            insertLast(val);
            return;
        }
        Node node = new Node(val);
        Node current = head;
        for (int i = 1; i < index; i++) {
            current = current.next;
        }
        node.next = current.next;
        current.next = node;
        size++;
    }

    // insert using recursion
    public void insertUsingRecursion(int val, int index){
        if(index == 0){
            insertFirst(val);
            return;
        }
        if(index == size){
            insertLast(val);
            return;
        }
        head = insertUsingRecursionHelper(val, index, head);
    }

    private Node insertUsingRecursionHelper(int val, int index, Node node) {
        if(index == 0){
            Node temp = new Node(val, node);
            size++;
            return temp;
        }
        node.next = insertUsingRecursionHelper(val, index-1, node.next);
        return node;
    }

    public int deleteFirst(){
        if(head == null){
            return -1;
        }
        int value = head.value;
        head = head.next;
        size--;
        return value;
    }

    public int deleteLast(){
        if(tail == null){
            return -1;
        }
        Node current = head;
        while (current.next != tail){
            current = current.next;
        }
        tail = current;
        tail.next = null;
        size--;
        return tail.value;
    }

    public int delete(int index){
        if(index == 0){
            return deleteFirst();
        }
        if(index == size){
            return deleteLast();
        }
        Node prev = head;
        for (int i = 1; i < index; i++) {
            prev = prev.next;
        }
        int value = prev.value;
        prev.next = prev.next.next;
        size--;
        return value;
    }

    public void print(){
        Node temp = head;
        while (temp != null){
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("End");
    }

    private class Node{
        private int value;
        private Node next;

        public Node(int value){
            this.value = value;
        }
        public Node(int value, Node next){
            this.value = value;
            this.next = next;
        }
    }
}
