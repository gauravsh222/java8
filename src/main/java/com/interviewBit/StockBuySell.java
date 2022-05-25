package com.interviewBit;

public class StockBuySell {

    public int maxProfit(int[] arr) {
        int min=arr[0], max=arr[0];
        int profit=0;
        for(int i = 1; i < arr.length; i++) {

            if(arr[i] > max) {
                max = arr[i];
            } else if(arr[i] < min) {
                if(profit < max-min) {
                    profit = max-min;
                }
                min = arr[i];
                max=min;
            }
        }
        if(profit < max-min) {
            profit = max-min;
        }

        return profit;

    }

    public static void main(String[] args) {

    }
}
