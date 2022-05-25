package com.interviewBit;

public class MaxSumOfGivenSubArraySize {
    public static void main(String[] args) {
        int[] arr = { 5, 2, -1, 0, 3 };
//        int[] arr = { 1, 4, 2, 10, 23, 3, 1, 0, 20 };
//        int[] arr = { 1, 4, 2, 10, 2, 3, 1, 0, 20 };
        int k = 3;
        System.out.println(findSum(arr, k));
    }

    private static int findSum(int[] arr, int k) {
        int n = arr.length;
        int max=0;
        for(int i=0; i<=n-k; i++) {
            int curr=0;
            for (int j=i; j<i+k; j++) {
                curr += arr[j];
            }
            max = Math.max(curr,max);
        }
        return max;
    }
}
