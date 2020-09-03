package com.javarush.task.task10.task1006;

/* 
Задача №6 на преобразование целых типов
*/

public class Solution {
    public static void main(String[] args) {
        double d = (int) 2.50256e2d;
        char c = (byte) 'd';
        short s = (byte) 2.22;
        int i = 150000;
        float f = (short) 0.50f;
        double result = (int) f + (i / c) - (int) (d * s) - (int) 500e-3;
        System.out.println("result: " + result);
    }
}