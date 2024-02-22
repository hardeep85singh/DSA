package com.example.dsalgo.arrays;

import java.util.*;

public class ReorderDataInLogFiles {
    public static void main(String[] args) {
        String[] arr = {"a1-9-2-3-1","g1-act-car","zo4-4-7","ab1-off-key-dog","a8-act-zoo"};
        ArrayList<String> A = arrayToArrayList(arr);
        System.out.println(reorderLogs(A));
    }

    public static ArrayList<String> reorderLogs(ArrayList<String> A) {
        ArrayList<String> letterLogs = new ArrayList<>();
        ArrayList<String> digitLogs = new ArrayList<>();

        for (String log: A){
            if (isDigitLog(log)) {
                digitLogs.add(log);
            } else {
                letterLogs.add(log);
            }
        }

        // Sort letter-logs according to the required criteria
        Collections.sort(letterLogs, (log1, log2) -> {
            String[] split1 = log1.split("-", 2);
            String[] split2 = log2.split("-", 2);
            String identifier1 = split1[0];
            String identifier2 = split2[0];
            String content1 = split1[1];
            String content2 = split2[1];

            int contentComparison = content1.compareTo(content2);
            if (contentComparison != 0) {
                return contentComparison;
            } else {
                return identifier1.compareTo(identifier2);
            }
        });

        // Combine the sorted letter-logs and digit-logs
        letterLogs.addAll(digitLogs);

        return letterLogs;
    }

    private static boolean isDigitLog(String log) {
        // Split by the first space and check if the second part is a digit
        return Character.isDigit(log.split("-", 2)[1].charAt(0));
    }
//    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValues(Map<K, V> map) {
//        List<Map.Entry<K, V>> entryList = new LinkedList<>(map.entrySet());
//
//        // Sort the entryList based on the values using a custom comparator
//        entryList.sort(Map.Entry.comparingByValue());
//
//        // Store the sorted entries in a LinkedHashMap to maintain the order
//        Map<K, V> sortedMap = new LinkedHashMap<>();
//        for (Map.Entry<K, V> entry : entryList) {
//            sortedMap.put(entry.getKey(), entry.getValue());
//        }
//
//        return sortedMap;
//    }

    public static ArrayList<String> arrayToArrayList(String[] arr) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (String value : arr) {
            arrayList.add(value);
        }
        return arrayList;
    }
}
