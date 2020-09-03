package com.javarush.task.task10.task1012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

import static java.util.Map.Entry.comparingByKey;
import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;

/* 
Количество букв
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Алфавит
        List<Character> alphabet = Arrays.asList(
                'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж',
                'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о',
                'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц',
                'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я');

        // Ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            String s = reader.readLine();
            list.add(s.toLowerCase());
        }

        // напишите тут ваш код
        HashMap<Character, Integer> charCount = new HashMap<>(33);

        for (int i = 0; i < alphabet.size(); i++) {
            charCount.put(alphabet.get(i), 0);
        }



        for (int j = 0; j < list.size(); j++) {
                char[] strArray = list.get(j).toCharArray();

                for (char c : strArray){
                    if (charCount.containsKey(c)){
                        charCount.put(c, charCount.get(c) + 1);
                    }
                }
            }

        for (Character c : alphabet){
            if (charCount.containsKey(c)){
                System.out.println(c + " " + charCount.get(c));
            }
        }

        //charCount.forEach((key, value) -> System.out.println(key + " " + value));
    }
}
