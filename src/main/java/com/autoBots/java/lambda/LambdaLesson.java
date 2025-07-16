package com.autoBots.java.lambda;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LambdaLesson {

    public static void main(String[] arg){

        MathOperation addition = (a, b) -> a + b; // анонимные функции
        MathOperation multi = (a, b) -> a * b;

        System.out.println("5 + 3 = " + addition.operation(5, 3));
        System.out.println("5 * 3 = " + multi.operation(5, 3));

        Predicate<String> isNotEmpty = s -> !s.isEmpty(); // этот метод принимает Обьект и возвращает значение boolean
        System.out.println(isNotEmpty.test(""));
        System.out.println(isNotEmpty.test("Java"));

        Function<Integer, String> toStringFun = i -> "Число: " + i; //
        System.out.println(toStringFun.apply(10));

        Consumer<String> print = s -> System.out.println("Writing: " + s);
        print.accept("Hello World");


    }
}
