package com.example.dsalgo.ch4stacks;

/**
 * @author Hardeep Singh
 */
public class StackImplDoublyLinkedList {

    class Node{
        int data;
        Node next;
        Node previous;
        public Node(int data){
            this.data = data;
        }
    }
    int count;
    Node head;
    Node mid;
    public StackImplDoublyLinkedList(Node head, Node mid, int count){
        head = null;
        mid = null;
        count = 0;
    }
    public void push(int data){
        Node temp = new Node(data);
        temp.next = head;
        temp.previous = null;
        count++;
        if(count == 1){
            mid = head;
        } else{
            head.previous = temp;
            if(count % 2 != 0){
                mid = mid.previous;
            }
        }
        head = temp;
    }

    public int pop(){
        if(head == null){
            throw new IllegalArgumentException("Stack is empty");
        }
        Node temp = head;
        int result = temp.data;
        head = head.next;
        head.previous = null;
        mid = mid.next;
        count--;
        return result;
    }

    public int peek(){
        if(head == null){
            throw new IllegalArgumentException("Stack is empty");
        }
        return head.data;
    }

    public void pushMiddle(int data){
        Node temp = new Node(data);
        temp.previous = mid.previous;
        mid.previous = temp;
        temp.next = mid;
        mid = temp;
        count++;
    }

    public int findMiddle(){
        if(mid == null){
            throw  new IllegalArgumentException("Stack is empty");
        }
        return mid.data;
    }

    public int deleteMiddle(){
        if(mid == null){
            throw new IllegalArgumentException("Stack is empty");
        }
        int data = mid.data;
        Node temp = mid.previous;
        temp.next = mid.next;
        mid.next.previous = temp;
        mid.next = null;
        mid.previous = null;
        mid = temp;
        count--;
        return data;
    }
}
