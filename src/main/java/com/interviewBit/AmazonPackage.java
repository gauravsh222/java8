package com.interviewBit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AmazonPackage {

    public static void main(String[] args) {
        findHeaviestWeight(new int[]{2,9,10,3,7});
        findHeaviestWeight(new int[]{20,13,8,9});
    }

    // Travers from right and find solution
    private static void findHeaviestWeight(int[] arr) {
        int sum=arr[arr.length-1];
        int max=arr[arr.length-1];
        for (int i = arr.length-2; i >= 0; i--) {
            if(arr[i] < sum) {
                sum = sum + arr[i];
            } else {
                sum = arr[i];
            }
            max = Math.max(max, sum);
        }
        System.out.println(max);
    }

}
