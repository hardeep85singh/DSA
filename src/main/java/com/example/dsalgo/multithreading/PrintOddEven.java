package com.example.dsalgo.multithreading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintOddEven {
    public static void main(String[] args) {
        PrintNumbersUsingLocks printNumbers = new PrintNumbersUsingLocks(20);

        Thread oddThread = new Thread(() -> printNumbers.printOdd(), "OddThread");
        Thread evenThread = new Thread(() -> printNumbers.printEven(), "EvenThread");

        oddThread.start();
        evenThread.start();
    }

}

class PrintNumbersUsingLocks{
    private int max;
    private volatile int n = 1;
    private final Lock lock = new ReentrantLock();
    private final Condition oddCondition = lock.newCondition();
    private final Condition evenCondition = lock.newCondition();

    public PrintNumbersUsingLocks(int max){
        this.max = max;
    }

    public void printOdd(){
        lock.lock();
        try {
            while (n <= max){
                if(n % 2 == 1){
                    System.out.println(Thread.currentThread().getName() + ": " + n);
                    n++;
                    evenCondition.signal();
                } else {
                    try {
                        oddCondition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        } finally {
            lock.unlock();
        }
    }

    public void printEven(){
        lock.lock();
        try {
            while (n <= max){
                if(n % 2 == 0){
                    System.out.println(Thread.currentThread().getName() + ": " + n);
                    n++;
                    oddCondition.signal();
                } else {
                    try {
                        evenCondition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        } finally {
            lock.unlock();
        }
    }
}

class PrintNumbers{
    private int max;
    private volatile int n = 1;

    public PrintNumbers(int max){
        this.max = max;
    }

    public void printOdd(){
        synchronized (this){
            while (n <= max){
                if(n % 2 == 1){
                    System.out.println(Thread.currentThread().getName() + ": " + n);
                    n++;
                    this.notify();
                } else {
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void printEven(){
        synchronized (this){
            while (n <= max){
                if(n % 2 == 0){
                    System.out.println(Thread.currentThread().getName() + ": " + n);
                    n++;
                    this.notify();
                } else {
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
