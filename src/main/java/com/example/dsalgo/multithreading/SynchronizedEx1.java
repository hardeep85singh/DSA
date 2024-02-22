package com.example.dsalgo.multithreading;

public class SynchronizedEx1 {
    static int counter = 0;
    public static synchronized void increment(){
        counter++;
    }
    public static void process(){
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 1000; i++) {
                    increment();
                }
            }
        });

        Thread t2 = new Thread (new Runnable() {
            @Override
            public void run(){
                for (int i = 1; i <= 1000; i++){
                    increment();
                }
            }
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Counter value is : " + counter);
    }
    public static void main(String[] args) {
        process();
    }
}