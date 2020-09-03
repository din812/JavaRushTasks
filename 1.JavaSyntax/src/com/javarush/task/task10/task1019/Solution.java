package com.javarush.task.task10.task1019;



/* 
Функциональности маловато!
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, Integer> hashMap = new HashMap<>();

        int id;
        String name;

        try {
            while (true) {
                id = Integer.parseInt(reader.readLine());
                name = reader.readLine();
                hashMap.put(name, id);
            }
        }
        catch (NumberFormatException e){
        }
        hashMap.forEach((key, value) -> System.out.println(value + " " + key));
    }
}
