package com.example.dsalgo.dynamicprogramming;

import org.springframework.stereotype.Service;

/**
 * @author Hardeep Singh
 */
@Service
public class DynamicProgrammingProblems {

    public int minCoinsRecursive(int n, int[] arr){
        if(n == 0){
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length; i++){
            if(n - arr[i] >= 0){
                int subAns = minCoinsRecursive(n - arr[i], arr);
                if(subAns != Integer.MAX_VALUE && subAns + 1 < ans){
                   ans = subAns +1 ;
                }
            }
        }
        return ans;
    }

    public int minCoinsDp(int n, int[] arr, int[] dp){
        if(n == 0){
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i< arr.length ; i++){
            if(n - arr[i] >=0){
                int subAns = 0;
                if(dp[n - arr[i]] != -1){
                    subAns = dp[n - arr[i]];
                } else {
                    subAns = minCoinsDp(n - arr[i], arr, dp);
                }
                if(subAns != Integer.MAX_VALUE && subAns + 1 < ans){
                    ans = subAns + 1;
                }
            }
        }
        dp[n] = ans;
        return ans;
    }

    public int knapsackRecursive(int[] weights, int[] profits, int bagTotal){
        return 0;
    }
}
