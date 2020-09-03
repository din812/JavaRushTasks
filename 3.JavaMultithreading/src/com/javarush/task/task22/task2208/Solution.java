package com.javarush.task.task22.task2208;

import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {
        /*Map<String,String> map = new LinkedHashMap<>() {{
            put("name", "Ivanov");
            put("country", "Ukraine");
            put("city", "Kiev");
            put("age", null);
        }};

        System.out.println(getQuery(map));*/
    }

    public static String getQuery(Map<String, String> params) {
        StringBuilder stringBuilder = new StringBuilder();

        for (Map.Entry<String, String> key : params.entrySet()) {
            if (key.getValue() != null) {
                stringBuilder.append(key.getKey() + " = " + "'" + key.getValue() + "'" + " and ");
            }
        }
        if (stringBuilder.length() > 0) {
            return stringBuilder.delete(stringBuilder.length() - 5, stringBuilder.length()).toString();
        }
        return "";
    }
}
