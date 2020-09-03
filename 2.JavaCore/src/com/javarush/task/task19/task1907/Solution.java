package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.*;
import java.nio.CharBuffer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        reader.close();

        FileReader fr = new FileReader(file1);
        StringBuilder strBuilder = new StringBuilder();
        int data = 0;
        while ((data = fr.read()) != -1) {
            strBuilder.append((char) data);
        }
        fr.close();

        String[] temp = strBuilder.toString().toLowerCase().split("\\W");
        int count = 0;
        for (int i = 0; i < temp.length; i++) {
            if (temp[i].equals("world")) {
                count++;
            }
        }

        System.out.println(count);
    }
}
