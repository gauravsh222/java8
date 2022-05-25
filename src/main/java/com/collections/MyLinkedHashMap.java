package com.collections;

import java.util.LinkedHashMap;

public class MyLinkedHashMap {
    public static void main(String[] args) {
        LinkedHashMap<Integer, String> map = new LinkedHashMap<>(4, 0.75f, true);
        map.put(1, "A");
        map.put(2, "B");
        map.put(3, "C");
        map.put(4, "D");
        System.out.println(map);
        map.get(4);
        System.out.println(map);
        map.put(5, "E");
        System.out.println(map);
    }
}
