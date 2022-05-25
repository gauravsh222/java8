package com.interviewBit;

public class GoodMeals {
    public static void main(String[] args) {
        int arr[] = { 1,3,5,7,9 };
        int n = arr.length;
        findPairs(arr,n);
//        System.out.println(powerOfTwo(0));
    }

    private static void findPairs(int[] arr, int n) {

    }

    private static boolean powerOfTwo(int n) {
        if(n==1) {
            return true;
        }
       if(n%2 != 0 || n==0) {
           return false;
       }
       return powerOfTwo(n/2);
    }
}
