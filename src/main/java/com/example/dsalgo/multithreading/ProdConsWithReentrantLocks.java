package com.example.dsalgo.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Worker{
    private List<Integer> list = new ArrayList<>();
    private final static int UPPER_LIMIT = 5;
    private final static int LOWER_LIMIT = 0;
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    private int value = 0;


    public void produce() throws InterruptedException{
        lock.lock();
        try{
            while (true){
                if(list.size() == UPPER_LIMIT){
                    System.out.println("List is full, waiting for consumer to delete");
                    condition.await();
                } else {
                    System.out.println("Adding: " + value);
                    list.add(value);
                    value++;
                    condition.signal();
                }
                Thread.sleep(500);
            }
        } finally {
            lock.unlock();
        }
    }

    public void consume() throws InterruptedException{
        Thread.sleep(2000);
        lock.lock();
        try{
            Thread.sleep(1000);
            while (true){
                if(list.size() == LOWER_LIMIT){
                    System.out.println("List is empty, waiting for producer to add");
                    condition.await();
                } else {
                    int val = list.remove(list.size()-1);
                    System.out.println("Deleting: " + val);
                    value--;
                    condition.signal();
                }
                Thread.sleep(500);
            }
        } finally {
            lock.unlock();
        }
    }

}

public class ProdConsWithReentrantLocks {

    public static void main(String[] args) {
        Worker worker = new Worker();
        Thread t1 = new Thread(new Runnable(){
           @Override
           public void run(){
               try {
                   worker.produce();
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
        });

        Thread t2 = new Thread(new Runnable(){
            @Override
            public void run(){
                try {
                    worker.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
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
    }
}
