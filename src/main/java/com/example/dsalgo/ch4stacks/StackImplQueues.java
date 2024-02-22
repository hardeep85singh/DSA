package com.example.dsalgo.ch4stacks;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Hardeep Singh
 */
public class StackImplQueues {
    Queue<Integer> queue1;
    Queue<Integer> queue2;

    public StackImplQueues(Queue<Integer> queue1, Queue<Integer> queue2) {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int data) {
        queue1.add(data);
    }

    public int pop() {
        if (queue1.isEmpty()) {
            throw new IllegalArgumentException("Stack is empty");
        }
        while(queue1.size() != 1){
            queue2.add(queue1.poll());
        }
        int poll = queue1.poll();
        while(!queue2.isEmpty()){
            queue1.add(queue2.poll());
        }
        return poll;
    }

    public int peek(){
        if (queue1.isEmpty()) {
            throw new IllegalArgumentException("Stack is empty");
        }

        while(queue1.size() != 1){
            queue2.add(queue1.poll());
        }
        int peek = queue1.peek();
        queue2.add(queue1.poll());
        while (!queue2.isEmpty()){
            queue1.add(queue2.poll());
        }
        return peek;
    }
}
