package com.interviewBit;

import java.util.HashMap;
import java.util.Map;

public class FindAllSubArrayOfGivenSumWithNegative {
    public static void subArraySum(int[] arr, int n, int sum) {
        //cur_sum to keep track of cumulative sum till that point
        int cur_sum = 0;
        int start = 0;
        int end = -1;
        Map<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            cur_sum = cur_sum + arr[i];
            //check whether cur_sum - sum = 0, if 0 it means
            //the sub array is starting from index 0- so stop
            if (cur_sum - sum == 0) {
                start = 0;
                end = i;
//                break;
            }
            //if hashMap already has the value, means we already
            // have subarray with the sum - so stop
            if (hashMap.containsKey(cur_sum - sum)) {
                start = hashMap.get(cur_sum - sum) + 1;
                end = i;
                System.out.println("Sum found between indexes "
                        + start + " to " + end);
//                break;
            }
            //if value is not present then add to hashmap
            hashMap.put(cur_sum, i);


        }
    }

    // Driver code
    public static void main(String[] args) {
//        int[] arr = {10, 2, -2, -20, 10};
        int arr[] = { 15, 2, 4, 8, 9, 5, 10, -22, 23, 55 };
        int n = arr.length;
//        int sum = -10;
        int sum = 23;
        subArraySum(arr, n, sum);

    }
}
