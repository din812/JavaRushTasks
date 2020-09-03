package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream1 = new FileInputStream(reader.readLine());
        FileOutputStream writer = null;


        ArrayList<Byte> list = new ArrayList<>();

        while (inputStream1.available() > 0) {
            list.add((byte) inputStream1.read());
        }
        Collections.reverse(list);

        File fw = new File(reader.readLine());
        writer = new FileOutputStream(fw);
        for (int i = 0; i < list.size(); i++) {
            writer.write(list.get(i));
        }

        reader.close();
        inputStream1.close();
        writer.close();
    }
}
