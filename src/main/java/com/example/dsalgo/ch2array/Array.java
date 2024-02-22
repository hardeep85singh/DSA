package com.example.dsalgo.ch2array;

import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author Hardeep Singh
 */
@Service
public class Array {

    private int[] array;

    public Array() {
    }

    public Array(int[] array) {
        array = new int[10];
    }

    public int peekArray(int[] array) {

        int peekElement = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                peekElement = peekElement;
            } else {
                peekElement = array[i];
            }
        }
        return peekElement;
    }

    // An array element is a peak if it is NOT smaller than its neighbours.
    // For corner elements, we need to consider only one neighbour.
    public void peekElement(int[] arr) {
        int peekElement = -1;

        if (arr[0] > arr[1]) {
            peekElement = arr[0];
            System.out.println(peekElement);
        }
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                peekElement = arr[i];
                System.out.println(peekElement);
            }
        }
        if (arr[arr.length - 1] < arr[1]) {
            peekElement = arr[0];
            System.out.println(peekElement);
        }
    }

    public int peekElementDivideConquerRecursive(int[] arr, int l, int r) {
        int index = 0;
        int n = arr.length;
        if (l <= r) {
            int mid = (l + r) / 2;
            if ((mid == 0 || arr[mid - 1] <= arr[mid]) && (mid == n - 1 || arr[mid + 1] <= arr[mid])) {
                return mid;
            } else if ((mid > 0 || arr[mid - 1] > arr[mid])) {
                return peekElementDivideConquerRecursive(arr, l, mid - 1);
            } else {
                return peekElementDivideConquerRecursive(arr, mid + 1, r);
            }
        }
        return -1;
    }

    public int peekElementDivideConquerIterative(int[] arr, int l, int r) {
        int mid = 0;
        int n = arr.length;
        while (l <= r) {
            mid = (l + r) >> 1;

            if ((mid == 0 || arr[mid - 1] <= arr[mid]) && (mid == n - 1 || arr[mid] >= arr[mid + 1])) {
                return mid;
            } else if (mid > 0 || arr[mid - 1] > arr[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return mid;
    }

    public void findMinAndMax(int[] arr) {
        int min = arr[0];
        int max = arr[0];
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        System.out.println("Minimum element of array: " + min);
        System.out.println("Maximum element of array: " + max);
    }

    // 30, 20, 15, 2, 23, 90
    public void findMinAndMaxPairs(int[] arr) {
        int min = arr[0];
        int max = arr[0];
        int n = arr.length;

        // if even
        if (n % 2 == 0) {
            for (int i = 0; i < arr.length; i = i + 2) {

                if (arr[i + 1] > arr[i]) {
                    if (arr[i + 1] >= max) {
                        max = arr[i + 1];
                    }
                    if (arr[i] <= min) {
                        min = arr[i];
                    }
                } else {
                    if (arr[i] >= max) {
                        max = arr[i];
                    }
                    if (arr[i + 1] <= min) {
                        min = arr[i + 1];
                    }
                }
            }
        } else {
            for (int i = 0; i < arr.length - 1; i = i + 2) {

                if (arr[i + 1] > arr[i]) {
                    if (arr[i + 1] >= max) {
                        max = arr[i + 1];
                    }
                    if (arr[i] <= min) {
                        min = arr[i];
                    }
                } else {
                    if (arr[i] >= max) {
                        max = arr[i];
                    }
                    if (arr[i + 1] <= min) {
                        min = arr[i + 1];
                    }
                }
            }
            if (arr[n - 1] > max) {
                max = arr[n - 1];
            }
            if (arr[n - 1] < min) {
                min = arr[n - 1];
            }
        }
        System.out.println("Minimum element of array: " + min);
        System.out.println("Maximum element of array: " + max);
    }

    public class Pair {
        int min;
        int max;

        public Pair() {
        }

        public Pair(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }

    public Pair findMinAndMaxTournamentMethod(int[] arr, int left, int right) {
        Pair pair = new Pair();
        Pair pairLeft = new Pair();
        Pair pairRight = new Pair();
        if (left == right) {
            pair.min = pair.max = arr[left];
            return pair;
        } else if (right == left + 1) {
            if (arr[left] > arr[right]) {
                pair.max = arr[left];
                pair.min = arr[right];
            } else {
                pair.max = arr[right];
                pair.min = arr[left];
            }
            return pair;
        } else {
            int mid = (left + right) / 2;
            pairLeft = findMinAndMaxTournamentMethod(arr, left, mid);
            pairRight = findMinAndMaxTournamentMethod(arr, mid + 1, right);
            if (pairLeft.max < pairRight.max) {
                pair.max = pairRight.max;
            } else {
                pair.max = pairLeft.max;
            }

            if (pairLeft.min > pairRight.min) {
                pair.min = pairRight.min;
            } else {
                pair.min = pairLeft.min;
            }
        }
        System.out.println("Min: " + pair.min + ", Max: " + pair.max);
        return pair;
    }

    public void reverseArrayTakingFirstLastElement(int arr[]) {

        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }

    public void reverseArrayUsingStack(int[] arr) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < arr.length - 1; i++) {
            stack.push(arr[i]);
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = stack.pop();
        }

        System.out.println(Arrays.toString(arr));
    }

    // 7-5-1-4-3-2-6, k = 3, result = 3, l=0, r = 6
    public int findKthSmallestElementQuickSort(int[] arr, int l, int r, int k) {

        if (k > 0 && k <= r - l + 1) {
            int position = partition(arr, l, r);
            if (position - l == k - 1) {
                return arr[position];
            } else if (position - l > k - 1) {
                findKthSmallestElementQuickSort(arr, l, position - 1, k);
            } else {
                findKthSmallestElementQuickSort(arr, position + 1, r, k +l - (position+1));
            }
        }
        return -1;
    }

    // 5-1-4-3-2-6-7, position = 5
    public int partition(int[] arr, int l, int r) {
        int pivot = arr[r]; // pivot = 6
        int i = l - 1; // i =-1

        for (int j = l; j < r - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = pivot;
        arr[r] = temp;

        return i + 1;
    }

    // move negative numbers at end without changing order
    public void moveNegativeNumbers(int[] arr) {
        Queue<Integer> queueNeg = new LinkedList<>();
        Queue<Integer> queuePos = new LinkedList<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                queueNeg.add(arr[i]);
            } else {
                queuePos.add(arr[i]);
            }
        }
        int i = 0;
        while (!queuePos.isEmpty()) {
            arr[i] = queuePos.poll();
            i++;
        }
        int j = i + 1;
        while (!queueNeg.isEmpty()) {
            arr[j] = queueNeg.poll();
            j++;
        }
        System.out.println(Arrays.toString(arr));
    }

    public void moveNegativeNumbersExtraArray(int[] arr) {
        int[] temp = arr;

        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0) {
                temp[j] = arr[i];
                j++;
            }
        }
        if (j == arr.length || j == 0) {
            System.out.println(Arrays.toString(arr));
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                temp[j + 1] = arr[i];
                j++;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = temp[i];
        }
        System.out.println(Arrays.toString(arr));
    }

    // first positive next negative
    public void rearrangePosNegNumbers(int[] arr) {
        List<Integer> listPos = new ArrayList<>();
        List<Integer> listNeg = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0) {
                listPos.add(arr[i]);
            } else {
                listNeg.add(arr[i]);
            }
        }

        int i = 0;
        int j = 0;
        int k = 0;
        while (i < listPos.size() && j < listNeg.size()) {
            arr[k] = listPos.get(i);
            k++;
            i++;
            arr[k] = listNeg.get(j);
            k++;
            j++;
        }


        if (i < listPos.size()) {
            arr[k] = listPos.get(i);
            i++;
        }
        if (j < listNeg.size()) {
            arr[k] = listNeg.get(j);
            j++;
        }
        System.out.println(Arrays.toString(arr));

    }

    public void positiveEvenNegativeOddHoare(int[] arr) {
//        int pos = 0;
//        int neg = 1;
//        while(pos < arr.length && neg < arr.length){
//            if(arr[pos] < 0 && arr[neg] >= 0){
//                int temp = arr[pos];
//                arr[pos] = arr[neg];
//                arr[neg] = temp;
//            }
//            if(arr[pos] >= 0){
//                pos = pos +2;
//            }
//            if(arr[neg] < 0){
//                neg = neg +2;
//            }
//        }

        int positive = 0, negative = 0, temp = 0;
        int size = arr.length;
        while (true) {
    /* Move forward the positive pointer till
    negative number not encountered */
            while (positive < size && arr[positive] >= 0) {
                positive = positive + 2;
            }

    /* Move forward the negative pointer till
        positive number not encountered */
            while (negative < size && arr[negative] <= 0) {
                negative = negative + 2;
            }
            // Swap array elements to fix their position.
            if (positive < size && negative < size) {
                temp = arr[positive];
                arr[positive] = arr[negative];
                arr[negative] = temp;
            }
    /* Break from the while loop when any index
    exceeds the size of the array */
            else {
                break;
            }
        }

        System.out.println(Arrays.toString(arr));
    }

    //1-3-4-5-6
    public void rearrangeEvenOddNumbers(int[] arr) {
        int j = 0;
        int i = -1;
        while (j < arr.length) {
            if (arr[j] % 2 == 0) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            j++;
        }
        System.out.println(Arrays.toString(arr));
    }

    // array of size n with maximum 0 to n-1 positive numbers
    public void findDuplicates(int[] arr) {
        List<Integer> list = new ArrayList<>();
        int n = arr.length;
        for (int i = 0; i < arr.length; i++) {
            arr[arr[i] % n] = arr[arr[i] % n] + n;
        }
        for (int i = 0; i < n - 1; i++) {
            if ((arr[i] / 2) > 1) {
                list.add(arr[i] % n);
            }
        }
        for (int number : list) {
            System.out.print(number + ": ");
        }
    }

    //0-0-1-2-3 -> 2-1-1-1
    public void findDuplicatesWithCounter(int[] arr) {
        int n = arr.length;
        int[] temp = new int[n];

        for (int i = 0; i < n; i++) {
            temp[arr[i]] = temp[arr[i]] + 1;
        }
        for (int i = 0; i < n; i++) {
            if (temp[i] > 1) {
                System.out.println(i + ":");
            }
        }
    }

    //{1,2,2,3}
    public void findDuplicateMakingNegative(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int absValue = Math.abs(arr[i]);
            if (arr[absValue] >= 0) {
                arr[absValue] = -arr[absValue];
            } else {
                System.out.print(absValue + ":");
            }
        }
    }

    public int findMinimumRotatedArray(int[] arr, int left, int right) {

        if (left > right) {
            return arr[0];
        }

        // if only one element left
        if (left == right) {
            return arr[left];
        }
        int mid = (left + right) / 2;

        // check if mid+1 is minimum
        if (mid < right && arr[mid] > arr[mid + 1]) {
            return arr[mid + 1];
        }

        // check if mid is minimum
        if (mid > left && arr[mid - 1] > arr[mid]) {
            return arr[mid];
        }

        // decide where we need to go, left or right arr
        if (arr[left] < arr[mid]) {
            return findMinimumRotatedArray(arr, mid + 1, right);
        } else {
            return findMinimumRotatedArray(arr, left, mid - 1);
        }
    }

    public void rotateArrayByK(int[] arr, int l, int r, int k) {
        int[] leftArray = reverseArray(arr, l, r - k);
        int[] rightArray = reverseArray(arr, k + 1, r);
        arr = mergeArray(leftArray, rightArray);
        reverseArray(arr, l, r);

    }

    private int[] mergeArray(int[] leftArray, int[] rightArray) {
        int l = leftArray.length;
        int r = rightArray.length;
        int[] arr = new int[l + r];

        int k = 0;
        for (int i = 0; i < l; i++) {
            arr[i] = leftArray[i];
            k++;
        }
        for (int i = 0; i < r; i++) {
            arr[i + k + 1] = rightArray[i];
        }
        return arr;
    }

    private int[] reverseArray(int[] arr, int l, int r) {
        int[] temp = new int[r - l + 1];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = arr[l + i];
        }
        for (int i = 0; i < temp.length / 2; i++) {
            temp[i] = temp[temp.length - 1 - i];
        }
        return temp;
    }

    public int findMissingNumber(int[] arr) {
        int n = arr.length;
        int countLessThanEqualToN = 0;
        int countGreaterThanN = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] <= n) {
                countLessThanEqualToN++;
            } else {
                countGreaterThanN++;
            }
        }
        int[] arrLessThanEqualToN = new int[countLessThanEqualToN];
        int[] arrGreaterThanN = new int[countGreaterThanN];
        for (int i = 0; i < n; i++) {
            if (arr[i] < n) {
                arrLessThanEqualToN[i] = arr[i];
            } else {
                arrGreaterThanN[i] = arr[i] % arrGreaterThanN.length;
            }
        }

        int missingNumber = -1;
        int[] leftCountArr = findCounts(arrLessThanEqualToN);
        int[] rightCountArr = findCounts(arrGreaterThanN);
        for (int i = 0; i < leftCountArr.length; i++) {
            if (leftCountArr[i] == 0) {
                missingNumber = leftCountArr[i];
            }
        }
        for (int i = 0; i < rightCountArr.length; i++) {
            if (rightCountArr[i] == 0) {
                missingNumber = rightCountArr[i];
            }
        }
        return missingNumber;
    }

    private int[] findCounts(int[] arr) {
        int[] temp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            temp[arr[i]] = temp[arr[i]] + 1;
        }
        return temp;
    }

    public void findCommonThreeSortedArray(int[] arr1, int[] arr2, int[] arr3) {

    }

    public int findFirstNonRepetitive(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int j;
            for (j = 0; j < arr.length; j++) {
                if (i != j && arr[i] == arr[j]) {
                    break;
                }
            }
            if (j == arr.length - 1) {
                return arr[i];
            }
        }
        return -1;
    }

    public int findFirstNonRepetitiveHashMap(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (map.get(arr[i]) == 1) {
                return arr[i];
            }
        }
        return -1;
    }

    public boolean subArrayWithZeroSumHashing(int[] arr) {
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
            if (sum == 0 || arr[i] == 0 || set.contains(sum)) {
                return true;
            }
            set.add(sum);
        }
        return false;
    }

    public void printSubArraysZeroSumHashing(int[] arr) {

        HashMap<Integer, ArrayList<Integer>> hashMap = new HashMap<>();
        ArrayList<Pair> out = new ArrayList<>();
        int sum = 0;
//        for(int i = 0; i< arr.length; i++){
//            sum = sum + arr[i];
//            if(sum == 0){
//                out.add(new Pair(0,i));
//            }
//            ArrayList<Integer> aL = new ArrayList<>();
//            if(hashMap.containsKey(sum)){
//                aL = hashMap.get(sum);
//                for(int j = 0; j< aL.size(); j++){
//                    out.add(new Pair(aL.get(j) +1 , i));
//                }
//            }
//            aL.add(i);
//            hashMap.put(sum, aL);
//        }
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];

            if (sum == 0) {
                out.add(new Pair(0, i));
            }
            ArrayList<Integer> arrayList = new ArrayList<>();

            if (hashMap.containsKey(sum)) {
                arrayList = hashMap.get(sum);
                for (int j = 0; j < arrayList.size(); j++) {
                    out.add(new Pair(arrayList.get(j) + 1, i));
                }
            }
            arrayList.add(i);
            hashMap.put(sum, arrayList);
        }
        out.stream().forEach((pair) -> {
            System.out.println(pair.min + ":" + pair.max);
        });
    }

    public int lengthOfMaxSubArrayZeroSumBrute(int[] arr) {
        int max_length = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum = sum + arr[j];
                if (sum == 0) {
                    max_length = Math.max((j - i + 1), max_length);
                }
            }
        }
        return max_length;
    }

    public int lengthOfMaxSubArrayZeroSumHashing(int[] arr) {
        int sum = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
//        int max_length = 0;

//        for(int i = 0; i< arr.length; i++){
//            sum = sum + arr[i];
//            if(arr[i] == 0 && max_length == 0){
//                max_length = 1;
//            }
//            if(sum == 0){
//                max_length = i +1;
//            }
//            if(hashMap.get(sum) != null){
//                max_length = Math.max(max_length, i - hashMap.get(sum));
//            }
//            hashMap.put(sum, i);
//        }
        int max_length = -1;
        hashMap.put(0, 0);
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
            if (hashMap.containsKey(sum)) {
                max_length = Math.max(max_length, i + 1 - hashMap.get(sum));
            } else {
                hashMap.put(sum, i + 1);
            }
        }
        return max_length;
    }

    public int maxSumOfSubArrays(int[] arr, int k) {
        int n = arr.length;
        int i = 0;
        int j = 0;
        int maxSum = 0;
        int sum = 0;
        while (j < n) {
            sum = sum + arr[j];
            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                maxSum = Math.max(maxSum, sum);
                sum = sum - arr[i];
                j++;
                i++;
            }
        }
        return maxSum;
    }

    public int maxSumOfArraysBruteForce(int[] arr, int k) {
        int maxSum = 0;
        for (int i = 0; i < arr.length - k + 1; i++) {
            int sum = 0;
            for (int j = i; j < i + k; j++) {
                sum = sum + arr[j];
            }
            maxSum = Math.max(sum, maxSum);
        }
        System.out.println(maxSum);
        return maxSum;
    }

    public void printSubArraysBruteForce(int[] arr, int k) {
        int[] kArr = new int[k];
        for (int i = 0; i < arr.length - k + 1; i++) {
            for (int j = 0; j < k; j++) {
                kArr[j] = arr[j + i];
            }
            System.out.println(Arrays.toString(kArr));
        }
    }

    public void printSubArraysSlidingWindow(int[] arr, int k) {
        Queue<Integer> queue = new LinkedList<>();
        int i = 0;
        int j = 0;
        while (j < arr.length) {
            queue.add(arr[j]);
            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                System.out.println(queue);
                queue.poll();
                j++;
                i++;
            }
        }
    }
    // First negative integer in every window of size k
    public void printFirstNegativeIntBruteForce(int[] arr, int k) {

        for (int i = 0; i < arr.length - k + 1; i++) {
            for (int j = i; j < i + k; j++) {
                if (arr[j] < 0) {
                    System.out.println(arr[j]);
                    break;
                }
            }
        }
    }

    // First negative integer in every window of size k
    public void printFirstNegativeIntSlidingWindow(int[] arr, int k) {
        int i = 0;
        int j = 0;
        Queue<Integer> queue = new LinkedList<>();
        while (j < arr.length) {
            if (arr[j] < 0) {
                queue.add(arr[j]);
            }
            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                System.out.println(queue.peek());
                if (arr[i] < 0) {
                    queue.poll();
                }
                i++;
                j++;
            }
        }

    }

    public void maxAndMinElements(int[] arr) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println("Minimum value: " + min);
        System.out.println("Maximum value: " + max);
    }

    public void reverseArray(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }

    public int maxSumOfSubArrayBrute(int[] arr) {
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum = sum + arr[j];
                maxSum = Math.max(sum, maxSum);
            }
        }
        return maxSum;
    }

    public int maxSumOfSubArraysKadaneAlg(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        int i = 0;
        int j = 0;
        int sum = 0;
        while (j < arr.length) {
            sum = sum + arr[j];
            j++;
            maxSum = Math.max(sum, maxSum);
            if (sum < 0) {
                sum = 0;
                i = j;
            }
        }
        return maxSum;
    }

    public void maxOfSubArraysSliding(int[] arr, int k) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        int j = 0;
        int i = 0;
        int max = Integer.MIN_VALUE;
        while (j < arr.length) {
            max = Math.max(max, arr[j]);

            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                arrayList.add(max);

                i++;
                j++;
            }

        }
    }

    public int majorityElementBrute(int[] arr) {
        int maxCount = 0;
        int index = -1;
        for(int i = 0; i< arr.length; i++){
            int count = 0;
            for(int j = i + 1; j < arr.length; j++){
                if(arr[i] == arr[j]){
                    count++;
                }
            }
            maxCount = Math.max(count, maxCount);
            index = i;
        }
        if(maxCount > arr.length / 2){
            System.out.println(arr[index]);
        }
        return index;
    }

    public int majorityElementSorting(int[] arr) {
        Arrays.sort(arr);
        int count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] == arr[i]) {
                count++;
                if (count > (arr.length / 2)) {
                    return arr[i];
                }
            } else {
                count = 1;
            }
        }
        return -1;
    }

    public int majorityElementHashmap(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], 1);
            } else {
                map.put(arr[i], map.get(arr[i]) + 1);
            }
            if (map.get(arr[i]) > arr.length / 2) {
                return arr[i];
            }
        }
        return -1;
    }

    // majority element which is greater than n /2
    public int majorityElementMooreAlg(int[] arr) {
        int frequency = 1;
        int frequentElement = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (frequentElement == arr[i]) {
                frequency++;
            } else {
                frequency--;
            }
            if (frequency == 0) {
                frequentElement = arr[i];
                frequency = 1;
            }
        }
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == frequentElement) {
                count++;
            }
            if (count > arr.length / 2) {
                return frequentElement;
            }
        }
        return -1;
    }

    // first 2 majority elements
    public int[] firstTwoMajorityElements(int[] arr){
        int firstFreq = 0;
        int secondFreq = 0;
        int firstFreqElement = 0;
        int secondFreqElement = 0;
        for(int i = 0; i< arr.length; i++){
            if(firstFreqElement == arr[i]){
                firstFreq++;
            } else {
                if(secondFreqElement == arr[i]){
                    secondFreq++;
                } else {
                    if(firstFreq == 0){
                        firstFreqElement = arr[i];
                        firstFreq = 1;
                    } else{
                        if(secondFreq == 0){
                            secondFreqElement = arr[i];
                            secondFreq = 1;
                        } else {
                            firstFreq--;
                            secondFreq--;
                        }
                    }
                }
            }
        }
        int[] nums = new int[2];
        if(firstFreq >= secondFreq){
            nums[0] = firstFreqElement;
        } else {
            nums[1] = secondFreqElement;
        }
        return nums;
    }

    public int chocolateDistributionProblem(int[] arr, int k) {
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length - k + 1; i++) {
            int diff = arr[k + i - 1] - arr[i];
            min = Math.min(diff, min);
        }
        return min;
    }

    public int searchElementSortedRotatedArr(int[] arr, int left, int right, int key) {
        if (left > right) {
            return -1;
        }
        int mid = (right + left) / 2;
        if (arr[mid] == key) {
            return mid;
        }
        // if left is sorted
        if (arr[left] <= arr[mid]) {
            if (key >= arr[left] && key <= arr[mid]) {
                return searchElementSortedRotatedArr(arr, left, mid - 1, key);
            } else {
                return searchElementSortedRotatedArr(arr, mid + 1, right, key);
            }
        } else {
            if (key >= arr[mid] && key <= arr[right]) {
                return searchElementSortedRotatedArr(arr, mid + 1, right, key);
            } else {
                return searchElementSortedRotatedArr(arr, left, mid - 1, key);
            }
        }
    }

    public int searchElementSortedRotatedArrByPivot(int[] arr, int left, int right, int key) {
        int pivot = findPivot(arr, left, right);

        if (pivot == -1) {
            return binarySearch(arr, left, right, key);
        }
        if (arr[pivot] == key) {
            return pivot;
        } else if (arr[left] <= key) {
            return binarySearch(arr, left, pivot - 1, key);
        } else {
            return binarySearch(arr, pivot + 1, right, key);
        }
    }

    private int binarySearch(int[] arr, int left, int right, int key) {
        if (left > right) {
            return -1;
        } else {
            int mid = (right + left) / 2;
            if (key == arr[mid]) {
                return mid;
            } else if (key < arr[mid]) {
                return binarySearch(arr, left, mid - 1, key);
            } else {
                return binarySearch(arr, mid + 1, right, key);
            }
        }
    }

    private int findPivot(int[] arr, int left, int right) {
        if (left > right) {
            return -1;
        }
        if (left == right) {
            return left;
        }
        int mid = (right + left) / 2;
        if (mid < right && arr[mid] > arr[mid + 1]) {
            return mid;
        } else if (mid > left && arr[mid] < arr[mid - 1]) {
            return mid - 1;
        } else if (arr[left] >= arr[mid]) {
            return findPivot(arr, left, mid - 1);
        } else {
            return findPivot(arr, mid + 1, right);
        }
    }

    public void buySellStock(int[] arr) {
        int i = 0;
        int j = 0;
        int max = 0;
        int buyDate = 1;
        int sellDate = 1;
        while (j < arr.length) {
            int diff = arr[j] - arr[i];
            if(diff > max){
                max = diff;
                buyDate = i+1;
                sellDate = j+1;
            }
            if(diff < 0){
                diff = 0;
                i = j;
            }
            j++;
        }
        System.out.println("Max profit: " + max + ", Buy date: " + buyDate + ", Sell date: " + sellDate);
    }

    // array of size n where numbers are from 1 to n
    public void repeatAndMissingNumberUsingArray(int[] arr){
        int[] countArr = new int[arr.length];
        int n = arr.length;
        for(int i = 0; i< n; i++){
            countArr[(arr[i] % n)] = countArr[(arr[i] % n)] + 1;
        }
        for(int i = 0; i< n; i++){
            if(i == 0){
                if(countArr[i] == 0){
                    System.out.println("Missing Number : " + n);
                }
                if(countArr[i] == 2){
                    System.out.println("Repeating number : " + n);
                }
            } else {
                if (countArr[i] == 0) {
                    System.out.println("Missing Number : " + i);
                }
                if (countArr[i] == 2) {
                    System.out.println("Repeating number : " + i);
                }
            }

        }
    }

    public void repeatAndMissingNumberInPlace(int[] arr){

    }
    public void repeatAndMissingNumberHashmap(int[] arr){

    }

    public void kthLargestElementBySorting(int[] arr, int k){
        Arrays.sort(arr);
        int n = arr.length;
        System.out.println(arr[n-k]);
    }

    public int kthLargestElementByQuickSortPivot(int[] arr, int left, int right, int k){
        if(left > right){
            return -1;
        }
        int pivot = partition1(arr, left, right);
        if(pivot == (right) - k + 1){
            return arr[pivot];
        }
        if(pivot > (right) -k + 1){
            return kthLargestElementByQuickSortPivot(arr, left, pivot-1, k - (right-(pivot -1)));
        } else {
            return kthLargestElementByQuickSortPivot(arr, pivot+1, right, k);
        }

    }

    private int partition1(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left-1;
        for(int j = left; j<= right; j++){
            if(arr[j] < pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = pivot;
        arr[right] = temp;
        return i+1;
    }

    public int[] buildMaxHeap(int[] arr, int n){
        for(int i = n/2; i > 0; i--){
            maxHeapify(arr, n, i);
        }
        return arr;
    }

    public void maxHeapify(int[] arr, int n, int pos){
        int largest = pos;
        int left = 2 * pos;
        int right = (2*pos) + 1;
        if(largest <= left && arr[largest] < arr[left]){
            largest = left;
        }
        if(largest <= right && arr[largest] < arr[right]){
            largest = right;
        }
        if(largest != pos){
            int temp = arr[pos];
            arr[pos] = arr[largest];
            arr[largest] = temp;
            maxHeapify(arr, n, largest);
        }
    }
    public void productArrayExceptItselfFrontReverseTraversal(int[] arr) {
        int product = 1;
        int temp = 1;
        int[] productArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            productArr[i] = 1;
        }
        for (int i = 0; i < arr.length; i++) {
            productArr[i] = temp;
            temp = temp * arr[i];
        }
        temp = 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            productArr[i] = productArr[i] * temp;
            temp = temp * arr[i];
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(productArr[i] + ": ");
        }
    }

    public void productArrayExceptItselfByDivision(int[] arr) {
        int product = 1;
        for (int i = 0; i < arr.length; i++) {
            product = product * arr[i];
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = product / arr[i];
            System.out.print(arr[i] + ": ");
        }

    }

}
