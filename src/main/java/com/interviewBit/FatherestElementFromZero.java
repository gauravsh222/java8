package com.interviewBit;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class FatherestElementFromZero {

    public static void main(String[] args) {

        int arr[] = new int[]{-10, 1,3,5,2,6, Integer.MAX_VALUE, Integer.MIN_VALUE};
//        usingJava8(arr);
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(Integer.MIN_VALUE);
        int min = 0;
        for (int i =0; i< arr.length; i++) {
            int a = arr[i];
            if (a > 0) {
                a = arr[i] * -1;
            }
            if(a < min) {
                min = Math.abs(arr[i]);
            }
        }
        System.out.println(min);
    }

    private static void usingJava8(int[] arr) {
        IntStream stream = Arrays.stream(arr);
        OptionalInt max = stream.map(Math::abs).max();
        System.out.println(max.orElse(0));
    }

}
