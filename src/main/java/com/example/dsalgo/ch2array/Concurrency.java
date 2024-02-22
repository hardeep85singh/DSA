package com.example.dsalgo.ch2array;

/**
 * @author Hardeep Singh
 */
public class Concurrency {
    public static void main(String[] args){
        Thread evenThread = new Thread();
        Thread oddThread = new Thread();
        int n = 100;
        printNumbers(n, evenThread, oddThread);
    }
    Thread evenThread = new Thread();
    Thread oddThread = new Thread();
    public static void printNumbers(int n, Thread evenThread, Thread oddThread) {
//        Thread even = new Thread(new Runnable() {
//            public void run() { printEven(n); }
//        });


        for(int i = 0; i< n; i++){
            if(i % 2 == 0){
                int finalI = i;
                evenThread.run();
            } else {
                int finalI1 = i;
                oddThread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        printOdd(finalI1);
                    }
                });
                oddThread.start();
            }
        }
//        evenThread.start();
//        oddThread.start();
    }

    public synchronized static void printEven(int n){
        System.out.print(n + ": ");
    }
    public synchronized static void printOdd(int n){
        System.out.print(n + ": ");
    }
}
