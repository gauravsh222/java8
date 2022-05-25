package com.interviewBit;

public class SubArrayOfGivenSum {

    public static void main(String[] args)
    {
//        int arr[] = { 15, 2, 4, 8, 9, 5, 10, 23 };
        int arr[] = { 29, 5, 10, 8, 23 };
        int n = arr.length;
        int sum = 23;
        findSubArrays(arr, n, sum);
//        findSingle(arr, n, sum);
//        solveEfficient(arr, sum);
//        solveEfficient(arr, sum);
    }

    public static void solveEfficient(int[] arr, int target) {
        int start = 0, end = 0;

        int currSum = 0;

        while (start < arr.length && end <= arr.length) {
            if (currSum == target) {
                System.err.println("Efficient starting index : " + start + ", " +
                        "Ending index : " + (int) (end - 1));
                if (end <= arr.length - 1) {
                    currSum += arr[end];
                }
                end++;
            }
            else {
                if (currSum > target) {
                    currSum -= arr[start++];
                } else {
                    currSum += arr[end++];
                }
            }
        }
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
