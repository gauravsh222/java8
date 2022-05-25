package com.interviewBit;

public class FindIfGivenNumbersAreConsecutive {

    public static void main(String[] args) {
        int [] arr = new int[]{10,11,7,12};
        int diff = arr[arr.length-1] - arr[0];
        System.out.println(diff == arr[arr.length-1]);
    }
}
