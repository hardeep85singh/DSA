package com.example.dsalgo.patterns.slindingwindow;

import java.util.*;

public class RepeatedDnaSequences {

    public static void main(String[] args) {
        String dna = "AAAAACCCCCAAAAACCCCCC";

        System.out.println(findRepeatedSequences(dna, 8));
    }

    public static Set<String> findRepeatedSequences(String dna, int k){
        Set<String> seen = new HashSet<>();
        Set<String> repeated = new HashSet<>();
        for (int i = 0; i < dna.length() - k; i++){
            String subStr = dna.substring(i, i+k);
            if(seen.contains(subStr)){
                repeated.add(subStr);
            } else {
               seen.add(subStr);
            }
        }
        return repeated;
    }
}
