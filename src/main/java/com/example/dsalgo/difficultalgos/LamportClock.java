package com.example.dsalgo.difficultalgos;

public class LamportClock {

    private int time = 0;

    private synchronized void tick(){
        time++;
    }

    private synchronized void sendEvent(){
        tick();
    }

    private synchronized void receiveEvent(int receivedTime){
        time = Math.max(time, receivedTime) + 1;
    }

    private synchronized int getTime(){
        return time;
    }
}
