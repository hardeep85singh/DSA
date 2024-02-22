package com.example.dsalgo.heapsandhashing;

/**
 * @author Hardeep Singh
 */
public class MinHeap {
    public int[] heapArray;
    public int capacity;
    public int heapSize;

    public MinHeap(int capacity) {
        this.capacity = capacity;
        this.heapSize = 0;
        heapArray = new int[capacity + 1];
        heapArray[0] = Integer.MIN_VALUE;
    }

    public int parent(int i) {
        return (i - 1) / 2;
    }

    public int leftChild(int i) {
        return (2 * i) + 1;
    }

    public int rightChild(int i) {
        return (2 * i) + 2;
    }

    public boolean isLeaf(int i) {
        if (i == heapSize / 2 && i <= heapSize) {
            return true;
        }
        return false;
    }

    public int getMinimum() {
        return heapArray[0];
    }

    public int extractMinimum() {
        if (heapSize == 0) {
            return -1;
        }
        return -1;
    }

    public void swap(int firstPos, int secondPos){
        int temp = heapArray[firstPos];
        heapArray[firstPos] = heapArray[secondPos];
        heapArray[secondPos] = temp;
    }

    public void minHeapify(int pos){
        // if node is non-leaf and greater than any of its child
        if(!isLeaf(pos)){
            if(heapArray[pos] > heapArray[leftChild(pos)]
                    || heapArray[pos] > heapArray[rightChild(pos)]){
                // Swap the left child and heapify the left child
                if(heapArray[leftChild(pos)] < heapArray[rightChild(pos)]){
                    swap(leftChild(pos), rightChild(pos));
                    minHeapify(leftChild(pos));
                } else {
                    swap(rightChild(pos), leftChild(pos));
                    minHeapify(rightChild(pos));
                }

            }
        }
    }

    public void insert(int element){
        if(heapSize >= capacity){
            return;
        }
        heapArray[heapSize++] = element;
        int  current = heapSize;
        while(heapArray[current] < heapArray[parent(current)]){
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public void print(){
        for(int i = 0; i<= heapSize /2; i++){
            // Printing the parent and both childrens
            System.out.print(
                    " PARENT : " + heapArray[i]
                            + " LEFT CHILD : " + heapArray[2 * i]
                            + " RIGHT CHILD :" + heapArray[2 * i + 1]);

            // By here new line is required
            System.out.println();
        }
    }

    public int remove(){
        int popped = heapArray[0];
        heapArray[0] = heapArray[heapSize--];
        minHeapify(0);
        return popped;
    }

}
