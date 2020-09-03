package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());
        FileOutputStream fileOutputStream;

        byte[] firstHalf = new byte[inputStream.available() / 2];
        fileOutputStream = new FileOutputStream(reader.readLine());
        for (;firstHalf.length < inputStream.available();) {
            int data = inputStream.read();
            fileOutputStream.write(data);

        }
        fileOutputStream = new FileOutputStream(reader.readLine());

        while (inputStream.available() > 0) {
            int data1 = inputStream.read();
            fileOutputStream.write(data1);
        }
        reader.close();
        inputStream.close();
        fileOutputStream.close();
        fileOutputStream.close();
    }
}
