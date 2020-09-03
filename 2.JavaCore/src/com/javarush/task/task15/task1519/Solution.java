package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.SocketHandler;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напиште тут ваш код

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String key = null;
        while (!(key = reader.readLine()).equals("exit")) {
                try {
                    if (!key.contains(".")) {
                        throw new NumberFormatException();
                    }
                    Double valIsDouble = Double.parseDouble(key);
                    print(valIsDouble);
                } catch (NumberFormatException e) {
                    try {
                        short valIsShort = Short.parseShort(key);
                        if (!(valIsShort > 0 && valIsShort < 128)) {
                            throw new NumberFormatException();
                        }
                        print(valIsShort);
                    } catch (NumberFormatException e1) {
                        try {
                            Integer valIsInteger = Integer.parseInt(key);
                            print(valIsInteger);
                        }
                        catch (NumberFormatException e2) {
                            print(key);
                        }
                    }
                }
        }
        reader.close();
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
