package com.autoBots.java.streamApi;

import com.autoBots.java.streamApi.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class StreamApiLesson {

    public static void main(String[] arg){
// вывести имена начинающиеся с А и все буквы заглавные
        List<String> names = List.of("Anna", "Bob", "Alex", "Bella", "Andrew");
        List<String> nameWithA = new ArrayList<>();
        for (String name : names){
            if (name.startsWith("A")) {
               nameWithA.add(name.toUpperCase());
               Collections.sort(nameWithA);
            }
        }
        System.out.println(nameWithA);

        List<String> result = names.stream()
                .filter(name -> name.startsWith("A")) // фильтруем по заданным условиям
                .map(String::toUpperCase) // преобразует каждый элемент (все заглавными буквами)
                .sorted() // сортируем по алфавиту
                .collect(Collectors.toList()); // собираем данные в коллекцию
        System.out.println(result);

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        int n = 0;
        for (int num : numbers){
            n += num;
        }
        System.out.println(n);

        int totalSum = numbers.stream() // открывает поток и берет доступ к элементам
                .mapToInt(num -> num) // преобразует в примитив
                .sum(); // суммирует все значения
        System.out.println(totalSum);

        int totalElements = (int) numbers.stream()
                .count(); // подсчитывает количество элементов
        System.out.println(totalElements);

        numbers.stream().min(Integer::compareTo)
                .ifPresent(System.out::println);

        List<String> list = List.of("one", "two", "three", "Hello", "four", "five");

        // вывести только элемент у которого длина больше 3 символов и вывести первый
        list.stream()
                .filter(s -> s.length() > 3)
                .findFirst()
                .ifPresent(System.out::println);

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

        // отсортировать по отделу
        List<Employee> itEmployees = employees.stream()
                .filter(employee -> employee.getDepartment().equalsIgnoreCase("IT"))
                .collect(Collectors.toList());
        System.out.println(itEmployees);

        System.out.println("------For each-----");

        List<Employee> itEmployee2 = new ArrayList<>();
        for (Employee employee : employees){
            if (employee.getDepartment().equalsIgnoreCase("IT")){
                itEmployee2.add(employee);
            }
        }
        System.out.println(itEmployee2);

        System.out.println("-------call IT-------");
        employees.stream()
                .filter(employee -> employee.getDepartment().equalsIgnoreCase("IT")).forEach(System.out::println);

        System.out.println("----------Map Stream Addition--------");
        // сгруппировать сотрудников по отделам
        Map<String, List<Employee>> employeesByDepartment = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));

        employeesByDepartment.forEach((department, list1) -> {
            System.out.println("Отдел " + department);
            list1.forEach(System.out::println);
        });

        System.out.println("----------without Stream------------");
        Map<String, List<Employee>> employeesByDepartment2 = new HashMap<>();

        for (Employee employee : employees){
            employeesByDepartment2.putIfAbsent(employee.getDepartment(), new ArrayList<>());
            employeesByDepartment2.get(employee.getDepartment()).add(employee);
        }

        for (Map.Entry<String, List<Employee>> entry: employeesByDepartment2.entrySet()){
            System.out.println(entry.getKey() + "\n" + entry.getValue());
        }




       }
    }

