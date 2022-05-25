package com.interviewBit;

public class NumberOccuringOddTimes {

    public static void main(String[] args) {
        int arr [] = new int[]{20, 40, 50, 40, 50, 20, 30, 30, 50, 20, 40, 40, 20};
        System.out.println(find(arr));
    }

    private static int find(int[] arr) {
        int i;
        int result = 0;
        for (i = 0; i < arr.length; i++)
        {
            result = result ^ arr[i];
        }
        return result;
    }
}
