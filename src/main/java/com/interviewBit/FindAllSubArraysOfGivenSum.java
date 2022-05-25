package com.interviewBit;

import java.util.HashMap;
import java.util.Map;


/**
 * Approach-: we will keep sum of elements at each index in map and for the current index,
 * and will find difference b/w current sum and given sum so will get some number and that number must be present in map.
 *
 * If total current sum of 0->current index is 45, and give sum = 25 then if we find (current sum - given sum) in map
 * that means sum of element after the index where (current sum - given sum) was found is the given sum.
 */
public class FindAllSubArraysOfGivenSum {
    public static void main(String[] args) {
        int arr[] = { 29, -7, 5, 10, 8, 23 };
        int sum = 23;
        findAllSubArrays(arr, sum);
    }

    private static void findAllSubArrays(int[] arr, int sum) {

        Map<Integer, Integer> map = new HashMap<>();
        int current_sum = 0;
        for (int i=0; i<arr.length; i++) {
            current_sum += arr[i];
            if(map.containsKey(current_sum - sum)) {
                System.out.println("Pair sub array of given sum found at index : [" + (map.get(current_sum-sum)+1) + ", " + i + "]");
            }
            map.put(current_sum, i);
        }
    }
}
