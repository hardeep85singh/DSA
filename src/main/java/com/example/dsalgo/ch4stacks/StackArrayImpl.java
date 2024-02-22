package com.example.dsalgo.ch4stacks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Hardeep Singh
 */
@Service
public class StackArrayImpl {

    private static int[] stack;
    private static int size;

    public StackArrayImpl(int[] stack){
        this.stack = new int[5];
    }

    public void push(int data){
        if(size == stack.length){
            throw new IllegalArgumentException("No more items can be pushed, stack is overflowed");
        } else{
            stack[size] = data;
            size++;
        }
    }
    public int pop(){
        int result = 0;
        if(size == 0){
            throw new IllegalArgumentException("No items to remove, stack is underflowed");
        } else{
            result = stack[size-1];
            stack[size-1] = 0;
            size--;
        }
        return result;
    }

    public int size(){
        return size;
    }

    public int top(){
        if(size == 0){
            throw new IllegalArgumentException("No items to remove, stack is underflowed");
        } else{
            return stack[size-1];
        }
    }

    public boolean isEmptyStack(){
        return size == 0;
    }

    public boolean isFullStack(){
        return stack.length == size;
    }

    public void printStack(){
        for(int i : stack){
            System.out.print(i + " ");
        }
    }
}
