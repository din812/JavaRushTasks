package com.javarush.task.task28.task2803;

import java.util.concurrent.ThreadLocalRandom;

/*
ThreadLocalRandom
*/
public class Solution {
    public static int getRandomIntegerBetweenNumbers(int from, int to) {
        return ThreadLocalRandom.current().nextInt(to - from + 1) + from;
    }

    public static double getRandomDouble() {
        return ThreadLocalRandom.current().nextDouble();
    }

    public static long getRandomLongBetween0AndN(long n) {
        return ThreadLocalRandom.current().nextLong(0, n);
    }

    public static void main(String[] args) {
        System.out.println(getRandomDouble());
        System.out.println(getRandomIntegerBetweenNumbers(0, 10));
        System.out.println(getRandomLongBetween0AndN(2525252524L));
    }
}
