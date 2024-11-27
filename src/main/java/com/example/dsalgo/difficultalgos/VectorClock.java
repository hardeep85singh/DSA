package com.example.dsalgo.difficultalgos;

import java.util.ArrayList;
import java.util.Arrays;

public class VectorClock {
    private int[] vector;
    private int pid;

    public VectorClock(int numOfProcesses, int pid){
        this.vector = new int[numOfProcesses];
        this.pid = pid;
    }

    private synchronized void tick(){
        vector[pid]++;
    }

    public synchronized void sendEvent(){
        tick();
    }

    public synchronized void receiveEvent(int[] receivedVector){
        for (int i = 0; i < vector.length; i++){
            vector[i] = Math.max(vector[i], receivedVector[i]);
        }
        vector[pid]++;
    }

    public synchronized int[] getVector(){
        return Arrays.copyOf(vector, vector.length);
    }
}
