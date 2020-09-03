package com.javarush.task.task08.task0815;

import java.util.*;

/* 
Перепись населения
*/

public class Solution {
    public static Map<String, String> createMap() {
        //напишите тут ваш код
        Map<String, String> stringStringMap = new HashMap<>();
        stringStringMap.put("Volodin", "Kirill");
        stringStringMap.put("Yakimov", "Sergey");
        stringStringMap.put("Volodinw", "Kirill");
        stringStringMap.put("Volodinq", "Kirill");
        stringStringMap.put("Yakimove", "Kirill");
        stringStringMap.put("Volodinr", "Kirill");
        stringStringMap.put("Volodinui", "Sergei");
        stringStringMap.put("Volodiny", "Kirill");
        stringStringMap.put("Volodinu", "Kirill");
        stringStringMap.put("Volodini", "Kirill");
        return stringStringMap;
    }

    public static int getCountTheSameFirstName(Map<String, String> map, String name) {
        //напишите тут ваш код
        return Collections.frequency(map.values(), name);
    }

    public static int getCountTheSameLastName(Map<String, String> map, String lastName) {
        //напишите тут ваш код
        return Collections.frequency(map.keySet(), lastName);
    }

    public static void main(String[] args) {
        //Map <String,String> map = createMap();
       // System.out.println(map);
        //System.out.println(getCountTheSameFirstName(map,"Kirill"));
       //System.out.println(getCountTheSameLastName(map,"Volodin"));
    }
}
