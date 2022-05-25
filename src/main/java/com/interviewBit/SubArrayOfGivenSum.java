package com.interviewBit;

public class SubArrayOfGivenSum {

    /** All these approaches does not work if negative values are included in array

        This approach is base on sliding window technique

     */

    public static void main(String[] args)
    {
//        int arr[] = { 15, 2, 4, 8, 9, 5, 10, 23 };
        int arr[] = { 29, 7, 5, 10, 8, 23 };
        int n = arr.length;
        int sum = 23;
        findSubArrays(arr, n, sum);
    }

    private static void findSubArrays(int[] arr, int n, int sum) {
        int start=0, curr=arr[0], end=1;
        while (start < n && end <= n) {
            if(curr == sum) {
                System.out.println("start : " + start + " and end index : " + (end-1));
                if (end < n) {
                    curr += arr[end];
                }
                end++;
            } else {
                if (curr < sum) {
                    curr += arr[end++];
                } else {
                    curr -= arr[start++];
                }
            }
        }
    }
}
