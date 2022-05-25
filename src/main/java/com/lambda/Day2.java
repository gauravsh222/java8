package com.lambda;

import java.util.function.Predicate;

public class Day2 {

    public static void main(String[] args) {
        int n =10;
        Predicate<Integer> evenNumber = findEvenNumber(n);
        System.out.println(evenNumber);
    }

    private static Predicate<Integer> findEvenNumber(int n) {
        Predicate<Integer> p = i -> i % 2 == 0 && i >=0;
        return p;
    }
}
