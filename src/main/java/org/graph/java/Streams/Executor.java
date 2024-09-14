package org.graph.java.Streams;

import java.util.*;
import java.util.stream.Collectors;

public class Executor {
    public static void main(String[] args) {

        List<Patient> patients = Arrays.asList(
                new Patient("P1",20,"Corona",18000),
                new Patient("P2",26,"Fever",6000),
                new Patient("P3",29,"Corona",8000),
                new Patient("P4",23,"Corona",12000)
        );

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("ABC",30,"Female","HR"));
        employees.add(new Employee("PQR",25,"Male","IT"));
        employees.add(new Employee("LMN",30,"Male","HR"));
        employees.add(new Employee("XYZ",28,"Female","IT"));

        List<Integer> list = Arrays.asList(1,4,5,6,22,3,90,89,2,1,3,4,55,6);


        //Print average amount for patients having disease as Corona
        double averageAmount =  patients.stream().filter(patient -> patient.getDisease().equalsIgnoreCase("corona"))
                .collect(Collectors.averagingDouble(Patient::getAmount));
        System.out.println("Average Amount: " + averageAmount);

        //Print all the distinct departments
        List<String> distinctDepts = employees.stream().map(patient -> patient.getDepartment()).distinct().collect(Collectors.toList());
        System.out.println(distinctDepts);

        //Count of Employees Dept wise
        Map<String, Long> countDeptWise = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        System.out.println(countDeptWise);

        //Average age of male and female employees
        Map<String, Double> avgAgeMaleFemale = employees.stream().collect(Collectors.groupingBy(employee -> employee.getGender(), Collectors.averagingInt(employee -> employee.getAge())));
        System.out.println(avgAgeMaleFemale);

        // Sum of All Numbers
        list.stream().reduce((a,b) -> a+b).ifPresent(System.out::println);

        int sum = list.stream().mapToInt(x -> x).sum();
        System.out.println(sum);

        //Average of All Numbers
        list.stream().mapToInt(x -> x).average().ifPresent(System.out::println);

        //Get Squared Average
        list.stream().map(x -> x*x).mapToInt(x -> x).average().ifPresent(System.out::println);

        //GetSquare Average for numbers whose squared values are less than 500
        list.stream().map(x -> x*x).filter(x -> x < 500).mapToInt(x -> x).average().ifPresent(System.out::println);

        //Odd and Even numbers out of the list
        List<Integer> even = list.stream().filter(x-> x%2 ==0).collect(Collectors.toList());
        List<Integer> odd = list.stream().filter(x-> x%2 ==1).collect(Collectors.toList());
        System.out.println("Even: " + even);
        System.out.println("Odd: " + odd);

        //Numbers Staring with 5
        List<Integer> nums = list.stream().filter(number -> String.valueOf(number).startsWith("5")).collect(Collectors.toList());
        System.out.println(nums);

        //Find Duplicate Numbers
        
        //Max and Min Number

        //Sort the number
        //Increasing

        //Decreasing

        // Get Sum of first 5 numbers

        //skip the first five numbers and sum rest

        //get second highest and second lowest number
        //second lowest

        //second highest
    }
}