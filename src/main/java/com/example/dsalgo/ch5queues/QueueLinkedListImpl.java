package com.example.dsalgo.ch5queues;

import org.springframework.stereotype.Service;

/**
 * @author Hardeep Singh
 */
@Service
public class QueueLinkedListImpl {
    private static int size;
    private class Node{
        int data;
        Node next;
    }
    Node front;
    Node rear;

    public QueueLinkedListImpl(){
        this.front = null;
        this.rear = null;
    }

//    private Node tail;


    public void enQueue(int data){
        Node currentNode = new Node();
        currentNode.data = data;
        if(size == 0){
            front = currentNode;
        } else{
            rear.next = currentNode;
        }
        rear = currentNode;
        size++;
    }
    public int deQueue(){
        int result = 0;
        Node temp = front;
        if(size == 0){
            throw new IllegalArgumentException("Queue is empty");
        } else {
            front = front.next;
            result = temp.data;
        }
        size--;
        return result;
    }
    public int size(){
        return size;
    }
    public boolean isQueueEmpty(){
        return size == 0;
    }

    public void printQueue(){
        if(size == 0){
            throw new IllegalArgumentException("Queue is empty");
        } else {
            Node temp = front;
            while(temp != null){
                System.out.print(temp.data + "->");
                temp = temp.next;
            }
            System.out.println();
        }
    }

}
