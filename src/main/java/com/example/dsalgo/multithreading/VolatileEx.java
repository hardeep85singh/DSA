package com.example.dsalgo.multithreading;

class VolatileWorker implements Runnable{
    private volatile boolean terminated;
    private volatile int count;
    @Override
    public void run() {
        while (!isTerminated()){
            System.out.println("Worker working: " + count);
            count++;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean isTerminated(){
        return this.terminated;
    }

    public void setTerminated(boolean terminated){
        this.terminated = terminated;
    }
}

public class VolatileEx {

    public static void main(String[] args) {
        VolatileWorker worker = new VolatileWorker();

        Thread t1 = new Thread(worker);
        t1.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        worker.setTerminated(true);
        System.out.println("Worker stopped");
    }
}
