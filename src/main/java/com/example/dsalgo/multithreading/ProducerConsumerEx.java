package com.example.dsalgo.multithreading;

import java.util.ArrayList;
import java.util.List;

class Processor{

    private List<Integer> list = new ArrayList<>();
    private final static int UPPER_LIMIT = 5;
    private final static int LOWER_LIMIT = 0;
    private final Object lock = new Object();
    private int value = 0;

    public void producer() throws InterruptedException {
        synchronized(lock){
            while (true){
                if(list.size() == UPPER_LIMIT){
                    System.out.println("List is full, waiting for consumer to delete");
                    lock.wait();
                } else {
                    System.out.println("Adding: " + value);
                    list.add(value);
                    value++;
                    lock.notify();
                }
                Thread.sleep(500);
            }
        }
    }

    public void consumer() throws InterruptedException {
        synchronized (lock){
            Thread.sleep(1000);
            while (true){
                if(list.size() == LOWER_LIMIT){
                    System.out.println("List is empty, waiting for producer to add");
                    lock.wait();
                } else {
                    int val = list.remove(list.size()-1);
                    System.out.println("Deleting: " + val);
                    value--;
                    lock.notify();
                }
                Thread.sleep(500);
            }
        }
    }
}

public class ProducerConsumerEx {
    public static void main(String[] args) {
        Processor processor = new Processor();

        Thread t1 = new Thread(new Runnable(){
            @Override
            public void run(){
                try {
                    processor.producer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable(){
            @Override
            public void run(){
                try {
                    processor.consumer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
    }
}
