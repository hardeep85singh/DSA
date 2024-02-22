package com.example.dsalgo.leetcode.easy;

/**
 * @author Hardeep Singh
 */
public class E121BestTimeToBuySellStock {
    public static void main(String[] args){
        int [] prices = {3,5,7,3,1,7};
        System.out.print(maxProfitEfficient(prices));
    }

    public static int maxProfitBrute(int[] prices) {
        int maxProfit = 0;
        int buyPrice = 0;
        int sellPrice = 0;
        for(int i = 0; i< prices.length; i++){
            buyPrice = prices[i];
            for(int j = i+1; j < prices.length; j++){
                sellPrice = prices[j];
                if(buyPrice < sellPrice){
                   maxProfit = Math.max(maxProfit, (sellPrice-buyPrice));
                }
            }
        }

        return maxProfit;
    }

    public static int maxProfitEfficient(int[] prices) {
        int maxProfit = 0;
        int i = 0;
        int j = 0;
        while (j < prices.length-1){
            j++;
            if(prices[i] > prices[j]){
                i = j;
            } else {
                maxProfit = Math.max(maxProfit, (prices[j] - prices[i]));

            }
        }

        return maxProfit;
    }
}
