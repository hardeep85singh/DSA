package com.example.dsalgo.leetcode.easy;

import java.util.Stack;

/**
 * @author Hardeep Singh
 */
public class E232ImplementQueueUsingStacks {
    public static void main(String[] args) {
        MyQueue obj = new MyQueue();
        obj.push(1);
        int param_2 = obj.pop();
        int param_3 = obj.peek();
        boolean param_4 = obj.empty();
        System.out.println(param_2);
        System.out.println(param_3);
        System.out.println(param_4);
    }

    static class MyQueue {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        private int front;

        public MyQueue() {
        }

        public void push(int x) {
            if (stack1.empty())
                front = x;
            stack1.push(x);
        }

        public int pop() {
            if(stack2.isEmpty()){
                while (!stack1.empty()){
                    stack2.push(stack1.pop());
                }
            }
            return stack2.pop();
        }

        public int peek() {
            if (!stack2.isEmpty()) {
                return stack2.peek();
            }
            return front;
        }

        public boolean empty() {
            return stack1.empty() && stack2.empty();
        }
    }
}
