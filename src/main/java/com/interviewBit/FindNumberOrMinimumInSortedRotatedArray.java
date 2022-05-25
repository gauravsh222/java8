package com.interviewBit;

public class FindNumberOrMinimumInSortedRotatedArray {
    public static void main(String[] args) {
        int arr[]={16,19,21,25,3,5,8,10};
//        System.out.println("Index of element 5 : "+findElementRotatedSortedArray(arr,0,arr.length-1,5));
        System.out.println("Minimum element : "+findMinimumElementRotatedSortedArray(arr,0,arr.length-1));
    }

    public static int findMinimumElementRotatedSortedArray(int[] arr,int low,int high)
    {
        int mid;
        while(low<high)
        {
            mid=low + ((high - low) / 2);

            if(arr[mid] > arr[high])
            {
                low=mid+1;
            }
            else
            {
                high=mid;
            }
        }
        return arr[low];
    }

    //TODO: Below solution is wrong need to updated it
    public  static  int findElementRotatedSortedArray(int[] arr,int low,int high,int n) {
        int mid=0;
        while (low<high) {
            if(arr[mid] == n) {
                break;
            }
            mid = (low + high)/2;
            //consider left side array
            if(n < arr[mid] && n > arr[low]) {
                high = mid-1;
            }
            // consider right side array
            else if(n > arr[mid] && n < arr[high]) {
                low = mid+1;
            }
        }
        return arr[mid];
    }
}
