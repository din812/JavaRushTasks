package com.javarush.task.task08.task0802;

/* 
Map из 10 пар
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Map<String, String> stringStringMap = new HashMap<>();
        stringStringMap.put("арбуз", "ягода");
        stringStringMap.put("банан", "трава");
        stringStringMap.put("вишня", "ягода");
        stringStringMap.put("груша", "фрукт");
        stringStringMap.put("дыня", "овощ");
        stringStringMap.put("ежевика", "куст");
        stringStringMap.put("жень-шень", "корень");
        stringStringMap.put("земляника", "ягода");
        stringStringMap.put("ирис", "цветок");
        stringStringMap.put("картофель", "клубень");

        for (Map.Entry<String, String> pair :stringStringMap.entrySet()){
            String key = pair.getKey();
            String value = pair.getValue();
            System.out.println(key + " - " + value);
        }

    }
}
