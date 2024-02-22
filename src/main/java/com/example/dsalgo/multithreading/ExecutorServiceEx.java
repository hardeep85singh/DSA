package com.example.dsalgo.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class ExecutorServiceWorker implements Runnable{
    private int id;

    public ExecutorServiceWorker(int id){
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Using id: " + id + " with thread: "+ Thread.currentThread().getName());
        try {
            TimeUnit.MILLISECONDS.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
public class ExecutorServiceEx {
    public static void main(String[] args) {

//        ExecutorService service = Executors.newSingleThreadExecutor();
        ExecutorService service = Executors.newFixedThreadPool(5);
        for (int i = 1; i<= 10; i++){
            service.submit(new ExecutorServiceWorker(i));
        }
    }
}
