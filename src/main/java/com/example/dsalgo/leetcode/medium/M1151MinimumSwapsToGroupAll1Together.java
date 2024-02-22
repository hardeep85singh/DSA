package com.example.dsalgo.leetcode.medium;

/**
 * @author Hardeep Singh
 */
public class M1151MinimumSwapsToGroupAll1Together {
    public static void main(String[] args) {
        int [] data = {1,0,1,0,1};
        System.out.println(minSwaps(data));
    }

    public static int minSwaps(int[] data) {
        int ans = 0;
        int left = 0;
        int right = 0;
        int totalOnes = 0;
        int maxOnesInWindow = 0;
        for(int i = 0; i< data.length; i++){
            if(data[i] == 1){
                totalOnes++;
            }
        }
        int currOnesInWindow = 0;
        while (right < data.length){
            currOnesInWindow = currOnesInWindow + data[right];
            right++;
            if(right - left > totalOnes){
                currOnesInWindow = currOnesInWindow - data[left];
                left++;
            }
//            while(right < totalOnes){
//                if(data[right] == 1){
//                    currOnesInWindow++;
//                }
//                right++;
//            }
//            if(data[right] == 1){
//                currOnesInWindow++;
//            }
//            right++;
//            if(data[left] == 1){
//                currOnesInWindow--;
//            }
//            left++;
            maxOnesInWindow = Math.max(maxOnesInWindow, currOnesInWindow);
        }
        return totalOnes - maxOnesInWindow;
    }
}
