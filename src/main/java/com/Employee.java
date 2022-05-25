package com;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee {

    private String id;
    private String name;
    private String age;
    private String department;
    private Double salary;
    private List<String> mobile;

}
