package com.streams;

import com.Employee;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

class Book {
    private String title;
    private Double price;

    public Book(String title, Double price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}

public class StreamsApi {

    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("1", "Abhishek", "10", "dev", 10000d, Arrays.asList("11","22","33","44")));
        list.add(new Employee("2", "Gaurav", "90", "dev", 12000d, Arrays.asList("111","222","333","444")));
        list.add(new Employee("3", "Garima", "43", "test", 27000d, Arrays.asList("111","222","333","444")));
        list.add(new Employee("4", "Ishan", "33", "test", 32000d, Arrays.asList("111","222","333","444")));
        list.add(new Employee("5", "Gaurav", "33", "IT", 32000d, Arrays.asList("111","222","333","444")));
        list.add(new Employee("6", "Abhishek", "33", "IT", 32000d, Arrays.asList("111","222","333","444")));


        // sort employee base on name....

        List<Employee> employees = list.stream().sorted(Comparator.comparing(Employee::getName).thenComparing(Employee::getAge)).toList();
        employees.forEach(e -> System.out.println(e.getName() + " : " + e.getAge()));


        Map<String, List<Employee>> collect = list.stream().collect(Collectors.groupingBy(Employee::getName));


        System.out.println("------------------------");
        String str = "This is a simple java program java is cool";
        String[] arr = str.split(" ");
//        Map<Object, Long> map = Arrays.stream(arr).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//        map.forEach((s, occ) -> System.out.println(s + " : " + occ));


        List<String> names = Arrays.asList("varun", "Abhishek", "Gaurav", "Garima", "Ishan");
        names.stream().sorted(Comparator.comparing(s -> s, String::compareTo)).toList().forEach(System.out::println);


        Map<String, List<Employee>> departments = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.println(departments);

        Map<String, Long> count = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        System.out.println(count);

        Map<String, Double> avgSalary = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(avgSalary);

        Map<String, Double> summery = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.summingDouble(Employee::getSalary)));
        System.out.println(summery);

        Map<String, List<Double>> salayList = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,
                                                                            Collectors.mapping(Employee::getSalary, Collectors.toList())));
        System.out.println(salayList);

        Double reduce = employees.stream().map(Employee::getSalary).reduce((double) 0, Double::sum);

        Map<String, String> toMap = employees.stream().collect(Collectors.toMap(Employee::getName, Employee::getDepartment, (emp1, emp2)-> emp2));
        System.out.println(toMap);


        Map<String, Employee> collect1 = employees.stream().collect(Collectors.toMap(Employee::getDepartment, Function.identity(), (employee, employee2) -> employee));
        System.out.println(collect1);


        List<Book> bookList = Arrays.asList(new Book("Love Story", 10d), new Book("Micro Services", 1000d),
                                            new Book("Distributed Systems", 1000d), new Book("Distributed Systems", 2000d));

        Map<String, Double> bookMap = bookList.stream().collect(Collectors.toMap(Book::getTitle, Book::getPrice));
        System.out.println(bookMap);


    }


}
