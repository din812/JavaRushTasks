package com.javarush.task.task15.task1527;

/* 
Парсер реквестов
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;


public class Solution {
    public static void main(String[] args) {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            ArrayList<String> list = new ArrayList<>();
            Double doubleTemp;
            String stringTemp;
            String url = reader.readLine();

            url = url.replaceAll(".+\\?", "");
            list.addAll(0, Arrays.asList((url.split("\\&"))));

            for (String s : list) {
                System.out.print(s.split("\\=")[0] + " ");
            }

            for (String s : list) {
                if (s.contains("obj")) {
                    try {
                        doubleTemp = Double.parseDouble(s.split("\\=")[1]);
                        alert(doubleTemp);
                    } catch (NumberFormatException e) {
                        stringTemp = s.split("\\=")[1];
                        alert(stringTemp);
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void alert(double value) {
        System.out.println("\n" +"double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
