package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fin = new FileInputStream(args[0]);

        HashMap<Character, Integer> symbols = new HashMap<>();
        char key;

        while (fin.available() > 0) {
            key = (char) fin.read();
            if (!symbols.containsKey(key)) {
                symbols.put(key, 1);
            } else {
                symbols.replace(key, symbols.get(key).intValue() +1);
            }
        }

        ArrayList<Character> sortedKeys=new ArrayList(symbols.keySet());
        Collections.sort(sortedKeys);

        for (Character chars: sortedKeys) {
            System.out.println(chars + " " + symbols.get(chars));
        }

        fin.close();
    }
}
