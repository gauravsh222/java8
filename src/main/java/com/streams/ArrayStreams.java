package com.streams;

import com.Employee;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ArrayStreams {

    public static void main(String[] args) {
//        System.out.println(Runtime.getRuntime().availableProcessors());
        int [] arr = new int[]{3,5,4,8,6,2,9,1};
        Stream<Integer> stream = Stream.of(3, 5, 4, 8, 6, 2, 9, 1);

        stream.map(i-> i+i).forEach(System.out::println);
        boolean noneMatch = IntStream.range(0, 100).noneMatch(i -> i > 500);
        System.out.println("noneMatch: " +noneMatch);

       /* String [] str = new String[]{"G", "F", "D", "A", "C", "B"};
        Stream<String> str1 = Stream.of(str);
        str1.sorted(Comparator.reverseOrder()).forEach(System.out::print);
        str1 = Stream.of(str);
        Map<String, String> collect = str1.collect(Collectors.toMap(c -> c + ":" + 0, c -> c));
        collect.forEach((key, value)->System.out.println(key + " : " + value));
        System.out.println(Arrays.stream(arr).sorted());
        IntStream stream = Arrays.stream(arr);
        System.out.println(stream.anyMatch(a -> a<2));
        System.out.println(Arrays.stream(arr).average());
        System.out.println(Arrays.stream(arr).sum());

        System.out.println(Arrays.stream(arr).max().getAsInt());

        Stream<Integer> boxed = Arrays.stream(arr).boxed();
        System.out.println(boxed.toArray());

        OptionalInt any = Arrays.stream(arr).findAny();
        System.out.println(any.getAsInt());


        OptionalInt first = Arrays.stream(arr).findFirst();
        System.out.println(first.getAsInt());*/

        /*Map<String, String > map = new HashMap<>();
        map.put("A", "A");
        map.put("B", "B");
        map.put("C", "C");
        map.entrySet().stream().mapToInt(str->0).forEach(i-> System.out.println(i));
        map.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getKey));
        map.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.reverseOrder())).limit(2).forEach(System.out::println);
        System.out.println();*/

        Map<String, Employee> map = new HashMap<>();
        map.put("1", new Employee("1", "A", "10", "dev", 10000d, Arrays.asList("11","22","33","44")));
        map.put("2", new Employee("2", "B", "90", "dev", 12000d, Arrays.asList("111","222","333","444")));
        map.put("7", new Employee("7", "G", "43", "dev", 27000d, Arrays.asList("111","222","333","444")));
        map.put("8", new Employee("8", "I", "33", "dev", 32000d, Arrays.asList("111","222","333","444")));

        map.put("3", new Employee("3", "C", "30", "test",25000d, Arrays.asList("1111","2222","3333","4444")));
        map.put("4", new Employee("4", "D", "20", "test",35000d, Arrays.asList("aa","bb","cc","dd")));

        map.put("5", new Employee("5", "E", "25", "manager",22000d, Arrays.asList("aaa","bbb","ccc","ddd")));
        map.put("6", new Employee("6", "F", "35", "manager",11000d, Arrays.asList("aaaa","bbbb","cccc","dddd")));

//        infiniteStream();
        experimentalMethod(map);
//        multiplyAllElementsByNumber(5);
//        findOccurancesOfSingleCharInString("India is my country");
//        sumOfAllNumbers();
//        readStreamsOfWordsFromFile();
//        flattenAllPhoneNumbers(map);
    }

    private static void findOccurancesOfSingleCharInString(String str) {
        IntStream stream = str.toLowerCase().chars();
        System.out.println("------------------");
        long count = stream.filter(i -> 'i' == i).count();
        System.out.println(count);
    }

    private static void multiplyAllElementsByNumber(int n) {
        int [] arr = new int[]{1,2,3,4,5};
        Arrays.stream(arr).map(i->i*n).forEach(System.out::println);
    }

    private static void infiniteStream() {
        StringJoiner joiner = new StringJoiner(",");
        Stream<Integer> iterate = Stream.iterate(1, n -> n + 1).limit(100);
        iterate.map(i->joiner.add(""+i)).forEach(System.out::print);
    }

    private static void flattenAllPhoneNumbers(Map<String, Employee> map) {
        List<Employee> employees = map.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList());
        List<String> list = map.entrySet().stream().flatMap(employee -> employee.getValue().getMobile().stream()).collect(Collectors.toList());
        System.out.println(list);
        List<List<String>> collect = map.entrySet().stream().map(entry -> entry.getValue().getMobile()).collect(Collectors.toList());
        System.out.println(collect);

    }

    private static void readStreamsOfWordsFromFile() {
        try (Stream<String> lines = Files.lines(Paths.get("sample.txt"), StandardCharsets.UTF_8)) {
            lines.forEach(line -> System.out.println(Arrays.toString(line.split(" "))));
            System.out.println("-------------------------");
            Stream<String> words = lines.flatMap(line -> Stream.of(line.split(" +")));
            words.forEach(System.out::println);
        } catch (IOException e) {
            System.err.println("Error while reading file");
            throw new RuntimeException(e);
        }
    }

    private static void sumOfAllNumbers() {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < 50000000; i++) {
            list.add(i);
        }

        System.out.println("----------Sum using Parallel Streams------------");
        long pre = System.currentTimeMillis();
//        System.out.println(list.stream().parallel().mapToInt(n -> n).sum());
        System.out.println(list.stream().parallel().mapToInt(i -> i).sum());
        System.out.println(System.currentTimeMillis() - pre);

        System.out.println("----------Sum using Streams------------");
        pre = System.currentTimeMillis();
