package com.autoBots.java.streamApi;

import com.autoBots.java.streamApi.Employee;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FindAverageSalary {
    public static void main(String[] args) {

        // найти среднюю зп сотрудников каждого департамента

        List<Employee> employees = List.of(
                new Employee(1, "Alice", 28, 3000, "IT"),
                new Employee(2, "Bob", 35, 4000, "HR"),
                new Employee(3, "Charlie", 40, 5000, "Finance"),
                new Employee(4, "David", 25, 3500, "IT"),
                new Employee(5, "Eva", 30, 4200, "Marketing"),
                new Employee(6, "Frank", 45, 6000, "Finance"),
                new Employee(7, "Grace", 32, 4100, "HR"),
                new Employee(8, "Henry", 29, 3900, "IT"),
                new Employee(9, "Isabel", 38, 4500, "Marketing"),
                new Employee(10, "Jack", 27, 3600, "IT")
        );

        Map<String, Double> totalSalaryByDep = new HashMap<>();
        Map<String, Integer> averageSalaryByDep = new HashMap<>();

        for (Employee employee : employees) {
            averageSalaryByDep.put(employee.getDepartment(),
                    averageSalaryByDep.getOrDefault(employee.getDepartment(), 0)
                            + employee.getSalary());
            totalSalaryByDep.put(employee.getDepartment(),
                    totalSalaryByDep.getOrDefault(employee.getDepartment(), 0.0) + 1);
        }
        double salary = 0.0;

        for (String dep : averageSalaryByDep.keySet()){
            salary = averageSalaryByDep.get(dep) / totalSalaryByDep.get(dep);
            System.out.printf("%s -> $%.2f%n", dep, salary);
        }
        // streamApi
        System.out.println("--------srteamApi----------");

        Map<String, Double> averageSalaryByDepStream = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)));
        averageSalaryByDepStream.forEach((dep, avarSalary) ->
                System.out.println(dep + " -> " + "$" + avarSalary));

    }
}
