package com.interviewBit;

import java.util.Arrays;

public class RotateArray {

    public static void main(String[] args) {
        int[] arr = { 1,2,3,4,5,6,7 };
        for (int i = 0; i < 2; i++) {
            System.out.println(Arrays.toString(rotate(arr)));
        }
    }

    private static int[] rotate(int[] arr) {
        int temp = arr[0];
        for (int i = 0; i < arr.length-1; i++) {
            arr[i] = arr[i+1];
        }
        arr[arr.length-1] = temp;
        return arr;
    }
}
