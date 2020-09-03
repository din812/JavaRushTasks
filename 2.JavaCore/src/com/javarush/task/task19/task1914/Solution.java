package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);

        System.setOut(stream);

        testString.printSomething();

        String original = outputStream.toString().replaceAll("\\r\\n", "");
        String[] result = outputStream.toString().split(" ");

        System.setOut(consoleStream);

        switch (result[1]) {
            case "+":
                System.out.print(original + (Integer.parseInt(result[0]) + Integer.parseInt(result[2])));
                break;
            case "-":
                System.out.print(original + (Integer.parseInt(result[0]) - Integer.parseInt(result[2])));
                break;
            case "*":
                System.out.print(original + (Integer.parseInt(result[0]) * Integer.parseInt(result[2])));
                break;
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

