package com.example.dsalgo.ch5queues;

import org.springframework.stereotype.Service;

/**
 * @author Hardeep Singh
 */
@Service
public class QueueDoublyLinkedList {
    private static int size;

    private class Node{
        int data;
        Node next;
        Node previous;
    }
    Node front;
    Node rear;

    public QueueDoublyLinkedList() {
        this.front = null;
        this.rear = null;
    }

    public void insertFront(int data){
        Node currentNode = new Node();
        currentNode.data = data;
        if(size == 0){
            front = currentNode;
            rear = currentNode;
        } else{
            currentNode.next = front;
            front.previous = currentNode;
            front = currentNode;
        }
        size++;
    }

    public void insertRear(int data){
        Node currentNode = new Node();
        currentNode.data = data;
        if(size == 0){
            front = rear = currentNode;
        } else {
            rear.next = currentNode;
            currentNode.previous = rear;
            rear = currentNode;
        }
        size++;
    }

    public int deleteFront(){
        int result = 0;
        if(front == null){
            throw new IllegalArgumentException("Queue underflow");
        } else{
            Node temp = front;
            result = temp.data;
            front = front.next;
            front.previous = null;
        }
        size--;
        return result;
    }

    public int deleteRear(){
        int result = 0;
        if(rear == null){
            throw new IllegalArgumentException("Queue underflow");
        } else{
            Node temp = rear;
            result = temp.data;
            rear = rear.previous;
            rear.next = null;
        }
        size--;
        return result;
    }

    public int getFront(){
        if(size == 0){
            throw new IllegalArgumentException("Queue is empty");
        } else{
            return front.data;
        }
    }

    public int getRear(){
        if(size == 0){
            throw new IllegalArgumentException("Queue is empty");
        } else{
            return rear.data;
        }
    }

    public int size(){
        return size;
    }

    public boolean isQueueEmpty(){
        return size == 0;
    }

    public void printQueue(){
        if(size == 0){
            throw new IllegalArgumentException("Queue Underflow");
        } else {
            Node temp = front;
            while(temp != rear){
                System.out.print(temp.data + "->");
                temp = temp.next;
            }
            System.out.println();
        }
    }

}
