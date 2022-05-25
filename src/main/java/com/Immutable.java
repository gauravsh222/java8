package com;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Immutable {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        System.out.println(new Float("3.0").byteValue());;
        map.put("a", "1");
        map.put("b", "2");
        System.out.println(map);

        Map<String, String> unmodifiableMap = Collections.unmodifiableMap(map);
        System.out.println(map);
        map.put("e", "5");
        System.out.println(map);
        unmodifiableMap.put("d", "4");
        System.out.println(map);

    }
}
