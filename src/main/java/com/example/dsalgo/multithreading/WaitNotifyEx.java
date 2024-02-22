package com.example.dsalgo.multithreading;

class Prod{
    int counter = 0;

    public void produce(){
        synchronized (this){
            for (int i = 1; i <= 100; i++) {
                counter++;
            }
            System.out.println("Start producing");
            System.out.println("Counter before wait: " + counter);
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Counter after wait: " + counter);
        }
    }

    public void consume(){
        synchronized (this){
            // sleep to make sure that consume() will run after produce()
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Start consuming");
            for (int i = 1; i <= 100; i++) {
                counter++;
            }
            System.out.println("Counter before notify: " + counter);
            notify();
            System.out.println("Counter after notify: " + counter);
        }
    }
}

public class WaitNotifyEx {

    public static void main(String[] args) {
        Prod prod = new Prod();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                prod.produce();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                prod.consume();
            }
        });
        t1.start();
        t2.start();
    }
}
