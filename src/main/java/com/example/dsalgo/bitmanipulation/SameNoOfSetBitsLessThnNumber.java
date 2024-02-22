package com.example.dsalgo.bitmanipulation;

/**
 * @author Hardeep Singh
 */
// find count of numbers which has same number of set bits & is less than give number & positive
public class SameNoOfSetBitsLessThnNumber {

    public static void main(String[] args) {
        System.out.println(ncr(3,1));
        long num = 13L; // 1100
        int k = numberOfSetBits(num);
        System.out.println(k);
        long ans = solution(num, k, 63);
        System.out.println(ans);
    }

    private static int numberOfSetBits(long num) {
        int res = 0;
        while (num > 0){
            long rsb = num & -num;
            num = num - rsb;
            res++;
        }
        return res;
    }

    public static long solution(long num, int k, int i){
        if(i == 0){
            return 0;
        }
        long mask = 1L << i;
        long res = 0;
        if((num & mask) == 0){
            res = solution(num, k, i -1);
        } else {
            long res1 = solution(num, k-1, i-1);
            long res0 = ncr(i, k);
            res = res1 + res0;
        }
        return res;
    }

    public static long ncr(long n, long r){
        if(n < r){
            return 0L;
        }
        long res = 1L;
        for (long i = 0L; i < r; i++){
            res = res * (n - i);
            res = res / (i + 1);
        }
        return res;
    }
}
