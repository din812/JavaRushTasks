package com.javarush.task.task18.task1805;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
/* 
Сортировка байт
*/

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

        List sortedKeys=new ArrayList(counts.keySet());
        Collections.sort(sortedKeys);

        for (int i = 0; i < sortedKeys.size(); i++) {
            System.out.print(sortedKeys.get(i) + " ");
        }

        reader.close();
        inputStream.close();
    }
}
