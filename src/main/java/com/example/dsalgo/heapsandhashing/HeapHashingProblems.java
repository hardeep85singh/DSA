package com.example.dsalgo.heapsandhashing;

import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author Hardeep Singh
 */
@Service
public class HeapHashingProblems {

    public int minDifferenceAmongMaxMin(int [] arr, int k){
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;

        for(int i = 0; i <= arr.length - k; i++){
            if(min > (arr[i+k-1] - arr[i])){
                min = arr[i+k-1] - arr[i];
            }
        }
        return min;
    }

    public void KFrequentNumbers(int[] arr, int k){
        Map<Integer, Integer> hashMap = new HashMap<>();

        for(int i = 0; i< arr.length; i++){
            if(!hashMap.containsKey(arr[i])){
                hashMap.put(arr[i], 1);
            } else {
                hashMap.put(arr[i], hashMap.get(arr[i])+1);
            }
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(hashMap.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                if(o1.getValue() == o2.getValue()){
                    return o2.getKey() - o1.getKey();
                } else {
                    return o2.getValue() - o1.getValue();
                }
            }
        });
        for(int i = 0; i< k; i++){
            System.out.print(list.get(i).getKey() + ": ");
        }

    }

    public void KLargestElements(int[] arr, int k){
        Arrays.sort(arr);
        for(int i = 0; i < k; i++){
            System.out.print(arr[arr.length-1-i] + ": ");
        }
    }

    public void kSort(int[] arr, int k){
        int n = arr.length;
        int j, key;
        for(int i = 1; i< n; i++){
            key = arr[i];
            j = i-1;
            while(j >=0 && arr[j] > key){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
        System.out.print(Arrays.toString(arr));
    }

    public int kthSmallestQuickSort(int[] arr, int l, int r, int k){

        if(k > 0 && k < r-l+1){
            int pos = partition(arr, l, r);
            if(pos-l == k -1){
                return arr[pos-l];
            } else if(pos - l > k - 1){
                return kthSmallestQuickSort(arr, l, pos-1, k);
            } else {
                return kthSmallestQuickSort(arr, pos +1, r, k - pos + l -1);
            }
        }
        return Integer.MAX_VALUE;
    }

    private int partition(int[] arr, int l, int r) {
        int pivot = arr[r];
        int i = l;
        for(int j = l; i < r; i++){
            if(arr[j] <= pivot ){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }
        int temp = arr[i];
        arr[i] = arr[r];
        arr[r] = temp;
        return i;
    }

    public void nextGreaterElement(int[] arr){
        // 4, 5, 2, 25
        int next;
        for(int i = 0; i< arr.length; i++){
            next = -1;
            for(int j = i+1; j< arr.length; j++){
                if(arr[j] > arr[i]){
                    next = arr[j];
                    break;
                }
            }
            System.out.print(next + ": ");
        }
    }

    public void nextGreaterElementStack(int[] arr){
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);
        int element, next;
        for(int i = 1; i< arr.length; i++){
            next = arr[i];
            if (!stack.isEmpty()){
                element = stack.pop();
                while (element < next){
                    System.out.println(element + "->" + next);
                    if(stack.isEmpty()){
                        break;
                    }
                    element = stack.pop();
                }
                if(element > next){
                    stack.push(element);
                }
            }
            stack.push(next);
        }
        while (!stack.isEmpty()){
            element = stack.pop();
            System.out.println(element + "->" + -1);
        }
    }
}
