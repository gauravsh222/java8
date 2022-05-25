package com.collections;

import java.util.HashMap;
import java.util.Map;

public class Manager {
    public static void main(String[] args)
    {
        //Create a HashMap with mutable key
        Map<Account, String> map = new HashMap<>();

        //Create key 1
        Account a1 = new Account(1);
        a1.setHolderName("ONE");
        //Create key 2
        Account a2 = new Account(2);
        a2.setHolderName("TWO");

        //Put mutable key and value in map
        map.put(a1, a1.getHolderName());
        map.put(a2, a2.getHolderName());

        System.out.println(map);
/*        a1 = new Account(1);
        a1.setHolderName("ONE");
        map.put(a1, a1.getHolderName());
        System.out.println(map.get(a1) + " : " + map);*/
        map.entrySet().stream().forEach(entry-> System.out.println(entry.getKey().hashCode()));
        //Change the keys state so hash map should be calculated again
        a1.setHolderName("Defaulter");
        a2.setHolderName("Bankrupt");

        System.out.println(map);

        //Success !! We are able to get back the values
        System.out.println(map.get(a1)); //Prints A_ONE
        System.out.println(map.get(a2)); //Prints A_TWO

        //Try with newly created key with same account number
        Account a3 = new Account(1);
        a3.setHolderName("Defaulter");

        //Success !! We are still able to get back the value for account number 1
        System.out.println(map.get(a3)); //Prints A_ONE
    }
}
