package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) {
        if (string == null || string.isEmpty() || string.split(" ").length < 5) {
                throw new TooShortStringException();
        }

        String[] strings = string.split(" ");
        return strings[1] + " " + strings[2] + " " + strings[3] + " " + strings[4];
    }

    public static class TooShortStringException extends RuntimeException {

    }
}
