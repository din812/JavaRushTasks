package com.javarush.task.task19.task1922;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
        String line;



        while ((line = fileReader.readLine()) != null) {
            int count = 0;
            for (String word : words) {
                Pattern p = Pattern.compile("\\b"+word+"\\b");
                Matcher m = p.matcher(line);
                if (m.find()) count++;
            }

            if (count == 2) {
                System.out.println(line);
            }
        }
        reader.close();
        fileReader.close();
    }
}
