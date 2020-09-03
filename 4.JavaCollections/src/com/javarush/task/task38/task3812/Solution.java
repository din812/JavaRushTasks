package com.javarush.task.task38.task3812;

/* 
Обработка аннотаций
*/

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        printFullyQualifiedNames(Solution.class);
        printFullyQualifiedNames(SomeTest.class);

        printValues(Solution.class);
        printValues(SomeTest.class);
    }

    public static boolean printFullyQualifiedNames(Class c) {
        if (!c.isAnnotationPresent(PrepareMyTest.class)) {
            return false;
        }

        PrepareMyTest annotation = (PrepareMyTest) c.getAnnotation(PrepareMyTest.class);

        Arrays.stream(annotation.fullyQualifiedNames()).forEach(System.out::println);
        return true;
    }

    public static boolean printValues(Class c) {
        if (!c.isAnnotationPresent(PrepareMyTest.class)) {
            return false;
        }

        PrepareMyTest annotation = (PrepareMyTest) c.getAnnotation(PrepareMyTest.class);

        Arrays.stream(annotation.value()).forEach(System.out::println);
        return true;
    }
}
