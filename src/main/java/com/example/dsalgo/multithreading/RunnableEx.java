package com.example.dsalgo.multithreading;

class Runnable1 implements Runnable{

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("Runnable1: " + i);
        }
    }
}

class Runnable2 implements Runnable{

    @Override
    public void run(){
        for (int i = 1; i <= 10; i++) {
            System.out.println("Runnable2: " + i);
        }
    }
}

public class RunnableEx {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable1());
        Thread t2 = new Thread(new Runnable2());
        t1.start();
        t2.start();
    }
}
