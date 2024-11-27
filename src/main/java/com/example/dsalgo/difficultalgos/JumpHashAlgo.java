package com.example.dsalgo.difficultalgos;

import java.util.Random;

public class JumpHashAlgo {

    public static int jumpHash(long key, int numBuckets){
        long b = -1;
        long j = 0;
        while (j < numBuckets){
            b = j;
            key = key * 2862933555777941757L + 1;
            j = (long) ((b + 1) * (1L << 31) / ((key >>> 33) + 1));
        }
        return (int) Math.abs(b);
    }

    public static void main(String[] args) {
        int numBuckets = 10;
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            long key = random.nextLong();
            int bucket = jumpHash(key, numBuckets);
            System.out.println("Key: " + key + " is assigned to bucket: " + bucket);
        }
    }
}
