package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        FileInputStream fileInputStream1 = new FileInputStream(fileName1);

        ArrayList<Byte> file1 = new ArrayList<Byte>();

        while (fileInputStream1.available() > 0) {
            file1.add((byte) fileInputStream1.read());
        }
        FileOutputStream fileOutputStream1 = new FileOutputStream(fileName1); // запись
        FileInputStream fileInputStream2 = new FileInputStream(fileName2); // чтение
        while (fileInputStream2.available() > 0){
            fileOutputStream1.write(fileInputStream2.read());
        }

        for (int i = 0; i < file1.size(); i++) {
            fileOutputStream1.write(file1.get(i));
        }

        fileOutputStream1.close();
        fileInputStream2.close();
        fileInputStream1.close();
        reader.close();
    }
}
