package com.autoBots.java.streamApi;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMap {
    public static void main(String[] args) {

        List<List<String>> nestedList = List.of(
                List.of("A", "B"),
                List.of("C", "D"),
                List.of("E")
        );
        System.out.println(nestedList);
        // нужно преобразовать вложенный лист в один лист
        System.out.println("----For each---");
        List<String> newList = new ArrayList<>();
        for (List<String> list : nestedList){
           newList.addAll(list);
        }
        System.out.println(newList);
        System.out.println("----StreamApi---");

        List<String> newList1 = nestedList.stream()
                .flatMap(List::stream)// только для вложенных мар и листов
                .collect(Collectors.toList());
        System.out.println(newList1);

        List<String> names = List.of("Anna", "Bob", "Alex", "Bella", "Andrew");
    }
}
