package com.designpatterns.strategy;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Java8Strategy {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        //write function to do sum
        System.out.println(makeSum(list, Java8Strategy::isEven)); // making sum of even number with same function
        System.out.println(makeSum(list, Java8Strategy::isOdd)); // making sum of odd number with same function
        System.out.println(makeSum(list, Java8Strategy::normal)); // making sum of all number with same function
        System.out.println(makeSum(list, n->greaterThanNumber(n, 3))); // making sum of numbers which are greater than 3 with same function

        //TODO: Actually we are strategy to sum function in the form of Predicate...based on that strategy sum is computed
    }

    private static Integer makeSum(List<Integer> list, Predicate<Integer> condition) {
        return list.stream().filter(condition).reduce(0, Integer::sum);
    }

    private static boolean greaterThanNumber(int n, int given) {
        return n > given;
    }

    private static boolean normal(int n) {
        return true;
    }

    private static boolean isOdd(int n) {
        return n % 2 != 0;
    }

    private static boolean isEven(int n) {
        return n % 2 == 0;
    }

}
