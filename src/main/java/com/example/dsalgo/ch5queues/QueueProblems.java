package com.example.dsalgo.ch5queues;

import com.example.dsalgo.ch4stacks.StackLinkedListImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Hardeep Singh
 */
@Service
public class QueueProblems {
    @Autowired
    QueueLinkedListImpl queueLinkedList;

    @Autowired
    StackLinkedListImpl stackLinkedList;

    public QueueLinkedListImpl reverseQueueUsingStack(QueueLinkedListImpl queue){
        stackLinkedList = new StackLinkedListImpl();

        while(!queue.isQueueEmpty()){
            int x = queue.deQueue();
            stackLinkedList.push(x);
        }

        while(!stackLinkedList.isEmptyStack()){
            int x = stackLinkedList.pop();
            queue.enQueue(x);
        }
        return queue;
    }
    /*Transfer queue elements to stack with 1st element of queue on top stack
        and reserve the order
     */
    public StackLinkedListImpl transferQueueToStack(QueueLinkedListImpl queue){
        stackLinkedList = new StackLinkedListImpl();

        while(!queue.isQueueEmpty()){
            stackLinkedList.push(queue.deQueue());
        }
        while(!stackLinkedList.isEmptyStack()){
            queue.enQueue(stackLinkedList.pop());
        }
        while (!queue.isQueueEmpty()){
            stackLinkedList.push(queue.deQueue());
        }
        return stackLinkedList;
    }

    /* Given stack of integers, check if pair is consecutive or not. Leave top
    if length of stack is odd
    */

    public boolean isPairConsecutive(StackLinkedListImpl stack){
        boolean isPairConsecutive = false;
        int check = 0;
        int length = stack.size();
        if(length % 2 == 0){
            while (!stack.isEmptyStack()){
                int x = stack.pop();
                int y = stack.pop();
                if(Math.abs(x-y) == 1){
                    check++;
                }
            }
        } else {
            stack.pop();
            while (!stack.isEmptyStack()){
                int x = stack.pop();
                int y = stack.pop();
                if(Math.abs(x-y) == 1){
                    check++;
                }
            }
        }
        return check == length/2;
    }

    // using queue
    public boolean isPairConsecutiveUsingQueue(StackLinkedListImpl stack){
        boolean isPairConsecutive = false;
        int check = 0;
        queueLinkedList = new QueueLinkedListImpl();

        // reverse stack
        while(!stack.isEmptyStack()){
            queueLinkedList.enQueue(stack.pop());
        }
        while(!queueLinkedList.isQueueEmpty()){
            stack.push(queueLinkedList.deQueue());
        }
        while(!stack.isEmptyStack()){
            int x = stack.pop();
            int y = stack.pop();
            if(Math.abs(x-y) == 1){
                check++;
            }
        }
        return check == stack.size()/2;
    }

    public QueueLinkedListImpl interleavingQueue(QueueLinkedListImpl queue){
        QueueLinkedListImpl queue1 = new QueueLinkedListImpl();
        QueueLinkedListImpl queue2 = new QueueLinkedListImpl();

        while(!queue.isQueueEmpty()){
            queue1.enQueue(queue.deQueue());
            if(!queue.isQueueEmpty()){
                queue2.enQueue(queue.deQueue());
            }
        }

        while(!queue1.isQueueEmpty() || !queue2.isQueueEmpty()){
            queue.enQueue(queue1.deQueue());
            queue.enQueue(queue2.deQueue());
        }
        return queue;
    }

    public QueueLinkedListImpl reverseQueueFirstKElements(QueueLinkedListImpl queue, int k){
        StackLinkedListImpl stack = new StackLinkedListImpl();
        QueueLinkedListImpl queue1 = new QueueLinkedListImpl();
        for (int i = 0; i<k; i++){
            stack.push(queue.deQueue());
        }
        while (!queue.isQueueEmpty()){
            queue1.enQueue(queue1.deQueue());
        }

        while (!stack.isEmptyStack()){
            queue.enQueue(stack.pop());
        }
        while(!queue1.isQueueEmpty()){
            queue.enQueue(queue1.deQueue());
        }
        return queue;
    }

    public Queue<Integer> queueReversal(Queue<Integer> queue){
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        while(!queue.isEmpty()){
            stack1.push(queue.poll());
        }
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        while(!stack2.isEmpty()){
            queue.add(stack2.pop());
        }
        return queue;
    }

    public Queue<Integer> reverseFirstKQueue(Queue<Integer> queue, int k){
        int i = 1;
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        // we can also use same queue
        Queue<Integer> temp = new LinkedList<>();

        while(i <= k){
            stack1.push(queue.poll());
        }
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        while(!queue.isEmpty()){
            temp.add(queue.poll());
        }
        while(!stack2.isEmpty()){
            queue.add(stack2.pop());
        }
        while(!temp.isEmpty()){
            queue.add(temp.poll());
        }
        return queue;
    }

    public void findFirstNonRepeating(String str){
        Queue<Character> queue = new LinkedList<>();
        int[] charCount = new int[26];

        for(int i = 0; i< str.length(); i++){
            char c = str.charAt(i);
            charCount[c - 'a'] = charCount[c-'a'] + 1;
            queue.add(c);
            while(!queue.isEmpty()){
                if(charCount[queue.peek()-'a'] > 1){
                    queue.poll();
                } else {
                    System.out.println(queue.peek() + "");
                    break;
                }
            }
            if(queue.isEmpty()){
                System.out.println(-1 + "");
            }
        }
    }
}
