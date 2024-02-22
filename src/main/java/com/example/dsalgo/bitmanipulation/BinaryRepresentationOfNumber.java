package com.example.dsalgo.bitmanipulation;

/**
 * @author Hardeep Singh
 */

// print binary representation of a decimal number
public class BinaryRepresentationOfNumber {

    public static void main(String[] args) {
        binaryRepresentationIterative(11);
        System.out.println("");
        binaryRepresentationRecursive(11);
    }

    public static void binaryRepresentationIterative(long n){
        long i;
        System.out.print("0");
        for(i = 1 << 30; i > 0; i = i >> 1){
            if((n & i) != 0){
                System.out.print("1");
            } else {
                System.out.print("0");
            }
        }
        // this will print in reverse, use stack to print
//        for(int i = 0; i < 32; i++){
//            if((n & 1) == 0){
//                System.out.print("0");
//            } else {
//                System.out.print("1");
//            }
//            n = n >> 1;
//        }
    }

    public static void binaryRepresentationRecursive(long n){
        if(n > 1){
            binaryRepresentationRecursive(n >> 1);
        }
        System.out.print(n & 1);
    }
}
