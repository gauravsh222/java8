package com.interviewBit;

public class SlidingWindowMaxSum {
    public static void main(String[] args) {
//        int[] arr = { 5, 2, -1, 0, 3 };
                int[] arr = { 10, 4, 7, 5, 90, -20, 8, 7, 99, 65 };
//                int[] arr = { 1, 4, 2, 10, 23, 3, 1, 0, 20 };
//        int[] arr = { 1, 4, 2, 10, 2, 3, 1, 0, 20 };
        System.out.println(slidingWindowApproach(arr, 6));
    }

    private static int slidingWindowApproach(int[] arr, int k) {
        // compute sum of first k elements
        int sum = 0,max = 0;
        for (int i=0; i<k; i++) {
            sum += arr[i];
        }
        max = sum;
        int sub = 0;
        for (int i=k; i<arr.length; i++) {
            sum += arr[i]-arr[sub++];
            max = Math.max(sum, max);
        }
        return max;
    }

    // Returns maximum sum in
    // a subarray of size k.
    static int maxSumBruteForce(int arr[], int n, int k)
    {
        // Initialize result
        int max_sum = Integer.MIN_VALUE;

        // Consider all blocks starting with i.
        for (int i = 0; i <= n - k; i++) {
            int current_sum = 0;
            for (int j = i; j < i+k; j++) {
                current_sum = current_sum + arr[j];
            }
            // Update result if required.
            max_sum = Math.max(current_sum, max_sum);
        }
        return max_sum;
    }
}
