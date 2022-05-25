package com.collections;

import java.util.HashMap;
import java.util.Map;

public class HashMapInternal {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        String put = map.put("key1", "value");
        String put2 = map.put("key2", "value2");
        System.out.println(put);
        System.out.println(put2);
        String putIfAbsent = map.putIfAbsent("key", "val");
        System.out.println(putIfAbsent);
        System.out.println(map);
        map.replace("key", "replace");
        System.out.println(map);
        map.replace("key", "replace", "new value");
        System.out.println(map);

        checkIfTreeCreated();


    }

    private static void checkIfTreeCreated() {
        Map<Account, Integer> map = new HashMap<>();
        for(int i = 1; i < 7; i++){
            Account account = new Account(i);
            account.setHolderName("test-"+i);
            map.put(account, i);
        }
        Account account = new Account(8);
        account.setHolderName("test-"+8);
        map.put(account, 8);
        Account account2 = new Account(9);
        account.setHolderName("test-"+9);
        map.put(account, 9);

        System.out.println(map.size());
    }
}
