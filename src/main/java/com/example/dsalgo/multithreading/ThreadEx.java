package com.example.dsalgo.multithreading;

class Runnable3 extends Thread{
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("Runnable3: " + i);
        }
    }
}

class Runnable4 extends Thread{
    @Override
    public void run(){
        for (int i = 1; i <= 10; i++) {
            System.out.println("Runnable4: " + i);
        }
    }
}
public class ThreadEx {
    public static void main(String[] args) {
        Thread t1 = new Runnable3();
        Thread t2 = new Runnable4();
        t1.start();
        t2.start();
    }
}
