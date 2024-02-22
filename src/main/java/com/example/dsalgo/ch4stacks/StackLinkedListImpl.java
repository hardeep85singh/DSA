package com.example.dsalgo.ch4stacks;

import org.springframework.stereotype.Service;

/**
 * @author Hardeep Singh
 */

@Service
public class StackLinkedListImpl {

    private static int size;

    private class Node{
        int data;
        Node next;
    }
    Node top;

    public StackLinkedListImpl(){
        this.top = null;
    }

    public void push(int data){
        Node currentNode = new Node();
        currentNode.data = data;
        if(top == null){
            currentNode.next = null;
        } else{
            currentNode.next = top;
        }
        top = currentNode;
        size++;
    }
    public int pop(){
        int result = 0;
        if(top == null){
            throw new IllegalArgumentException("Stack underflow");
        } else {
            result = top.data;
            top = top.next;
        }
        size--;
        return result;
    }

    public int size(){
        return size;
    }

    public int top(){
        if(!isEmptyStack()){
            return top.data;
        } else{
            throw new IllegalArgumentException("Stack is empty");
        }
    }

    public boolean isEmptyStack(){
        return size == 0;
    }


    public void printStack(){
        if (top == null) {
            System.out.printf("\nStack Underflow");
           return;
        }
        else {
            Node temp = top;
            while (temp != null) {
                System.out.printf("%d->", temp.data);
                temp = temp.next;
            }
            System.out.println();
        }
    }
}
