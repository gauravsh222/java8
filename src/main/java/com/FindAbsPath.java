package com;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class FindAbsPath {

    public static void main(String[] args) {
        System.out.println(findAbsPath("home/oracle/../bin"));;
    }

    private static String findAbsPath(String input) {

        String [] arr = input.split("/");
        List<String> list = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if(".".equals(arr[i])) {
                //do nothing
            } else if ("..".equals(arr[i])) {
                list.remove(list.size()-1);
            } else {
                list.add(arr[i]);
            }
        }
        StringJoiner output = new StringJoiner("/");
        for (String str : list) {
            output.add(str);
        }

        return output.toString();
    }
}
// {home, java, lib }