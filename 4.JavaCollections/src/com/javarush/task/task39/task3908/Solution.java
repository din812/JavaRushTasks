package com.javarush.task.task39.task3908;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/*
Возможен ли палиндром?
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(isPalindromePermutation("sss"));
    }

    public static boolean isPalindromePermutation(String s) {
        HashMap<Character, Integer> parts = new HashMap<>();
        for (Character ch :
            s.toLowerCase().toCharArray()) {
            parts.computeIfPresent(ch, (character, integer) -> integer + 1);
            parts.computeIfAbsent(ch, character -> parts.put(ch, 1));
        }

        AtomicInteger oneOcc = new AtomicInteger(0);
        AtomicInteger oddOcc = new AtomicInteger(0);
        parts.forEach((character, integer) -> {
            if (integer == 1) {
                oneOcc.getAndIncrement();
            }
            if (integer % 2 != 0) {
                oddOcc.getAndIncrement();
            }
        });

        if (oneOcc.get() > 1 || oddOcc.get() > 1) {
            return false;
        }

        return true;
    }
}
