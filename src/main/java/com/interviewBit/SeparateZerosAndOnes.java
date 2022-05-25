package com.interviewBit;

import java.util.Arrays;

public class SeparateZerosAndOnes {
    public static void main(String[] args) {
        int arr[]={0,1,1,0,0,1,1,0,1};
        System.out.println("Original Array: " + Arrays.toString(arr));
        arr=separate0s1sSolution2(arr);
        arr=mySolution(arr);
        System.out.println("Array after separating 0's and 1's : " + Arrays.toString(arr));
    }
    public static int[] mySolution(int arr[])
    {
        int left=0;
        int right=arr.length-1;
        int count=0;
        while (left<right){
            if(arr[left] != 0 && arr[right] != 1)
            {
                int temp=arr[left];
                arr[left]=arr[right];
                arr[right]=temp;
            }
            if(arr[left]==0)
            {
                left++;
            }
            if(arr[right]==1)
            {
                right--;
            }
            count++;
        }
        System.err.println("My Solution Count : " + count);
        return arr;
    }
    public static int[] separate0s1sSolution2(int arr[])
    {
        int left=0;
        int right=arr.length-1;
        int count=0;
        int lc=0;
        int rc=0;
        while (left<right){
            count++;
            while(arr[left]==0)
            {
                left++;
                lc++;
            }
            while(arr[right]==1)
            {
                right--;
                rc++;
            }

            if(left<right)
            {
                int temp=arr[left];
                arr[left]=arr[right];
                arr[right]=temp;
            }
        }
        System.err.println("Internet Solution Count : " + count);
        System.err.println("LC Count : " + lc);
        System.err.println("RC Count : " + rc);
        return arr;
    }
}
