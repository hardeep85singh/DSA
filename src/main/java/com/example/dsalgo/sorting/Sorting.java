package com.example.dsalgo.sorting;

import org.springframework.stereotype.Service;

/**
 * @author Hardeep Singh
 */
@Service
public class Sorting {

    public void bubbleSortDescending(int[] arr) {
        if (arr.length == 0) {
            throw new IllegalArgumentException("Array is empty, nothing to sort");
        } else {
            for (int i = 0; i < arr.length; i++) {
                for (int j = arr.length - 1 - i; j > 0; j--) {
//                    if(arr[j] > arr[i]){
//                        int temp = arr[j];
//                        arr[j] = arr[i];
//                        arr[i] = temp;
//                    }
                    if (arr[j - 1] < arr[j]) {
                        int temp = arr[j - 1];
                        arr[j - 1] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
        }
        for (int data : arr) {
            System.out.print(data + " ");
        }
    }

    public void bubbleSortAscending(int[] arr) {
        if (arr.length == 0) {
            throw new IllegalArgumentException("Array is empty, nothing to sort");
        } else {
            for (int i = arr.length - 1; i >= 0; i--) {
                for (int j = 0; j < i; j++) {
//                    if(arr[j] > arr[i]){
//                        int temp = arr[j];
//                        arr[j] = arr[i];
//                        arr[i] = temp;
//                    }
                    if (arr[j] > arr[j + 1]) {
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }
            }
        }
        for (int data : arr) {
            System.out.print(data + " ");
        }
    }

    private void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    public void selectionSort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
        for (int data : arr) {
            System.out.print(data + ":");
        }
        System.out.println();
    }

    public void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int value = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > value) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = value;
        }
        for (int data : arr) {
            System.out.print(data + ":");
        }
        System.out.println();
    }
    public void insertionSort1(int[] arr){
        for(int i = 1; i< arr.length; i++){
            int value = arr[i];
            int j = i-1;
            while(j >= 0 && arr[j] > value){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = value;
        }
    }

    public int[] mergeSort(int[] arr, int left, int right) {
        if (right > left) {
            int mid = (right + left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
        return arr;
    }

    public int[] merge(int[] arr, int left, int mid, int right) {

        int[] arrLeft = new int[mid + 1 - left];
        int[] arrRight = new int[right - mid];
        int lengthLeft = arrLeft.length;
        int lengthRight = arrRight.length;

        for (int i = 0; i < lengthLeft; i++) {
            arrLeft[i] = arr[left + i];
        }
        for (int i = 0; i < lengthRight; i++) {
            arrRight[i] = arr[i + mid + 1];
        }

        int k = left;
        int i = 0;
        int j = 0;
        while (i < lengthLeft && j < lengthRight) {
            if (arrLeft[i] < arrRight[j]) {
                arr[k] = arrLeft[i];
                i++;
            } else {
                arr[k] = arrRight[j];
                j++;
            }
            k++;
        }

        while (i < lengthLeft) {
            arr[k] = arrLeft[i];
            i++;
            k++;
        }

        while (j < lengthRight) {
            arr[k] = arrRight[j];
            j++;
            k++;
        }
        return arr;
    }

    public int[] quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);
            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
        return arr;
    }

    public int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
    public int[] quickSort1(int[] arr, int low, int high){
        if(low < high){
            int pivot = partition1(arr, low, high);
            quickSort1(arr, low, pivot-1);
            quickSort1(arr, pivot + 1, high);
        }
        return arr;
    }

    public int partition1(int[] arr, int low, int high){
        int pivot = arr[high];
        int i = low - 1;
        int j = low;
        while(j < high){
            if(arr[j] < pivot){
                i++;
                swap(arr, arr[j], arr[i]);
            }
            j++;
        }
        swap(arr, arr[i+1], pivot);
        return i+1;
    }
    public int[] mergeSort1(int[] arr, int left, int right){
        if(left < right){
            int mid = (right + left) / 2;
            mergeSort1(arr, left, mid);
            mergeSort1(arr, mid+1, right);
            merge1(arr, left, right, mid);
        }
        return arr;
    }
    public int[] merge1(int[] arr, int left, int right, int mid){
        int arrLength = arr.length;

        // 2 new empty array to copy left and right elements of arr
        int[] arrLeft = new int[mid + 1 - left];
        int[] arrRight = new int[right - mid];

        int arrLeftLength = arrLeft.length;
        int arrRightLength = arrRight.length;

        for(int i = 0; i< arrLeftLength; i++){
            arrLeft[i] = arr[left + i];
        }
        for(int i = 0; i< arrRightLength; i++){
            arrRight[i] = arr[mid + 1 + i];
        }
        int i = 0;
        int j = 0;
        int k = left;

        // check left and right array for minimum and copy in arr
        while(i < arrLeftLength || j < arrRightLength){
            if(arrLeft[i] < arrRight[j]){
                arr[k] = arrLeft[i];
                i++;
                k++;
            } else {
                arr[k] = arrRight[j];
                j++;
                k++;
            }
        }

        // if some left array elements are still yet to copy in arr
        while(i < arrLeftLength){
            arr[k] = arrLeft[i];
            i++;
            k++;
        }

        // if some right array elements are still yet to copy in arr
        while(j < arrRightLength){
            arr[k] = arrRight[j];
            j++;
            k++;
        }
        return arr;
    }

    class Node{
        int data;
        Node next;

        public Node() {
        }

        public Node(int data) {
            this.data = data;
        }
    }
    Node head;

    public void insertNode(int data){
        Node node = new Node(data);
        node.next = head;
        head = node;
    }
    public Node quickSortList(Node head){

        return null;
    }

    public Node partitionList(Node start, Node end){
        if(start == end || start == null || end == null){
            return start;
        }
        int pivot = end.data;
        Node previous_pilot = start;
        Node current = start;
        while(start != end){
            if(start.data < pivot){
                previous_pilot = current;
                int temp = current.data;
                current.data = start.data;
                start.data = temp;
                current = current.next;
            }
            start = start.next;
        }
        int temp = current.data;
        current.data = pivot;
        end.data = temp;
        return previous_pilot;
//        while(start != end){
//            Node previous = start;
//            start = start.next;
//            if(previous.data > pivot.data){
//                Node temp = previous;
//                pivot.next = temp;
//                previous = null;
//            }
//        }
//        return pivot;
    }
    public void quickSortLinkedList(Node start, Node end){
        if(start == null || end == null || start == end.next){
            return;
        }

        Node previous_pilot = partitionList(start, end);
        quickSortLinkedList(start, previous_pilot);

        if(previous_pilot != null && previous_pilot == start){
            quickSortLinkedList(previous_pilot.next, end);
        } else if(previous_pilot != null && previous_pilot.next != null) {
            quickSortLinkedList(previous_pilot.next.next, end);
        }
    }

}
