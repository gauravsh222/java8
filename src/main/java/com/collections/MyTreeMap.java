package com.collections;

import java.util.TreeMap;

public class MyTreeMap {
    public static void main(String[] args) {
        TreeMap<String, Integer> map = new TreeMap<>();
        map.put("B", 2);
        map.put("A", 1);
        System.out.println(map);
    }
}
