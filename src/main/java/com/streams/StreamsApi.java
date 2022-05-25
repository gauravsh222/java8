package com.streams;

import com.Employee;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamsApi {

    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("1", "Abhishek", "10", "dev", 10000d, Arrays.asList("11","22","33","44")));
        list.add(new Employee("2", "Gaurav", "90", "dev", 12000d, Arrays.asList("111","222","333","444")));
        list.add(new Employee("3", "Garima", "43", "dev", 27000d, Arrays.asList("111","222","333","444")));
        list.add(new Employee("4", "Ishan", "33", "dev", 32000d, Arrays.asList("111","222","333","444")));
        list.add(new Employee("5", "Gaurav", "33", "dev", 32000d, Arrays.asList("111","222","333","444")));
        list.add(new Employee("6", "Abhishek", "33", "dev", 32000d, Arrays.asList("111","222","333","444")));


        // sort employee base on name....

        List<Employee> employees = list.stream().sorted(Comparator.comparing(Employee::getName).thenComparing(Employee::getAge))
                                                                                            .collect(Collectors.toList());
        employees.forEach(e -> System.out.println(e.getName() + " : " + e.getAge()));


        Map<String, List<Employee>> collect = list.stream().collect(Collectors.groupingBy(Employee::getName));


        System.out.println("------------------------");
        String str = "This is a simple java program java is cool";
        String[] arr = str.split(" ");
        Map<Object, Long> map = Arrays.stream(arr).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        map.forEach((s, occ) -> System.out.println(s + " : " + occ));


        List<String> names = Arrays.asList("varun", "Abhishek", "Gaurav", "Garima", "Ishan");
        names.stream().sorted(Comparator.comparing(s -> s, String::compareTo)).collect(Collectors.toList()).forEach(System.out::println);

    }


}
