package com.javarush.task.task18.task1825;

/* 
Собираем файл
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        HashMap<Integer, String> parts = new HashMap<>();
        String addres = null;
        String name = null;

        while (!(addres = reader.readLine()).equals("end")) {
            parts.put(Integer.parseInt(addres.replaceAll(".*(?<=part)", "")), addres);
            name = addres.substring(0, addres.lastIndexOf(".part"));
        }
        FileOutputStream fileOutputStream = new FileOutputStream(name);

        ArrayList<Integer> sortedKeys=new ArrayList(parts.keySet());
        Collections.sort(sortedKeys);
        for (Integer part : sortedKeys) {
            FileInputStream fileInputStream = new FileInputStream(parts.get(part));
            byte[] buffer = new byte[fileInputStream.available()];
            fileInputStream.read(buffer);
            fileOutputStream.write(buffer);
            fileInputStream.close();
        }

        fileOutputStream.close();
        reader.close();
    }
}
/*
D:\downloads\project\JavaRushTasks\Lion.txt.part6
D:\downloads\project\JavaRushTasks\Lion.txt.part37
D:\downloads\project\JavaRushTasks\Lion.txt.part1*/
