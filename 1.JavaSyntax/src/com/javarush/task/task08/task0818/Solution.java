package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static Map<String, Integer> createMap() {
        //напишите тут ваш код
        Map<String, Integer> stringIntegerMap = new HashMap<>();
        stringIntegerMap.put("Volodin", 69);
        stringIntegerMap.put("Volodin1", 50);
        stringIntegerMap.put("Volodin2", 69);
        stringIntegerMap.put("Volodin3", 697);
        stringIntegerMap.put("Volodin4", 694);
        stringIntegerMap.put("Volodin5", 69);
        stringIntegerMap.put("Volodin6", 69);
        stringIntegerMap.put("Volodin7", 6569);
        stringIntegerMap.put("Volodin8", 694);
        stringIntegerMap.put("Volodin9", 695);
        return stringIntegerMap;
    }

    public static void removeItemFromMap(Map<String, Integer> map) {
        //напишите тут ваш код
            map.entrySet().removeIf(e -> e.getValue() < 500);
           // System.out.println(map.keySet() + "/" + map.values());
        //return map;
    }

    public static void main(String[] args) {
    //removeItemFromMap(createMap());
    }
}