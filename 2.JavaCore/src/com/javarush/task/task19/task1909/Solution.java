package com.javarush.task.task19.task1909;

/* 
Замена знаков
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

        fw.write(strBuilder.toString().replaceAll("\\.",  "!"));

        reader.close();
        fr.close();
        fw.close();
    }
}
