package com.recursion;

public class PrintHello {

    public static void print(int n) {
        if(n == 0 ) {
            return;
        }
        System.out.println("Hello Recursion Before : " + n);
        print(n-1);
        System.out.println("Hello Recursion After ::---> " + n);
    }

    public static void main(String[] args) {
        print(5);
    }
}
