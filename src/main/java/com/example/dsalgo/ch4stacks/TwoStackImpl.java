package com.example.dsalgo.ch4stacks;

/**
 * @author Hardeep Singh
 */
public class TwoStackImpl {
    int top1;
    int top2;
    public static int size;
    private int [] twoStack;

    public TwoStackImpl(int n){
        size = n;
        twoStack = new int[n];
        top1 = n/2 + 1;
        top2 = n/2;
    }

    public void pushStack1(int data){

        if(top1 > 0){
            top1 --;
            twoStack[top1] = data;
        } else {
            System.out.println("Stack overflown");
        }
    }

    public void pushStack2(int data){
        if(top2 < size-1){
            top2++;
            twoStack[top2] = data;
        } else{
            System.out.println("Stack overflow");
        }
    }

    public int popStack1(){
        if(top1 > size/2 +1){
            System.out.println("Stack underflow");
        } else{
            int pop = twoStack[top1];
            top1++;
            return pop;
        }
        return 0;
    }

    public int popStack2(){
        if(top2 < size/2){
            System.out.println("Stack underflow");
        } else {
            int pop = twoStack[top2];
            top2--;
            return pop;
        }
        return 0;
    }

    public int peekStack1(){
        if(top1 > size / 2 + 1){
            System.out.println("Stack underflow");
        } else {
            return twoStack[top1];
        }
        return 0;
    }

    public int peekStack2(){
        if(top2 < size /2 ){
            System.out.println("Stack underflow");
        } else{
            return twoStack[top2];
        }
        return 0;
    }

}
