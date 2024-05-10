package com.example.dsalgo.bitmanipulation;

public class CountSetBits {
    public static void main(String[] args) {
        System.out.println(countSetBits(122));
    }

    public static int countSetBits(int num){
        int ans = 0;

        while (num > 0){
//            if(num % 2 != 0){
//                ans++;
//            }
//            num = num / 2;

//            if((num & 1) == 1){
//               ans++;
//            }
//            num = num >> 1;

//            ans = ans + (num & 1);
//            num = num >> 1;

            num = num & (num - 1);
            ans++;
        }
        return ans;
    }
}
