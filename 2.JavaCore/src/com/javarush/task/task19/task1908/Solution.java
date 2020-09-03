package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fr = new BufferedReader(new FileReader(reader.readLine()));
        BufferedWriter fw = new BufferedWriter(new FileWriter(reader.readLine()));


        StringBuilder strBuilder = new StringBuilder();
        int data = 0;
        while ((data = fr.read()) != -1) {
            strBuilder.append((char) data);
        }

        String[] temp = strBuilder.toString().trim().split(" ");
        int count = 0;
        for (int i = 0; i < temp.length; i++) {
            if (temp[i].matches("\\d*")) {
                fw.append(temp[i]).append(" ");
            }
        }

        reader.close();
        fr.close();
        fw.close();
    }
}
