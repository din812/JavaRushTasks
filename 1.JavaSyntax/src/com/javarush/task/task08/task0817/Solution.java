package com.javarush.task.task08.task0817;

import java.util.*;

/*
Нам повторы не нужны
*/

public class Solution {
    public static Map<String, String> createMap() {
        //напишите тут ваш код
        Map<String, String> stringStringMap = new HashMap<>();
        stringStringMap.put("volodin1", "kirill");
        stringStringMap.put("volodin2", "kirill2");
        stringStringMap.put("volodin3", "kirill3");
        stringStringMap.put("volodin4", "kirill4");
        stringStringMap.put("volodin5", "kirill");
        stringStringMap.put("volodin6", "kirill");
        stringStringMap.put("volodin7", "kirill5");
        stringStringMap.put("volodin8", "kirill5");
        stringStringMap.put("volodin9", "kirill");
        stringStringMap.put("volodin10", "kirill");
        //removeTheFirstNameDuplicates(stringStringMap);
        return stringStringMap;
    }

    public static void removeTheFirstNameDuplicates(Map<String, String> map) {
        //напишите тут ваш код
        ArrayList<String> list = new ArrayList<>(map.values());
        for (int i = 0; i < list.size()-1; i++) {
            for (int j = i+1; j < list.size(); j++) {
                if (list.get(i).equals(list.get(j))){
                    removeItemFromMapByValue(map, list.get(i));
                }
            }
        }
    }

    public static void removeItemFromMapByValue(Map<String, String> map, String value) {
        Map<String, String> copy = new HashMap<>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value)) {
                map.remove(pair.getKey());
            }
        }
        //System.out.println(copy);
    }

    public static void main(String[] args) {
    //createMap();
    }
}
