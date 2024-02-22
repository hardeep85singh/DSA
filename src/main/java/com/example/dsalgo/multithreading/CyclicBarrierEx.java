package com.example.dsalgo.multithreading;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class CyclicBarrierWorker implements Runnable{
    private int id;
    private CyclicBarrier barrier;

    public CyclicBarrierWorker(int id, CyclicBarrier barrier){
        this.id = id;
        this.barrier = barrier;
    }
    @Override
    public void run() {
        System.out.println("Thread with id " + this.id + " starts working...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            barrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}

public class CyclicBarrierEx {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(5);
        CyclicBarrier barrier = new CyclicBarrier(5, () -> System.out.println("All tasks finished"));

        for (int i = 0; i < 5; i++) {
            service.execute(new CyclicBarrierWorker(i +1 , barrier));
        }
        service.shutdown();
    }
}
