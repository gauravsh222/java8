package com.interviewBit;

import java.util.Arrays;

public class SeiveOfEratosthense {
    private static String [] arr = new String[50+1];

    private static void printAllElements() {
        System.out.println(Arrays.toString(arr));
    }

    private static String isPrime(int a) {
        return arr[a];
    }

    private static void markAllNonPrimes() {
        arr[0]="N";
        arr[1]="N";

        for(int i=2; i<=Math.sqrt(arr.length); i++) {
            if ("Y".equalsIgnoreCase(isPrime(i))) {
                for(int j=i*2; j < arr.length; j+=i) {
                    arr[j] = "N";
                }
            }
        }
    }

    public static void main(String[] args) {
        Arrays.fill(arr, "Y");
        System.out.println(Math.sqrt(49));
        printAllElements();
        markAllNonPrimes();
        printAllElements();
        System.out.println(isPrime(50));
        findAllPrimes();
    }

    private static void findAllPrimes() {
       for(int i=0; i < arr.length; i++) {
           if("Y".equalsIgnoreCase(arr[i])) {
               System.out.print(i + " ");
           }
       }
    }


}
