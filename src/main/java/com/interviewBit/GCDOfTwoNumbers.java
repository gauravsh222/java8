package com.interviewBit;

public class GCDOfTwoNumbers {

    private static int gcd(int a, int b) {
        while (true) {
            if(b==0) {
                return a;
            }
            int temp = b;
            b = a%b;
            a=temp;
        }
    }

    private static int gcdRecursive(int a, int b) {

        if (b==0)
            return a;

        return gcdRecursive(b, a%b);
    }

    public static void main(String[] args) {
        System.out.println(gcd(36,60));
        System.out.println(gcdRecursive(36,60));
    }

}
