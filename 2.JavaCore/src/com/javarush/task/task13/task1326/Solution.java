package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileInputStream fileReader= new FileInputStream(reader.readLine());


        int intFromFile;
        ArrayList<Integer> arrayList = new ArrayList<Integer>();

        while ((intFromFile = fileReader.read()) != -1){
            if (intFromFile != 10) {
                    StringBuilder str = new StringBuilder();
                    for (;intFromFile != 10;){
                        str.append((char) intFromFile);
                        intFromFile = fileReader.read();
                        if (intFromFile == -1){
                            break;
                        }
                    }
                    if (Integer.parseInt(str.toString()) % 2 == 0){
                        arrayList.add(Integer.parseInt(str.toString()));
                    }
                }
            }

        for (int i = 0; i < arrayList.size(); i++) {
            for (int j = 0; j < arrayList.size()-1; j++) {
                if (arrayList.get(i) < arrayList.get(j)){
                    int temp = arrayList.get(i);
                    arrayList.set(i, arrayList.get(j));
                    arrayList.set(j, temp);
                }
            }
        }

        arrayList.forEach(System.out::println);

        reader.close();
        fileReader.close();

    }
}
