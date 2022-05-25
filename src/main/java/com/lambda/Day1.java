package com.lambda;

@FunctionalInterface
interface I1 {
    void m1();
}

@FunctionalInterface
interface I2 {
    void add(int a, int b);
}
public class Day1 {

    public static void main(String[] args) {
        build_I1();
        build_I2();

    }

    private static void build_I2() {
        I2 i = (a, b) -> System.out.println(a+b);
        i.add(4,5);
    }

    private static void build_I1() {
        I1 i = () -> System.out.println("Hello World");
        i.m1();
        i.m1();
    }
}
