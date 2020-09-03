package com.javarush.task.task13.task1319;

/* 
Писатель в файл с консоли
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(reader.readLine()));

        ArrayList<String> strings = new ArrayList<String>();

        while (!strings.contains("exit")){
            strings.add(reader.readLine());
        }

        for (String string: strings){
            bufferedWriter.write(string+"\n");
        }


        reader.close();
        bufferedWriter.close();
    }
}
