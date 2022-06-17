package com.interviewBit;

public class StockBuySellMaxProfit {

    public static void main(String[] args) {
        int [] arr = new int[]{7,1,5,3,6,4};
        findMaxProfitInSingleTradeOnly(arr);
        findMaxProfitInSingleTradeOnly(new int[]{1,2});

    }

    private static void findMaxProfitInMultipleTrades(int[] arr) {

    }


    private static void findMaxProfitInSingleTradeOnly(int[] arr) {

        int buy = arr[0];
        int sell;
        int profit = 0;
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] < buy) {
                buy = arr[i];
                sell = buy;
            } else {
                sell = arr[i];
            }
            profit = Math.max(profit, sell - buy);
        }
        System.out.println(profit);
    }
}
