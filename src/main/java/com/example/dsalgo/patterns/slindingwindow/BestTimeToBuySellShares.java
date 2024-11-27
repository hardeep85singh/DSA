package com.example.dsalgo.patterns.slindingwindow;

public class BestTimeToBuySellShares {
    public static void main(String[] args) {
        int[] prices = {9,2,4,2,5,7,2,4,9,0,9};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices){
        int maxProfit = 0;
        int buy = 0;
        for (int sell = 1; sell < prices.length; sell++){
            int currProfit = prices[sell] - prices[buy];
            if(prices[buy] < prices[sell]){
                maxProfit = Math.max(currProfit, maxProfit);
            } else {
                buy = sell;
            }
        }
        return maxProfit;
    }
}
