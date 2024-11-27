package com.example.dsalgo.leetcode.hard;

import java.util.PriorityQueue;
import java.util.Queue;

public class H502IPO {

    public static void main(String[] args) {
        int[] profits = {5, 2, 3};
        int[] capital = {4, 2, 0};
        System.out.println(findMaximizedCapital(2, 0, profits, capital));
    }

    public static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        Queue<T> minHeap = new PriorityQueue<>((a, b) -> a.cap - b.cap);
        Queue<T> maxHeap = new PriorityQueue<>((a, b) -> b.pro - a.pro);

        for (int i = 0; i < capital.length; i++) {
            minHeap.offer(new T(profits[i], capital[i]));
        }

        while (k != 0) {
            while (!minHeap.isEmpty() && minHeap.peek().cap <= w) {
                maxHeap.offer(minHeap.poll());
            }
            if (maxHeap.isEmpty()) {
                break;
            }
            w += maxHeap.poll().pro;
            k--;
        }

        return w;
    }


    static class T {
        public int pro;
        public int cap;
        public T(int pro, int cap) {
            this.pro = pro;
            this.cap = cap;
        }
    }
}
