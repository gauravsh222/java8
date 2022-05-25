package com.solidprinciples;

import java.util.*;

public class LiskovSubstitution {

    public static void main(String[] args) {
        LiskovSubstitution liskovSubstitution = new LiskovSubstitution();
        System.out.println(liskovSubstitution.buildMyList(new ArrayList<>()));
        System.out.println(liskovSubstitution.buildMyList(new LinkedList<>()));
        Vector<String> vectorStack = liskovSubstitution.liskovWithVectorStack(new Stack<>());
        System.out.println(vectorStack);
    }

    private Vector<String> liskovWithVectorStack(Vector<String> vector) {
        vector.add("1");
        vector.add("2");
        vector.add("3");
        vector.add("4");
        return vector;
    }

    private List<String> buildMyList(List<String> list) {
        list.add("a1");
        list.add("a2");

        LinkedList<String> l = (LinkedList<String>) list;
        l.peek();
        return list;
    }
}
