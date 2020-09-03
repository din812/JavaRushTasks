package com.javarush.task.task18.task1804;

/* 
Самые редкие байты
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());

        ArrayList<Byte> list = new ArrayList<>();

        while (inputStream.available() > 0) {
            list.add((byte) inputStream.read());
        }

        Map<Byte, Long> counts =
                list.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));

        Optional<Map.Entry<Byte, Long>> minEntry = counts.entrySet()
                .stream()
                .min(Map.Entry.comparingByValue()
                );

        Iterator it = counts.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            if (minEntry.get().getValue() == pair.getValue()) {
                System.out.print(pair.getKey()+ " ");
            }
        }

        reader.close();
        inputStream.close();
    }
}
