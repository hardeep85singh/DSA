package com.example.dsalgo.multithreading;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class LatchWorker implements Runnable{
    private int id;
    private CountDownLatch latch;

    public LatchWorker(int id, CountDownLatch latch){
        this.id = id;
        this.latch = latch;
    }

    @Override
    public void run() {
        System.out.println("Thread with id " + this.id + " starts working...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        latch.countDown();
    }
}
public class LatchEx {

    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(5);
        ExecutorService service = Executors.newSingleThreadExecutor();

        for (int i = 0; i < 5; i++) {
            service.execute(new LatchWorker(i, latch));
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("All tasks have been finished");
        service.shutdown();
    }
}