//        System.out.println(list.stream().mapToInt(n -> n).sum());
        System.out.println(list.stream().mapToInt(i -> i).sum());
        System.out.println(System.currentTimeMillis() - pre);

    }

    private static void experimentalMethod(Map<String, Employee> map) {
       //print map
        /*map.keySet().forEach(str->System.out.println(map.get(str)));
        map.entrySet().forEach(entry-> System.out.println(entry.getKey() + ":" + entry.getValue()));
        map.forEach((key, value) -> System.out.println(key + ":" + value));*/

        System.out.println(map.entrySet().stream().findAny().filter(entry->"A".equals(entry.getValue().getName())));
        System.out.println("----------Count Of Entries in Map-------------");
        System.out.println(map.entrySet().stream().count());
        System.out.println("----------Max Age-------------");
        System.out.println(map.entrySet().stream().max(Map.Entry.comparingByValue(Comparator.comparing(Employee::getAge))).get());
        System.out.println("---------Sorted Map Based On Age Reverse Order--------------");
        map.entrySet().stream().sorted(Comparator.comparing(entry->entry.getValue().getAge(), Comparator.reverseOrder())).forEach(System.out::println);
        List<Employee> list = map.entrySet().stream().map(entry -> entry.getValue()).collect(Collectors.toList());
        System.out.println();
        System.out.println("--------Employee List---------------");
        System.out.println(list);
        System.out.println();
        System.out.println("------- Group By Department ----------------");
        Map<String, List<Map.Entry<String, Employee>>> groupBy = map.entrySet().stream().
                                                                    collect(Collectors.
                                                                                groupingBy(entry -> entry.getValue().getDepartment()));
        groupBy.forEach((key, val)-> System.out.println(key + " : " + val.stream().map(entry->entry.getValue().getName()).collect(Collectors.toList())));

        // List operations with stream

        System.out.println();

        List<Employee> employeeList = map.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList());

        System.out.println("--------------Group Employees By Department-------------------");
        Map<String, List<Employee>> groupByList = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.println(groupByList);

        System.out.println();
        System.out.println("--------------Employees Salary Sum By Department-------------------");
        Map<String, Double> salarySumByDept = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment,
                                                                                                Collectors.summingDouble(Employee::getSalary)));
        salarySumByDept.forEach((key, val)-> System.out.println(key + " : " + val));

        System.out.println();
        System.out.println("--------------Employees Count By Department-------------------");
        employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()))
                                .forEach((key, val)-> System.out.println(key + " : " + val));

        System.out.println();
        System.out.println("--------------Employees Salaries By Department-------------------");
        employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.mapping(Employee::getSalary, Collectors.toList())))
                .forEach((key, val)-> System.out.println(key + " : " + val));

        System.out.println("--------------Employees Statisticcs By Department-------------------");
        Map<String, DoubleSummaryStatistics> summaryStatisticsMap = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment,
                                                                                                                            Collectors.summarizingDouble(Employee::getSalary)));
        summaryStatisticsMap.forEach((key, val)-> {
                    System.out.print(key);
                    System.out.print(", Avg : " + val.getAverage());
                    System.out.print(", Count : " + val.getCount());
                    System.out.print(", Max : " + val.getMax());
                    System.out.print(", Min : " + val.getMin());
                    System.out.println(", Sum : " + val.getSum());
                }
        );

        System.out.println("--------------Employees List Covert to Map-------------------");
        Map<String, Employee> employeeMap = employeeList.stream().collect(Collectors.toMap(Employee::getName, employee -> employee));

        System.out.println();
        System.out.println();
        System.out.println("--------------Reduce Method-------------------");
        List<String> collect = employeeList.stream().flatMap(employee -> employee.getMobile().stream()).collect(Collectors.toList());
        System.out.println(collect);
        Optional<String> reduce = collect.stream().reduce((s1, s2) -> s1 + " : " + s2);
        System.out.println("Reduce " + reduce.get());

        System.out.println();
        System.out.println();
        System.out.println("--------------Partition By Method-------------------");

        Map<Boolean, List<String>> partiotionBy = employeeList.stream().
                collect(Collectors.partitioningBy(ArrayStreams::isSalaryMoreThan_25000,
                        Collectors.mapping(Employee::getName, Collectors.toList())));
//        employeeList.stream().collect(Collectors.partitioningBy(e->e.getSalary() >= 25000));

        System.out.println(partiotionBy);

        System.out.println("--------------Filter Employee Based on Location and Salary Greater Than 50K-------------------");
        List<String> employees = employeeList.stream().filter(ArrayStreams::isEmployeeFromDevDepartment)
                                                         .filter(ArrayStreams::isSalaryMoreThan_25000)
                                                            .map(Employee::getName)
                                                                .collect(Collectors.toList());
//        Predicate<Employee> predicate = ArrayStreams::isEmployeeFromDevDepartment;
//        predicate = predicate.and(ArrayStreams::isSalaryMoreThan_25000);
//        List<String> employees = employeeList.stream().filter(predicate).map(Employee::getName).collect(Collectors.toList());
        System.out.println(employees);


    }

    private static boolean isEmployeeFromDevDepartment(Employee employee) {
        return "dev".equalsIgnoreCase(employee.getDepartment());
    }
    private static boolean isSalaryMoreThan_25000(Employee employee) {
        return employee.getSalary() >= 25000;
    }

}

