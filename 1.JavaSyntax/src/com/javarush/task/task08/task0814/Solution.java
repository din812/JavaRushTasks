package com.javarush.task.task08.task0814;

import java.util.HashSet;
import java.util.Set;

/* 
Больше 10? Вы нам не подходите
*/

public class Solution {
    public static Set<Integer> createSet() {
        // напишите тут ваш код
        Set<Integer> integerSet = new HashSet<Integer>();
        integerSet.add(1);
        integerSet.add(27);
        integerSet.add(3457);
        integerSet.add(4547);
        integerSet.add(5);
        integerSet.add(64645);
        integerSet.add(7);
        integerSet.add(88);
        integerSet.add(9);
        integerSet.add(10);
        integerSet.add(11);
        integerSet.add(12);
        integerSet.add(13);
        integerSet.add(14);
        integerSet.add(15);
        integerSet.add(16);
        integerSet.add(17);
        integerSet.add(18);
        integerSet.add(19);
        integerSet.add(20);
        return integerSet;
    }

    public static Set<Integer> removeAllNumbersGreaterThan10(Set<Integer> set) {
        // напишите тут ваш код
        set.removeIf(integer -> integer > 10);
        return set;
    }

    public static void main(String[] args) {
     //   System.out.println(removeAllNumbersGreaterThan10(createSet()));
    }
}
