package com.javarush.task.task37.task3703;

import java.util.concurrent.ConcurrentSkipListMap;

/*
Найти класс по описанию Ӏ Java Collections: 7 уровень, 6 лекция
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getExpectedClass());
    }

    public static Class getExpectedClass() {
        return new ConcurrentSkipListMap<>().getClass();
    }
}
