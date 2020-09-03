package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));

        String line;
        HashMap<String, Double> payList = new HashMap<>();


        while ((line = reader.readLine()) != null) {
            payList.merge(line.replaceAll("[\\d?\\.?\\-]", "").trim(),
                        Double.parseDouble(line.replaceAll("[^\\d?\\.?-]", "")), Double::sum);
        }

        reader.close();

        Map<String, Double> sortedByCount = payList.entrySet()
                .stream()
                .sorted((Map.Entry.<String, Double>comparingByKey().reversed()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        sortedByCount.forEach((key, value) -> System.out.println(key + " " + value));
    }
}
